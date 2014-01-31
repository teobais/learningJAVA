import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class PanelFrame extends JFrame{

	private JPanel btnPanel;	//panel that contains buttons
	private JButton buttons[];	//button array
	
	public PanelFrame()
	{
		super("Panel Demo");
		buttons = new JButton[5];
		btnPanel = new JPanel();	//defining the panel
		btnPanel.setLayout(new GridLayout(1,buttons.length));
		
		for(int count=0;count<buttons.length;count++)
		{
			buttons[count]=new JButton("Button "+(count+1));
			btnPanel.add(buttons[count]);
		}
		
		add(btnPanel,BorderLayout.SOUTH);
	}



public static void main(String[] args)
{
	PanelFrame app = new PanelFrame();
	app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	app.setSize(450,200);
	app.setVisible(true);

}


}