package edu.theo.chatclient;

import javax.swing.JFrame;

public class ClientTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Client someone;
		someone = new Client("127.0.0.1");
		someone.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		someone.startRunning();
		
	}

}
