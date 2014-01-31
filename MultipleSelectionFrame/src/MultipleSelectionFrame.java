import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class MultipleSelectionFrame extends JFrame{

	private JList colors;	//color names list
	private JButton copy;	//button for copying colors to the other JList
	private JList copyList;	//list in which colors will be copied
	private final String[] colorNames={"Black","Blue","Cyan","Dark Gray","Gray","Green","Light Gray",
			"Magenta","Orange","Pink","Red","White","Yellow"};
	
	//constructor
	public MultipleSelectionFrame()
	{
		super("Multiple Selection Lists");
		setLayout(new FlowLayout());
		
		colors=new JList(colorNames);
		colors.setVisibleRowCount(5);
		colors.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		add(new JScrollPane(colors));
		
		copy=new JButton("Copy>>>");
		copy.addActionListener(
		new ActionListener() 		//anonymous internal class
		{
			//handling button events
			public void actionPerformed(ActionEvent e)
			{
				copyList.setListData(colors.getSelectedValues());
			}//end of actionPerformed
		}//end of anonymous internal class
				
		);		//end of addActionListener method
		
		add(copy);
		copyList=new JList();
		copyList.setVisibleRowCount(5);
		copyList.setFixedCellWidth(100);
		copyList.setFixedCellHeight(15);
		copyList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		add(new JScrollPane(copyList));
	}
}
