import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;

public class BorderLayoutFrame extends JFrame implements ActionListener{

	private JButton buttons[];	//button array to hide areas
	private final String[] names={"Hide North","Hide South","Hide East","Hide West","Hide Center"};
	private BorderLayout layout;	//borderlayout object
	
	public BorderLayoutFrame()
	{
		super("BorderLayout Demo");
		
		layout = new BorderLayout(5,5);	//5 pixels between each button
		setLayout(layout);
		buttons = new JButton[names.length];	//defining array number
		
		//creating JButtons; recording ActionListeners
		for(int count=0;count<names.length;count++)
		{
			buttons[count] = new JButton(names[count]);
			buttons[count].addActionListener(this);
		}
		
		add(buttons[0],BorderLayout.NORTH);
		add(buttons[1],BorderLayout.SOUTH);
		add(buttons[2],BorderLayout.EAST);
		add(buttons[3],BorderLayout.WEST);
		add(buttons[4],BorderLayout.CENTER);
	}
	
	public void actionPerformed(ActionEvent event)
	{
		for(JButton button : buttons)
		{
			if(event.getSource() == button)
				button.setVisible(false);	//hiding the clicked button
			else
				button.setVisible(true);
		}
		
		layout.layoutContainer(getContentPane());
	}
}
