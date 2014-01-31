import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class ColorJPanel extends JPanel{

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);	//calling pantComponent's superclass
		this.setBackground(Color.WHITE);
		
		g.setColor(new Color(255,0,0));
		g.fillRect(15,25,100,20);
		g.drawString("Current RGB: " + g.getColor(),130,40);
		
		g.setColor(new Color(0.50f,0.75f,0.0f));
		g.fillRect(15,50,100,20);
		g.drawString("Current RGB: " + g.getColor(),130,65);
		
		g.setColor(Color.BLUE);
		g.fillRect(15,75,100,20);
		g.drawString("Current RGB: " + g.getColor(),130,90);
		
		Color magenta_color = Color.MAGENTA;
		g.setColor(magenta_color);
		g.fillRect(15,100,100,20);
		g.drawString("RGB values: " + magenta_color.getRed() + ", " + magenta_color.getGreen()
				+ ", " + magenta_color.getBlue(),130,115);
		
		
		
	}
}
