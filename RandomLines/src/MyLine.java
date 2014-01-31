import java.awt.Color;
import java.awt.Graphics;


public class MyLine {

	private int x1;		//suntetagmeni x tou prwtou akrou
	private int y1;		//			   y tou prwtou akrou
	private int x2;		//			   x tou defterou akrou
	private int y2;		//			   y tou defterou akrou
	
	private Color myColor;	//scheme's color
	
	//constructor with incoming arguments
	public MyLine(int x1,int y1,int x2,int y2,Color color)
	{
		//defining the 5 requires coordinates
		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;
		myColor=color;
	}
	
	//drawing the line by using the specific color
	public void draw(Graphics g)
	{
		g.setColor(myColor);
		g.drawLine(x1, y1, x2, y2);
	}
}
