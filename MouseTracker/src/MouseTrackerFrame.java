import java.awt.Color;
import java.awt.BorderLayout;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.Icon;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MouseTrackerFrame extends JFrame {

	private JPanel mousePanel;	//panel in which, mouse events will happen
	private JLabel statusBar;	//label that displays event information
	
	//this constructor defines the GUI and records mouse event handlers
	public MouseTrackerFrame()
	{
		super("Demonstrating Mouse Events");
		
		mousePanel=new JPanel();	//panel creation
		mousePanel.setBackground(Color.WHITE);	//defines background color
		add(mousePanel,BorderLayout.CENTER);	//adds the panel to JFrame
		
		statusBar=new JLabel("Mouse outside JPanel");
		add(statusBar,BorderLayout.SOUTH);		//adds the label to JFrame
		
		
		//creating and recording mouse event and motion listener
		MouseHandler handler=new MouseHandler();
		mousePanel.addMouseListener(handler);
		mousePanel.addMouseMotionListener(handler);
	}
	
	private class MouseHandler implements MouseListener,MouseMotionListener
	{
		//mouse event handlers
		//handling the event when mouse rapidly released after being pushed
		private int counter=0;
		private int drags=0;
		
		//Icon bug2=new ImageIcon(getClass().getResource("bug2.png"));
		
		public void mouseClicked(MouseEvent event)
		{
			counter+=1;
			statusBar.setText(String.format("Clicked at [%d, %d] | %d total clicks. ",event.getX(),event.getY(),counter));
		}
		
		//handling event if mouse is pressed
		public void mousePressed(MouseEvent event)
		{
			statusBar.setText(String.format("Pressed at [%d, %d]",event.getX(),event.getY()));
		}
		
		//releasing mouse after dragging
		public void mouseReleased(MouseEvent event)
		{
			statusBar.setText(String.format("Released at [%d, %d]",event.getX(),event.getY()));
		}
		
		//mouse entered the region
		public void mouseEntered(MouseEvent event)
		{
			statusBar.setText(String.format("Mouse entered at at [%d, %d]",event.getX(),event.getY()));
			mousePanel.setBackground(Color.GREEN);
		}
		
		//mouse is out of region
		public void mouseExited(MouseEvent event)
		{
			statusBar.setText("Clicked outside JPanel");
			mousePanel.setBackground(Color.WHITE);
			JOptionPane.showMessageDialog(null,"Thodoris Bais\n--\nICTE Undergraduate Student",
					"Developer Information",JOptionPane.INFORMATION_MESSAGE);
		}
		
		//handling MouseMotion events <== MouseMotionListeners
		//=====================================================
		public void mouseDragged(MouseEvent event)
		{
			statusBar.setText(String.format("Dragged at [%d, %d]",event.getX(),event.getY()));
		}
		
		public void mouseMoved(MouseEvent event)
		{
			statusBar.setText(String.format("Moved at [%d, %d]",event.getX(),event.getY()));
		}
		
	}
}
