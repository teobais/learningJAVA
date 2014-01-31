import java.net.*;
import java.util.*;
import java.awt.*;
import java.applet.*;
import javax.swing.*;
import javax.swing.event.*;

public class TeoSites extends Applet{

	private HashMap<String,URL> websiteInfo;
	private ArrayList<String> titles;
	private JList mainList;
	
	//init
	public void init()
	{
		websiteInfo=new HashMap<String,URL> ();
		titles=new ArrayList<String>();
		
		grabHTMLInfo();
		add(new JLabel("What website do you want to visit?"),BorderLayout.NORTH);
		
		mainList=new JList(titles.toArray());
		
		//go to the website that corresponds to the option tha chosen by the user
		mainList.addListSelectionListener
		(
		
				new ListSelectionListener()
				{
					public void valueChanged(ListSelectionEvent event)
					{
						//getting the value of the website
						Object object = mainList.getSelectedValue();
						
						//grabbing the title of list option
						URL newDocument = websiteInfo.get(object);
						
						//going to the valued URL, after converting the Applet to URL
						AppletContext browser = getAppletContext();
						browser.showDocument(newDocument);
					}
				}
		
		);
		add(new JScrollPane(mainList),BorderLayout.CENTER);
	}
	
	//getting website info
	private void grabHTMLInfo()
	{
		String title;
		String address;
		URL url;
		
		//we also need a counter to determine on which title or address we refer
		//title0 i.e
		int counter=0;
		title=getParameter("title"+counter);
		
		while(title != null)
		{
			address=getParameter("address"+counter);
			try
			{
				//grabs the value of the html's address parameter, converting it to a URL object
				url=new URL(address);
				
				//adding a new item into the HashMap
				websiteInfo.put(title,url);
				
				//adding the grab to the titles ArrayList
				titles.add(title);
			}
			catch(MalformedURLException urlException)
			{
				urlException.printStackTrace();
			}
			++counter;
			
			//unless we put this line, we have an infinite loop
			title = getParameter("title"+counter);
		}
	}
}
