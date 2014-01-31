import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;
import javax.swing.JPanel;

public class DrawPanel extends JPanel{

	private  Random randomNumbers=new Random();
	private MyLine[] lines;		//array of lines
	
	//the constructor, creates a panel with random lines
	public DrawPanel()
	{
		setBackground(Color.WHITE);
		lines=new MyLine[5+randomNumbers.nextInt(5)];
		
		//creating lines
		for(int count=0;count<lines.length;count++)
		{
			//random coordinates
			int x1=randomNumbers.nextInt(300);
			int y1=randomNumbers.nextInt(300);
			int x2=randomNumbers.nextInt(300);
			int y2=randomNumbers.nextInt(300);
			
			//random color
			Color randomColor=new Color(randomNumbers.nextInt(256),randomNumbers.nextInt(256),
					randomNumbers.nextInt(256));
			
			//adding the created line to the "to be appeared" list
			lines[count]=new MyLine(x1,y1,x2,y2,randomColor);
		}
	}
	
	//drawing schemes, for each scheme array
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		//drawing lines
		for(MyLine line:lines)
			line.draw(g);
	}
}
