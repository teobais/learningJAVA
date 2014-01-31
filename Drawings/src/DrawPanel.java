import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawPanel extends JPanel {

	public void paintComponent(Graphics g)//kaleitai ka9e fora pou einai na emfanistei to JPanel
	{
		super.paintComponent(g);	//panta etc afti i grammi
		int width=getWidth();
		int height=getHeight();
		
		g.drawLine(0,0,width,height);
		g.drawLine(0,height,width,0);
		
		
	}
}
