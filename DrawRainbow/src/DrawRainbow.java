import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawRainbow extends JPanel
{
	//setting colors violet and indigo
	private final static Color VIOLET=new Color(128,0,128);
	private final static Color INDIGO=new Color(75,0,130);
	
	//setting the exacts colors that will be used in the rainbow, staring from internal
	//2 white spots end to a central arc
	private Color[] colors=
		{
			Color.WHITE, Color.WHITE, VIOLET, INDIGO, Color.BLUE,
			Color.GREEN, Color.YELLOW, Color.ORANGE, Color.RED};
		

	//constructor
	public DrawRainbow()
	{
		setBackground(Color.WHITE);	//sets white background
	}
	
	
	//draws a rainbow using arcs with same centre
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		int radius=20;		//arc radius
		
		//draws the rainbow near to the bottom of its centre
		int centerX=getWidth()/2;
		int centerY=getHeight()-10;
		
		//draws filled arcs, starting with the internal
		for(int counter=colors.length;counter>0;counter--)
		{
			//sets the current's arc color
			g.setColor(colors[counter-1]);
			
			//fills the arc from 0 to 180 degrees
			g.fillArc(centerX-counter*radius,centerY-counter*radius,counter*radius*2,counter*radius*2,0,180);
			
		}
	}
}
