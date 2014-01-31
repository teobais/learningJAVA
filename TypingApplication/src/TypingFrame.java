import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.JTextArea;
import java.awt.Color;

public class TypingFrame extends JFrame {

	private JLabel label;
	private JTextArea area1;
	private String info;
	private String note;
	private JTextField area2;
	private JPanel panel;
	
	public TypingFrame()
	{
		super("Testing Typing Application");
		info="Type some text using your keyboard.The keys you press will be displayed\n";
		note="Note: Clicking the buttons with your mouse will not perform any action.";
		
		panel=new JPanel();
		panel.setBackground(Color.BLUE);
		add(panel,BorderLayout.NORTH);
		
		area1 = new JTextArea(BorderLayout.NORTH);
		
		area1.setText(info+note);
		area1.setEnabled(false);
		area1.setDisabledTextColor(Color.RED);
		
		
		area2 = new JTextField("PAOK",100);
		area2.setEditable(false);
		add(area1);
		add(area2);
		
	}
}
