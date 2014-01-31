import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class LabelDemo {

	public static void main(String[] args)
	{
		//creates a label with plain text
		JLabel northLabel=new JLabel("North");
	
		//creates an Icon from an image that we can attach to a JLabel
		ImageIcon labelIcon=new ImageIcon("small.png");
		
		//creates an image label instead of a text label
		JLabel centerLabel=new JLabel(labelIcon);
		
		//creates another image label
		JLabel southLabel=new JLabel(labelIcon);
	
		//setting the label for text diplaying(as for as image)
		southLabel.setText("South");
		
		JFrame app=new JFrame();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//adding labels to JFrame
		//the second argument defines where at JFrame will the label be added
		app.add(northLabel,BorderLayout.NORTH);
		app.add(centerLabel,BorderLayout.CENTER);
		app.add(southLabel,BorderLayout.SOUTH);
		
		app.setSize(300,300);
		app.setVisible(true);
	}
}
