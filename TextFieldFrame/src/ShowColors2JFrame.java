import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JColorChooser;
import java.awt.Color;

public class ShowColors2JFrame extends JFrame{

	private JButton changeColorJButton;
	private Color color = Color.LIGHT_GRAY;
	private JPanel panel;
	
	
	public ShowColors2JFrame()
	{
		super("Using JColorChooser");
		
		panel = new JPanel();
		panel.setBackground(color);
		
		//formatting changeColorButton and recording the evnt handler
		changeColorJButton = new JButton("Change Color");
		changeColorJButton.addActionListener
		(
			new ActionListener()	//anonymous internal class
			{
				public void actionPerformed(ActionEvent event)
				{
					//3RD ARGUMENT DEFINES THE SELECTED COLOR THAT WILL BE SHOWN @ DIALOG WINDOW
					color = JColorChooser.showDialog(ShowColors2JFrame.this,"Choose a color", Color.MAGENTA);
					
					if(color == null)
					{
						color = Color.LIGHT_GRAY;
					}
					
					panel.setBackground(color);
				}
			}
				
		);
		
		
		add(panel,BorderLayout.CENTER);
		add(changeColorJButton,BorderLayout.SOUTH);
		setSize(400,130);
		setVisible(true);
		
	}
}
