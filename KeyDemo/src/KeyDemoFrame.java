import java.awt.Color;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class KeyDemoFrame extends JFrame implements KeyListener{
	
	private String line1="";
	private String line2="";
	private String line3="";
	private JTextArea textArea;	//an area that displays the output
	
	
	public KeyDemoFrame()
	{
		super("Demonstrating Keystroke Events");
		
		textArea = new JTextArea(10,15);	//formatting the text area
		textArea.setText("Press any key on the keyboard...");
		textArea.setEnabled(false);
		textArea.setDisabledTextColor(Color.BLACK);
		add(textArea);
		
		addKeyListener(this);
	}


	
	public void keyPressed(KeyEvent event)
	{
		//displaying pressed key
		line1=String.format("Key pressed: %s",KeyEvent.getKeyText(event.getKeyCode()));	
		setLines2and3(event);		
	}


	
	public void keyReleased(KeyEvent event) {
		
		line1=String.format("Key released: %s",KeyEvent.getKeyText(event.getKeyCode()));	
		setLines2and3(event);
	}


	
	public void keyTyped(KeyEvent event) {
		
		line1=String.format("Key typed: %s",event.getKeyChar());	
		setLines2and3(event);
		
	}
	
	
	public void setLines2and3(KeyEvent event)
	{
		line2=String.format("This is %s an action key",(event.isActionKey() ? "" : "not"));
		
		String temp = KeyEvent.getKeyModifiersText(event.getModifiers());
		
		//output modifiers
		line3 = String.format("Modifier keys pressed: %s",(temp.equals("") ? "none" : temp));
		
		textArea.setText(String.format("%s\n%s\n%s\n", line1, line2, line3));
		
	}

}
