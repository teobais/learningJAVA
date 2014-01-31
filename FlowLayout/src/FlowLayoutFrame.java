import java.awt.FlowLayout;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JButton;

public class FlowLayoutFrame extends JFrame
{
	
	private JButton leftBtn;
	private JButton centerBtn;
	private JButton rightBtn;
	private FlowLayout layout;	//layout object
	private Container container;	//coontainer to set the layout
	
	//formatting GUI & recording button Event handlers
	public FlowLayoutFrame()
	{
		super("FlowLayout Demo");
		layout = new FlowLayout();
		setLayout(layout);
		
		leftBtn = new JButton("Left");
		add(leftBtn);
		leftBtn.addActionListener
		(
		
				new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						layout.setAlignment(FlowLayout.LEFT);
					
						//stoixizei 3ana the linked components
						layout.layoutContainer(container);
					}
				}
		
		);
		
		
		
		centerBtn = new JButton("Center");
		add(centerBtn);
		centerBtn.addActionListener
		(
		
				new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						layout.setAlignment(FlowLayout.CENTER);
					
						//stoixizei 3ana the linked components
						layout.layoutContainer(container);
					}
				}
		
		);
		
		
		rightBtn = new JButton("Right");
		add(rightBtn);
		rightBtn.addActionListener
		(
		
				new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						layout.setAlignment(FlowLayout.RIGHT);
					
						//stoixizei 3ana the linked components
						layout.layoutContainer(container);
					}
				}
		
		);
		
	}
	
}