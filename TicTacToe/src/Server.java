import java.awt.BorderLayout;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;
import java.util.Formatter;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Condition;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class Server extends JFrame{

	private String[] board = new String[9];	//pinakas trilizas
	private JTextArea outputArea;	//e3odos kinisewn
	private Player[] players;		//pinakas paiktwn
	private ServerSocket server;	//upodoxi server gia sundesi me pelati
	private int currentPlayer;		//parakolou9ei ton paikti gia tin trexousa kinisi
	private final static int PLAYER_X = 0;		//sta9era 1ou paiktiu
	private final static int PLAYER_O = 1;		//sta9era 2ou paikti
	private final static String[] MARKS =  {"X", "O"};
	private ExecutorService runGame;	//9a pai3oun oi paiktes
	private Lock gameLock;	//kleidwma paixnidiou gia sugxronismo
	private Condition otherPlayerConnected;	//anamoni gia ton allo paikti
	private Condition otherPlayerTurn;		//anamoni seiras allou paikti
	
	public Server()
	{
		super("Tic-Tac-Toe Server");
		
		//dimiourgia ExecutorService me ena nima gia ka9e paikti
		runGame = Executors.newFixedThreadPool(2); 		
		gameLock = new ReentrantLock();	//dimiourgia kleidiou gia to paixnidi
		
		//metavliti sun9ikis gia 2 paiktes pou 9a sunde9oun
		otherPlayerConnected = gameLock.newCondition();
		
		//metavliti sun9ikis gia ti seira tou allou paikti
		otherPlayerTurn = gameLock.newCondition();
		
		for(int i=0 ; i<9 ; i++)
			board[i] = new String("");	//dimiourgia pinaka trilizas
		
		players = new Player[2];	//dimiourgia pinaka paiktwn
		currentPlayer = PLAYER_X;	//kanei trexontaa paikti, ton 1o
		
		try
		{
			server = new ServerSocket(12345, 2);	//setting ServerSocket
		}
		catch(IOException ioE)
		{
			ioE.printStackTrace();
			System.exit(1);
		}
		
		outputArea = new JTextArea();
		add(outputArea,BorderLayout.CENTER);
		outputArea.setText("Server awaiting connections\n");
		
		setSize(300,300);
		setVisible(true);
	}
	
	public void execute()
	{
		//anamoni gia na sunde9ei ka9e pelatis
		for(int i=0 ; i < players.length ; i++)
		{
			try
			{
				players[i] = new Player(server.accept(), i);
				runGame.execute(players[i]);	//ektelesi player runnable
			}
			catch(IOException ioE)
			{
				ioE.printStackTrace();
				System.exit(1);
			}
		}
		
		gameLock.lock();	//kleidwma tou paixnidiou gia eidopoiisi tou nimatos tou paikti X
		
		try
		{
			players[PLAYER_X].setSuspended(false); //sunexizei me ton paikti X
			otherPlayerConnected.signal();		//3upnaei to nima tou paikti X
		}
		finally
		{
			gameLock.unlock();	//3ekleidwnei to paixnidi afou eidopoiisei ton paikti X
		}
	}
	
	private void displayMessage(final String msg)
	{
		//emfanisi mnmtos apo nima diavivasis sumvantos ektelesis
		SwingUtilities.invokeLater
		(
				new Runnable()
				{
					public void run()	//updates outputArea
					{
						outputArea.append(msg);
					}
				}
		);
	}
	
	public boolean validateAndMove(int location, int player)
	{
		//enw dn einai o trexwn paiktis, prepei na perimenei tin seira tou
		while(player != currentPlayer)
		{
			gameLock.lock();	//kleidwma paixnidiou gia anamoni tou allou paikti
			
			try
			{
				otherPlayerTurn.await();	//anamoni gia tin seira tou allou paikti
			}
			catch(InterruptedException ex)
			{
				ex.printStackTrace();
			}
			finally
			{
				gameLock.unlock();	//3ekleidwma paixnidiou meta tn anamoni
			}
		}
		
		//an dn einai kateilimmeni i 9esi, kanei kinisi
		if(!isOccupied(location))
		{
			board[location] =MARKS[currentPlayer];	//orizei tin kinisi ston pinaka
			currentPlayer = (currentPlayer + 1) % 2;	//allagi paikti
			
			//epitrepei ston trexonta paikti na gnwrizei poia kinisi egine
			players[currentPlayer].otherPlayerMoved(location);
			gameLock.lock();	//kleidwma paixnidiou gia eidopoiisi tou allou paikti na sunexisei
			
			try
			{
				otherPlayerTurn.signal();	//eidopoiei ton allo paikti na sunexisei
			}
			finally
			{
				gameLock.unlock();	//3ekleidwma paixnidiou meta tn eidopoiisi
			}
			return true;	//eidopoiei tn paikti oti i kinisi itan akuri
		}
		else	//i kinisi itan akuri
			return false;
	}
	
	public boolean isOccupied(int location)
	{
		if(board[location].equals(MARKS[PLAYER_X]) || board[location].equals(MARKS[PLAYER_O]))
			return true;
		else
			return false;
	}
	
	//na sumplirw9ei o kwdikas
	public boolean isGameOver()
	{
		return false;
		
	}
	
	
	
	//idiwtiki eswteriki klasi pou xeirizeai ka9e paikti ws runnable
	private class Player implements Runnable
	{
		private Socket connection;	//sundesi se client
		private Scanner input;	//eisodos apo pelati
		private Formatter output;	//e3odos pros pelati
		private int playerNumber;	//parakolou9isi paikti
		private String mark;	//simadi paikti
		private boolean suspended = true; //an to nima stamatise proswrina
		
		public Player(Socket socket, int number)
		{
			playerNumber = number;		//apo9ikevei ton ari9mo aftou tou paikti
			mark = MARKS[playerNumber];	//prosdiorizei to simadi tou paikti
			connection = socket;		//apo9ikevei upodoxi gia ton client
			
			try	//pairnei tis roes apo tin Socket
			{
				input = new Scanner(connection.getInputStream());
				output = new Formatter(connection.getOutputStream());
			}
			catch(IOException ioE)
			{
				ioE.printStackTrace();
				System.exit(1);
			}
		}

		//apostoli mnmtos oti ekane kini o allos paiktis
		public void otherPlayerMoved(int location)
		{
			output.format("Opponent moved\n");
			output.format("%d\n", location);	//apostoli 9esis kinisis
			output.flush();	//adeiasma e3odou
		}
		
		@Override
		public void run() {
			//apostoli ston pelati tou simadiou (X i O), epe3ergasia mnmtwn apo ton pelati
			try
			{
				displayMessage("Player " + mark + " connected\n");
				output.format("%s\n",mark);	//apostoli simadiou paikti
				output.flush();
				
				//an o paiktis X, perimenei na ftasei o allos paiktis
				if(playerNumber == PLAYER_X)
				{
					output.format("%s\n%s", "Player X connected", "Waiting for another player\n");
					output.flush();	//adeiasma e3odou
					
					gameLock.lock();	//kleidwma paixnidiou gia anamoni 2ou paikti
					try
					{
						while(suspended)
						{
							otherPlayerConnected.await();	//anamoni gia ton paikti O
						}
					}catch(InterruptedException ex)
					{
						ex.printStackTrace();
					}
					finally
					{
						gameLock.unlock();	//3ekleidwma paixnidiou meta to deftero paikti
					}
					
					//apostoli mnmtos oti sunde9ike o allos paiktis
					output.format("Other player connected.Your move.\n");
					output.flush();	//adeiasma e3odou
				}
				else
				{
					output.format("Player O connected, please wait\n");
					output.flush();	//adeiasma e3odou
				}
				
				//enw to paixnidi dn exei teleiwsei
				while(!isGameOver())
				{
					int location = 0;
					if(input.hasNext())
						location = input.nextInt();	//pairnei tin 9esi kinisis
					
					//elegxos gia egkuri kinisi
					if(validateAndMove(location, playerNumber))
					{
						displayMessage("\nlocation: " + location);
						output.format("Valid move.\n"); 	//eidopooiisi pelati
						output.flush();
					}
					else
					{
						output.format("Invalid move, try again.\n"); 	
						output.flush();
					}
				}
			}
			finally
			{
				try
				{
					connection.close();
				}
				catch(IOException ioE)
				{
					ioE.printStackTrace();
					System.exit(1);
				}
			}
			
		}
		
		//orizei an to nima eixe stamatisei proswrina
		public void setSuspended(boolean status)
		{
			suspended = status;	//orizei tin timi tis proswrinis pausis
		}
		
	}

	
}
