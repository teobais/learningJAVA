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

public class Sign_TB{

	Icon bug2=new ImageIcon(getClass().getResource("bug2.png"));
	
	public void sign()
	{
		JOptionPane.showMessageDialog(null,"Thodoris Bais\n--\nICTE Undergraduate Student",
			"Developer Information",JOptionPane.INFORMATION_MESSAGE,bug2);
	}			
}
	
