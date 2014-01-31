import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class RadioButtonFrame extends JFrame{

	private JTextField txtField;
	private Font plaintxt;
	private Font italic;
	private Font bold;
	private Font boldItalic;
	
	//RadioButtons
	private JRadioButton plainJRadioButton;
	private JRadioButton boldJRadioButton;
	private JRadioButton italicJRadioButton;
	private JRadioButton boldItalicJRadioButton;
	private ButtonGroup radioGroup;		//button group for selection buttons
	
	//constructor RadioButtonFrame adds JRadioButtons to Frame
	public RadioButtonFrame()
	{
		super("RadioButton Test");
		setLayout(new FlowLayout());	//defines the frame's layout
		
		txtField=new JTextField("Watch the font style change",25);
		add(txtField);					//adds txtField to JFrame
		
		//creating selection buttons
		plainJRadioButton=new JRadioButton("Plain",false);
		boldJRadioButton=new JRadioButton("Bold",false);
		italicJRadioButton=new JRadioButton("Italic",true);
		boldItalicJRadioButton=new JRadioButton("Bold/Italic",false);
		
		//adding buttons to JFrame
		add(plainJRadioButton);
		add(boldJRadioButton);
		add(italicJRadioButton);
		add(boldItalicJRadioButton);
		
		//creating logic relationship between JRadioButtons
		radioGroup=new ButtonGroup();	//creates a ButtonGroup
		
		//adding  buttons to group
		radioGroup.add(plainJRadioButton);
		radioGroup.add(boldJRadioButton);
		radioGroup.add(italicJRadioButton);
		radioGroup.add(boldItalicJRadioButton);
	
		//creating font objects
		plaintxt=new Font("Serif",Font.PLAIN,14);
		bold=new Font("Serif",Font.BOLD,14);
		italic=new Font("Serif",Font.ITALIC,14);
		boldItalic=new Font("Serif",Font.BOLD + Font.ITALIC,14);
		
		//txtField.setFont(plaintxt);		//sets the initial font to plain
		
		txtField.setFont(italic);
		
		//records events for JRadioButtons
		plainJRadioButton.addItemListener(new RadioButtonHandler(plaintxt));
		boldJRadioButton.addItemListener(new RadioButtonHandler(bold));
		italicJRadioButton.addItemListener(new RadioButtonHandler(italic));
		boldItalicJRadioButton.addItemListener(new RadioButtonHandler(boldItalic));
	}

	//private internal class to handle button selection events
	private class RadioButtonHandler implements ItemListener
	{
		private Font font;
		
		public RadioButtonHandler(Font f)
		{
			font=f;
		}
		
		public void itemStateChanged(ItemEvent event)
		{
			txtField.setFont(font);
		}
	}
}


