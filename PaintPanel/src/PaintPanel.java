import java.awt.Point;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JPanel;

public class PaintPanel extends JPanel{

	private int pointCount=0;	//counting points
	
	//index array of 10000 java.awt.Point references 
	private Point[] points=new Point[10000];
	
	//formatting the GUI;adding the event mouse handler
	public PaintPanel()
	{
		//mouse event handling
		addMouseMotionListener
		(
		
				new MouseMotionAdapter()	//anonymous internal class
				{
					//saving the drag's coordinates and repainting
					public void mouseDragged(MouseEvent event)
					{
						if(pointCount<points.length)
						{
							points[pointCount]=event.getPoint();	//finding the point
							pointCount++;
							repaint();
						}
					}
				}
				
		);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);	//cleaning drawing area
		
		//drawing all the points to the table
		for(int i=0;i<pointCount;i++)
			g.fillOval(points[i].x,points[i].y,4,4);
	}
}
