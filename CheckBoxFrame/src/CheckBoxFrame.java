import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JCheckBox;


public class CheckBoxFrame extends JFrame {

	private JTextField textField;	//emfanisi keimenou se diaforetika fonts
	private JCheckBox bold;			//using or not  bold writing
	private JCheckBox italic;		//using or not italics writing
	
	//constructor CheckBoxFrame adds JCheckBoxes to JFrame
	public CheckBoxFrame()
	{
		super("JCheckBox Test");
		setLayout(new FlowLayout());	//defines frame's layout
		
		//defines JTextFiled and its font
		textField=new JTextField("Watch the font style change",20);
		
		textField.setFont(new Font("Serif",Font.PLAIN,14));
		add(textField);		//adds textField to JFrame
		
		bold=new JCheckBox("Bold");			//creates bold check frame
		italic=new JCheckBox("Italic");		//creates italic writing
		
		//adding  the above 2 frames at JFrame
		add(bold);	
		add(italic);						
		
		//recording event handlers for JCheckBoxes
		CheckBoxHandler handler=new CheckBoxHandler();
		bold.addItemListener(handler);
		italic.addItemListener(handler);
	}//end of CheckBoxFrame constructor
	
	//private internal  class to handle ItemListener events
	private class CheckBoxHandler implements ItemListener
	{
		
		public void itemStateChanged(ItemEvent event)
		{
		//response to checkbox events
		Font font=null;		//saves the new font
		
		//determines which checkboxes that create a font, are selected
		if(bold.isSelected() && italic.isSelected())
			font=new Font("Serif",Font.BOLD + Font.ITALIC,14);
		else if(bold.isSelected())
			font=new Font("Serif",Font.BOLD,14);
		else if(italic.isSelected())
			font=new Font("Serif",Font.ITALIC,14);
		else
			font=new Font("Serif",Font.PLAIN,14);
		
		textField.setFont(font);	//sets textField's font
		}
	}
}
