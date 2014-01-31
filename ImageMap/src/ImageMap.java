import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JApplet;


public class ImageMap extends JApplet{

	private ImageIcon mapImage;
	private static final String[] captions = {"Common Programming Error",
		"Good Progra", "Look sad","Performance Tip","Prtable", "Soft Eng Obs", "Error-Prevent" } ;
	
	public void init()
	{
		addMouseListener(
				
				new MouseAdapter()
			{
					
				public void mouseExited(MouseEvent event)
				{
					showStatus("pointer exited");
				}
			}
	);
	
		addMouseMotionListener(
		
			new MouseMotionAdapter()
			{
				public void mouseMoved(MouseEvent event)
				{
					showStatus(translateLocation(event.getX(), event.getY()));
				}
			}
		);
			mapImage = new ImageIcon("C:\\Users\\theo\\Desktop\\ICTE\\Developer\\prooptiki.png");
		}
		
	public void paint(Graphics g)
	{
		super.paint(g);
		mapImage.paintIcon(this, g, 0, 0);}
		
		public String translateLocation(int x,int y)
		{
			if(x >= mapImage.getIconWidth() || x >= mapImage.getIconHeight())
				return "";
			
			double iconWidth = (double) mapImage.getIconWidth() / 7.0;
			int iconNumber = (int)((double) x / iconWidth);
			
			return captions[iconNumber];
		}
	}

