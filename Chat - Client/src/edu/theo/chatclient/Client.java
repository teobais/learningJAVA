package edu.theo.chatclient;

//we have a separate project for the client 'cause we want the Client class to be run from every pc

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Client extends JFrame{

	private JTextField userText;
	private JTextArea chatWindow;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private String message = "";
	private String serverIP;	//ip of the server
	private Socket connection;
	
	//constructor
	public Client(String host)
	{
		super("Client Window");
		serverIP = host;
		userText = new JTextField();
		userText.setEditable(false);
		userText.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						sendMessage(event.getActionCommand());
						userText.setText("");
					}
				}
				
				);
				add(userText, BorderLayout.NORTH);
				chatWindow = new JTextArea();
				add(new JScrollPane(chatWindow), BorderLayout.CENTER);
				setSize(300, 150);
				setVisible(true);
		
	}
	
	//connect to server
	public void startRunning()
	{
		try
		{
			connectToServer();
			setupStreams();
			whileChatting();
		}catch(EOFException eofException)
		{
			showMessage("\n Client terminated connection");
		}catch(IOException ioException)
		{
			ioException.printStackTrace();
		}finally
		{
			closeCrap();
		}
	}
	
	//connect to server
	private void connectToServer() throws IOException
	{
		showMessage("Attempting connection... \n");
		connection = new Socket(InetAddress.getByName(serverIP), 6789);
		showMessage("Connected to:" + connection.getInetAddress().getHostName());
	}
	
	//setup streams 4 sending & receiving msgs
	private void setupStreams() throws IOException
	{
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();
		input = new ObjectInputStream(connection.getInputStream());
		showMessage("\nYour streams are now set up.\n");
	}
	
	//while chatting with the Server class
	private void whileChatting() throws IOException
	{
		ableToType(true);
		do
		{
			try
			{
				message = (String) input.readObject();
				showMessage("\n"+message);
			}catch(ClassNotFoundException classNotFoundException)
			{
				showMessage("\nI don't know that object type.");
			}
		}while(!message.equals("SERVER - END"));
	}
	
	//closing streams and sockets
	private void closeCrap()
	{
		showMessage("\nClosing the application...");
		ableToType(false);
		
		try
		{
			output.close();
			input.close();
			connection.close();
		}catch(IOException ioException)
		{
			ioException.printStackTrace();
		}
	}
	
	//send msgs to server
	private void sendMessage(String message)
	{
		try
		{
			output.writeObject("CLIENT - " + message);
			output.flush();
			showMessage("\nCLIENT - " + message);
		}catch(IOException ioException)
		{
			chatWindow.append("\n something messed up sending messager to host!");
		}
	}
	
	//updates chatWindow
		private void showMessage(final String text)
		{
			//updating only a part of the window by creating a thread
			SwingUtilities.invokeLater
			(
					new Runnable()
					{
						public void run()
						{
							chatWindow.append(text);
						}
					}
			);
		}
		
		//let the user type stuff into their box
		private void ableToType(final boolean tof)
		{
			SwingUtilities.invokeLater
			(
					new Runnable()
					{
						public void run()
						{
							userText.setEditable(tof);
						}
					}
			);
		}
	
}
