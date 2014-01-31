package Maze;

import java.awt.Graphics;
import java.awt.event.*;
import java.awt.*;

import javax.swing.*;

public class Board extends JPanel implements ActionListener{

	private Timer timer;
	private Map m;
	
	public Board()
	{
		m = new Map();
		timer = new Timer(25,this);
		timer.start();
	}
	
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		repaint();
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		
		for(int y=0 ; y<14 ; y++)
		{
			for(int x = 0;x<14;x++)
			{
				if(m.getMap(x,y).equals("g"))
				{
					g.drawImage(m.getGrass(),x*30,y*29,null);
				}
				if(m.getMap(x,y).equals("w"))
				{
					g.drawImage(m.getWall(),x*43,y*33,null);
				}
				
			}
		}
	}
}
