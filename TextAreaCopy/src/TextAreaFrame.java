import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

import javax.swing.Box;


public class TextAreaFrame extends JFrame {

	private JTextArea textArea1;
	private JTextArea textArea2;
	private JButton copy;
	
	public TextAreaFrame()
	{
		super("TextArea Demo");
		Box box = Box.createHorizontalBox();	
		String demo="This is a demo string to illustrate copying text from one text area" +
				"to another textarea using an external event";
		
		textArea1 = new JTextArea(demo,10,15);
		textArea1.setLineWrap(true);
		box.add(new JScrollPane(textArea1));
		
		copy = new JButton("Copy >>>");
		box.add(copy);
		
		
		copy.addActionListener
		(
		
				new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						// textArea2.setText(textArea1.getSelectedText()); gia na min grafei
						//panw sto idio, dld na min krataei tin proigoumeni katastasi
						textArea2.setText(textArea2.getText()+textArea1.getSelectedText());
					}
				}
		);
		
		
		textArea2 = new JTextArea(10,15);
		textArea2.setEditable(false);
		textArea2.setLineWrap(true);
		box.add(new JScrollPane(textArea2));
		
		
		add(box);
	}
}
