import javax.swing.JFrame;

public class MouseTracker {

	public static void main(String[] args)
	{
		MouseTrackerFrame app=new MouseTrackerFrame();
		app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		app.setSize(300,100);
		app.setVisible(true);
	}
}
