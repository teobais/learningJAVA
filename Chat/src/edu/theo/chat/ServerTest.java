package edu.theo.chat;

import javax.swing.JFrame;

public class ServerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Server server = new Server();
		server.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		server.startRunning(); //this is the Server's class method that we need to be run always
	}

}
