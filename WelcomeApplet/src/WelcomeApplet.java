import java.awt.Graphics;
import javax.swing.JApplet;

public class WelcomeApplet extends JApplet{

	//draws the text to the applet's background
	public void paint(Graphics g)
	{
		//calling the superclassed version of paint method
		super.paint(g);
		
		//drawing a string where x=25 & y=25
		g.drawString("Welcome to Java Programming.", 25, 25);
	}
}
