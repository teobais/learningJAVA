

import java.applet.AppletContext;
import java.awt.BorderLayout;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class SiteSelector extends JApplet{

	private HashMap<Object, URL> sites;		//sites names and corresponding urls
	private ArrayList<String> siteNames; //site names
	private JList siteChooser;
	
	public void init()
	{
		sites = new HashMap<Object, URL>();
		siteNames = new ArrayList<String>();
		
		getSitesFromHTMLParameters();
		
		add(new JLabel("Choose a site to browse"), BorderLayout.NORTH);
		siteChooser = new JList(siteNames.toArray());
		siteChooser.addListSelectionListener(
		
			new ListSelectionListener()
			{
				public void valueChanged(ListSelectionEvent event)
				{
					//pairnei to onoma tou epilegmenou diktuakou topou
					Object object = siteChooser.getSelectedValue();
					
					
					//xrisimopoiei to onoma tou diktuakou topou gia na entopisei to url
					URL newDoc = sites.get(object);
					
					AppletContext browser = getAppletContext();
					browser.showDocument(newDoc, "_blank");
							
				}
			});
		
		add(new JScrollPane(siteChooser), BorderLayout.CENTER);
		
	}
	
	private void getSitesFromHTMLParameters()
	{
		String title;
		String location;
		URL url;
		int counter = 0;
		
		title = getParameter("title" + counter);
		
		while(title!=null)
		{
			location = getParameter("location" + counter);
			
			try
			{
				url = new URL(location); //converts the location to url
				sites.put(title, url);
				siteNames.add(title);
			}catch(MalformedURLException e)
			{
				e.printStackTrace();
			}
			
			counter++;
			title = getParameter("title" + counter);
		}
	}

}
