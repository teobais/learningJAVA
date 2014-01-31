import java.awt.FlowLayout;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class ComboBoxFrame extends JFrame{

	private JComboBox images;		//combobox that will contain icon names
	private JLabel label;			//label to print selected icon
	
	private String names[]={"bug1.png","bug2.png","ant.jpg"};
	private Icon icons[]={
			new ImageIcon(getClass().getResource(names[0])),
			new ImageIcon(getClass().getResource(names[1])),
			new ImageIcon(getClass().getResource(names[2])) };
	
	//comboboxframe constructor adds JComboBox to JFrame
	public ComboBoxFrame()
	{
		super("Testing JComboBox");
		setLayout(new FlowLayout());
		
		
		images=new JComboBox(names);
		images.setMaximumRowCount(3);	//printing 2 rows
		
		images.addItemListener
		(
				new ItemListener() 		//anonymous internal class
				{
					//handling JComboBox event
					public void itemStateChanged(ItemEvent event)
					{
						//defines if check frame is selected
						if(event.getStateChange()==ItemEvent.SELECTED)
							label.setIcon(icons[images.getSelectedIndex()]);
					}
				}
		);
		
		
		add(images);	//adding combobox to JFrame
		label=new JLabel(icons[0]);	//prints the first icon
		add(label);
	}

}

