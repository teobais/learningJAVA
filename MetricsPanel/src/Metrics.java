import javax.swing.JFrame;

public class Metrics {

	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MetricsJPanel panel = new MetricsJPanel();
		frame.add(panel);
		frame.setSize(510,250);
		frame.setVisible(true);
	}
}
