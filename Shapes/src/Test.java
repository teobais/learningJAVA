import java.awt.Color;
import javax.swing.JFrame;

public class Test {

	public static void main(String[] args)
	{
		JFrame frame = new JFrame("Drawing several shapes");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Shapes shapes = new Shapes();
		frame.add(shapes);
		frame.setSize(400,210);
		frame.setVisible(true);
	}
}
