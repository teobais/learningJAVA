package edu.theo.chat;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Server extends JFrame{

	private JTextField userText;
	private JTextArea chatWindow;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private ServerSocket server;
	private Socket connection;
	
	//constructor
	public Server()
	{
		
		super("Super Messenger");
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
		add(new JScrollPane(chatWindow));
		setSize(300,150);
		setVisible(true);
		
	}
	
	//set up and run the server
	public void startRunning()
	{
		try
		{
			server = new ServerSocket(6789, 100);
			while(true)
			{
				try
				{
					//connect & have conversation
					waitForConnection();
					setupStreams();
					whileChatting();
					
				}catch(EOFException eofException)
				{
					showMessage("\nServer ended the connection!");
				}
				finally
				{
					closeCrap();
				}
			}
		}catch(IOException ioException)
		{
			ioException.printStackTrace();
		}
		
	}
	
	//wait for connection, then display connection information
	private void waitForConnection() throws IOException
	{
		showMessage("Waiting for someone to connect...\n");
		connection = server.accept();
		showMessage(" Now connected to " + connection.getInetAddress().getHostName());
	}
	
	//get stream to send & receive data
	private void setupStreams() throws IOException
	{
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();
		input = new ObjectInputStream(connection.getInputStream());
		showMessage("\n Streams are now setup! \n");
	}
	
	//during chat conversation
	private void whileChatting() throws IOException
	{
		String message = " You are now connected! ";
		sendMessage(message);
		ableToType(true);
		
		do
		{
			try
			{
				message = (String) input.readObject();
				showMessage("\n" + message);
			}catch(ClassNotFoundException classNotFoundException)
			{
				showMessage("\n I don't know wtf user sent.");
			}
			//have a conversation
		}while(!message.equals("CLIENT - END"));
	}
	
	//close streams and sockets after you are done chatting
	private void closeCrap()
	{
		showMessage("\n Closing connections... \n");
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
	
	//send a message to client
	private void sendMessage(String message)
	{
		try
		{
			output.writeObject("SERVER - " + message);
			output.flush();
			showMessage("\nSERVER - " + message);
		}catch(IOException ioException)
		{
			chatWindow.append("\n ERROR : I CANNOT SEND THIS MESSAGE!");
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
