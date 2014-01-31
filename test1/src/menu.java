import javax.swing.*;

import java.awt.event.*;
import java.awt.BorderLayout;

import java.io.File;




public class menu {

	
	
	public static void main(String[] args)
	{
		JFrame frame=new JFrame("Menu Test");
		frame.setVisible(true);
		frame.setSize(400,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JMenuBar menuBar=new JMenuBar();
		frame.setJMenuBar(menuBar);
			
		JMenu file=new JMenu("File");
		JMenu help=new JMenu("Help");
		
		JMenuItem open=new JMenuItem("Open");
		JMenuItem exit=new JMenuItem("Exit");
		JMenuItem about=new JMenuItem("About");
		
		menuBar.add(file);
		menuBar.add(help);
		
		file.add(open);
		file.add(exit);
		help.add(about);
		
		
		class aboutAction implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				Sign_TB app=new Sign_TB();
				app.sign();
				//JOptionPane.showMessageDialog(null,"Thodoris Bais","Developer",JOptionPane.INFORMATION_MESSAGE);
			}
		}
		class exitAction implements ActionListener
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
			
		}
		class openAction implements ActionListener
		{
			private String name;
			public void actionPerformed(ActionEvent e)
			{
				FileDemonstration obj=new FileDemonstration();
				
				//File name= obj.getFileOrDirectory();
			
			}
			
		}
		
		
		exit.addActionListener(new exitAction());
		about.addActionListener(new aboutAction());
		open.addActionListener(new openAction());
	}
}
