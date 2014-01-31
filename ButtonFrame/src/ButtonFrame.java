import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class ButtonFrame extends JFrame{

	private JButton plainJButton;	//plain text button
	private JButton fancyJButton;	//icon button
	
	//ButtonFrame adds JButton to JFrame
	public ButtonFrame()
	{
		super("Testing Buttons");
		setLayout(new FlowLayout());	//defines frame's layout
		
		plainJButton=new JButton("Plain Button");	//button with plain text
		add(plainJButton);							//adds plainJButton to Frame
		
		Icon bug1=new ImageIcon(getClass().getResource("bug1.png"));
		Icon bug2=new ImageIcon(getClass().getResource("bug2.png"));
		fancyJButton=new JButton("Fancy Button",bug1);
		fancyJButton.setRolloverIcon(bug1);			//icon definition
		add(fancyJButton);							//adds fancyJButton to JFrame
		
		//creates a newButtonHandler for handling button events
		ButtonHandler handler=new ButtonHandler();
		fancyJButton.addActionListener(handler);
		plainJButton.addActionListener(handler);
	}//end of ButtonFrame constructor
	
	//handling button events internal class 
	private class ButtonHandler implements ActionListener
	{
		
		//button event handler
		public void actionPerformed(ActionEvent event)
		{
			JOptionPane.showMessageDialog(ButtonFrame.this,String.format("You pressed: %s", 
					event.getActionCommand()));
		}
	}
}
