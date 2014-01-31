import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;


public class ReadServerFile extends JFrame{

	private JTextField enterfield;
	private JEditorPane contentsArea;	//emfanisi site
	
	public ReadServerFile()
	{
		super("Simple Web Browser");
		
		enterfield = new JTextField("Enter file URL here");
		enterfield.addActionListener(
				
				new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{
						getThePage(event.getActionCommand());
					}
				
				}
				);
		add(enterfield, BorderLayout.NORTH);
		
		contentsArea = new JEditorPane();
		contentsArea.setEditable(false);
		contentsArea.addHyperlinkListener
		(
				new HyperlinkListener()
				{
					//an o xristis ekane klik sto link, paei stin klikarismeni selida
					public void hyperlinkUpdate(HyperlinkEvent event)
					{
						if(event.getEventType() == HyperlinkEvent.EventType.ACTIVATED)
							getThePage(event.getURL().toString());
					}
				}
		);
		
		add(new JScrollPane(contentsArea), BorderLayout.CENTER);
		setSize(400,300);
		setVisible(true);
	}
	

	//loading the file
	private void getThePage(String location)
	{
		try
		{
			contentsArea.setPage(location);
			enterfield.setText(location);
		}catch(IOException ioE)
		{
			JOptionPane.showMessageDialog(this,"Error receiving specified URL", "Bad URL", JOptionPane.ERROR_MESSAGE);
		}
	}
}
