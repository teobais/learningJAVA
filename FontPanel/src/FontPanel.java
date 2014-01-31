import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Font;

public class FontPanel extends JPanel{

	public void paintComponent(Graphics g)
	{
		g.setFont(new Font("Serif",Font.BOLD,12));
		g.drawString("Serif 12 point Bold.",20,30);
		
		g.setFont(new Font("Monospaced",Font.ITALIC,24));
		g.drawString("Monospaced 24 point Italic.",20,50);
		
		g.setFont(new Font("SansSerif",Font.PLAIN,14));
		g.drawString("SansSerif 14 point Plain.",20,70);
	
		g.setColor(Color.RED);
		g.setFont(new Font("Serif",Font.BOLD + Font.ITALIC,18));
		g.drawString(g.getFont().getName() + " " + g.getFont().getSize() + " point Bold & Italic",20,90);
	}
	
	


}
