import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

public class TextFieldFrame extends JFrame {

	//3 pedia keimenou orismenwn diastasewn
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
		
	private JPasswordField passwordField;
	
	//constructor pou pros9etei JTextFields sto JFrame
	public TextFieldFrame()
	{
		super("Testing JTextField & JPasswordField");
		setLayout(new FlowLayout());	//orismos diata3is plaisiou
		
		//dimiourgia pediou keimenou 10 stilwn
		textField1=new JTextField(10);
		add(textField1);	//pros9iki sto frame
		
		//dimiourgia pediou keimenou me default keimeno
		textField2=new JTextField("Enter the text here");
		add(textField2);	//pros9iki sto frame
		
		//dimiourgia pediou keimenou me default keimeno kai 21 stiles
		textField3=new JTextField("" +
				"Uneditable text field",21);
		textField3.setEditable(false);	//apenergopoiei tin epe3ergasia
		add(textField3);	//pros9iki sto frame
		
		
		//dimiourgia pediou kwdikou me default keimeno
		passwordField=new JPasswordField("Hidden text");
		add(passwordField);		//pros9iki sto frame
		
		
		//eggrafi xeiristwn sumvantwn
		TextFieldHandler handler=new TextFieldHandler();
		textField1.addActionListener(handler);
		textField2.addActionListener(handler);
		textField3.addActionListener(handler);
		passwordField.addActionListener(handler);
	}//TELOS CONSTRUCTOR TextFieldFrame
	
	
	//PRIVATE ESWTERIKH KLASH GIA XEIRISMO SUMVANTWN
	private class TextFieldHandler implements ActionListener
	{
		
		//processing of symvanta pediwn keimenou
		public void actionPerformed(ActionEvent event)
		{
			String str1="";		//dilwsi string pou 9a emfanistei
			
			//user pressed Enter @ textfield1
			if(event.getSource()==textField1)
				str1=String.format("textField1: %s", event.getActionCommand());
		
			//user pressed Enter @ textfield2
			else if(event.getSource()==textField2)
				str1=String.format("textField2: %s", event.getActionCommand());
		
			//user pressed Enter @ textfield3
			else if(event.getSource()==textField3)
				str1=String.format("textField3: %s", event.getActionCommand());
		
			//user pressed Enter @ passwordfield
			if(event.getSource()==passwordField)
				str1=String.format("passwordField: %s", event.getActionCommand());
		
			//emfanisi periexomenwn JTextField
			JOptionPane.showMessageDialog(null, str1);
		}
	}
}
