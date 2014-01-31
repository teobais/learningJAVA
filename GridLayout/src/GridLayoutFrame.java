import java.awt.GridLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;

public class GridLayoutFrame extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton[] buttons;	//button array
	private final String names[] = {"one","two","three","four","five","six"};
	
	private boolean toggle = true;	//staggered by the two layouts
	private Container container;	//frame container
	private GridLayout grid1;		//first grid layout
	private GridLayout grid2;		//second
	
	public GridLayoutFrame()
	{
		super("GridLayout Demo");
		grid1 = new GridLayout(2,3,5,5);	//2*5 with 5 pixels between positions
		grid2 = new GridLayout(3,2);		//3*2
		container = getContentPane();		//getting data section
		setLayout(grid1);
		
		buttons = new JButton[names.length];
		
		for(int count=0;count<names.length;count++)
		{
			buttons[count] = new JButton(names[count]);
			buttons[count].addActionListener(this);
			add(buttons[count]);
		}
	}
	
	
	public void actionPerformed(ActionEvent event)
	{
		if(toggle)
			container.setLayout(grid2);
		else
			container.setLayout(grid1);
		
		toggle = !toggle;
		container.validate();	//container relayouting
		
	}
}
