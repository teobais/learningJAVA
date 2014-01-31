import java.awt.Graphics;
import java.awt.Dimension;
import javax.swing.JPanel;


public class OvalPanel extends JPanel{

	private int diameter = 10;
	
	//sxediazei mia elleipsi me diametro 10
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		g.fillOval(10,10,diameter,diameter);
	}
	
	//epikurwne kai orizei ti diametro & ananewnei ti sxediasi
	public void setDiameter(int newDiameter)
	{
		//an i diametros einai akuri,default = 10
		diameter = (newDiameter >= 0 ? newDiameter : 10);
		repaint();
	}
	
	//xrisimopoieitai apo to diaxeiristi diata3is, wste na prosdioristoun oi protimwmenes diastaseis
	public Dimension  getPreferredSize()
	{
		return new Dimension(200,200);
	}
	
	public Dimension getMinimumSize()
	{
		return getPreferredSize();
	}
}

