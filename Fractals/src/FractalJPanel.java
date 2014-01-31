import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class FractalJPanel extends JPanel{

	private Color color;
	private int level;	//fractal's level
	private final int WIDTH = 400; //panel's width
	private final int HEIGHT = 400;	//panel height
	
	public FractalJPanel(int currentLevel)
	{
		color = Color.BLUE;
		level = currentLevel;
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(WIDTH,HEIGHT));
	}
	
	public void drawFractal(int level, int xA, int yA, int xB, int yB, Graphics g)
	{
		//vasiki periptwsi:sxediasmos grammis sundeontas 2 dedomena simeia
		if(level == 0)
			g.drawLine(xA, yA, xB, yB);
		else	//vima anadromis: prosdiorizei ta nea simeia kai sxediazei to epomeno epipedo
		{
			int xC = (xA + xB) / 2;
			int yC = (yA + yB) / 2;
			
			//upologizei to 4o simeio (xD,yD) pou sximatizei isoskeles or9ogwnio 3gwno meta3u 
			//(xA,yA) kai (xC,yC) opou i or9i gwnia einai sto (xD,yD)
			int xD = xA + (xC - xA) / 2 - (yC - yA) / 2;
			int yD = yA + (yC - yA) / 2 + (xC - xA) / 2;
			
			//sxediazei anadromika to fractal
			drawFractal(level-1,xD,yD,xA,yA,g);
			drawFractal(level-1,xD,yD,xC,yC,g);
			drawFractal(level-1,xD,yD,xB,yB,g);
		}
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(color);
		drawFractal(level,100,90,290,200,g);
	}
	
	public void setColor(Color c)
	{
		color = c;
	}
	
	public void setLevel(int currentLevel)
	{
		level = currentLevel;
	}
	
	public int getLevel()
	{
		return level;
	}
}
