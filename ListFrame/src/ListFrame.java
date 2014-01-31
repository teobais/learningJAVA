import java.awt.FlowLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.ListSelectionModel;

public class ListFrame extends JFrame{

	private JList colorJList;	//list that displays colors
	private final String[] colorNames={"Black","Blue","Cyan","Dark Gray","Gray","Green",
			"Light Gray","Magenta","Orange","Pink","Red","White","Yellow"};
	private final Color[] colors={Color.BLACK,Color.BLUE,Color.CYAN,Color.DARK_GRAY,
			Color.GRAY,Color.GREEN,Color.LIGHT_GRAY,Color.MAGENTA,Color.ORANGE,Color.PINK,
			Color.RED,Color.WHITE,Color.YELLOW};
	
	//ListFrame constructor adds JScrollPane (that contains JList) to JFrame
	public ListFrame()
	{
		super("List Test");
		setLayout(new FlowLayout());
		
		colorJList=new JList(colorNames);
		colorJList.setVisibleRowCount(5);
		
		//forbidding multple selections
		colorJList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		//adding a JScollPane that contains a JList to the frame
		add(new JScrollPane(colorJList));
		
		colorJList.addListSelectionListener
		(
				new ListSelectionListener()	//anonymous internal class
				{
					//handling list events
					public void valueChanged(ListSelectionEvent e)
					{
						getContentPane().setBackground(colors[colorJList.getSelectedIndex()]);
					}
				}
		);
	}			
}
