import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.io.*;
import java.util.*;

public class FileDemonstration extends JFrame{

	public JTextArea outputArea;	//used for output
	public JScrollPane scrollPane;	//used for output scrolling
	
	//===
	private File name;
	public Scanner openedFile;
	//===
	
	
	//GUI configuration
	public FileDemonstration()
	{
		super("Testing class File");
		
		outputArea=new JTextArea();
		
		//adding outputArea to scrollPane
		scrollPane=new JScrollPane(outputArea);
		
		//adding scrollPane to GUI
		add(scrollPane,BorderLayout.CENTER);
		setSize(400,400);
		setVisible(true);
		
		analyzePath();
		readValues();
	}
	
	//allowing user to define file name
	public File getFileOrDirectory()
	{
		//prints a dialog message window, thus a user can choose to open a file/directory
		JFileChooser fileChooser=new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		
		int result=fileChooser.showOpenDialog(this);
		
		//if user pressed Cancel,returns
		if(result==JFileChooser.CANCEL_OPTION)
			System.exit(1);
		
		File fileName=fileChooser.getSelectedFile();	//getting the file
		
		//printing an error, if it's bad
		if((fileName==null) || (fileName.getName().equals("")))
		{
			JOptionPane.showMessageDialog(this,"Invalid File Name","Invalid Name",
					JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
		
		return fileName;
	}
	
	
	
	public void analyzePath()
	{
		
		//calling function for getting the preferred file
		name=getFileOrDirectory();
		
		
		if(name.exists())
		{
			outputArea.setText(String.format("%s%s\n%s\n%s\n%s\n%s%s\n%s%s\n%s%s\n%s%s\n%s%s\n",
					name.getName()," exists",(name.isFile() ? "is a file" : "is not a file"),
					(name.isDirectory() ? "is a directory" : "is not a directory" ),
					(name.isAbsolute() ? "is absolute path" : "is not an absolute path"),
					"Last modified: ",name.lastModified(),"Length: ",name.length(),
					"Path: ",name.getPath(),"Absolute path: ",name.getAbsolutePath(),
					"Parent: ",name.getParent()));
			
			//printing the directory list
			if(name.isDirectory()){
				String[] directory=name.list();
				outputArea.append("\n\nDirectory contents: "+directory);
				
				for(String directoryName : directory)
					outputArea.append(directoryName+ "\n");
			}//if end
		}//external if end
		else	//neither a file, nor a catalog->prints error message
		{
			JOptionPane.showMessageDialog(this, name+" does not exist","ERROR"
					,JOptionPane.ERROR_MESSAGE);
		}
						
	}
	
	public void readValues() 
	{
		int i=0;
		final int[] coord1=new int[6];
		final int[] coord2=new int[6];
		try
		{
			openedFile=new Scanner(name);
		}
		catch(Exception e)
		{
			System.err.println("Could not find or open file");
		}
		
		
		while(openedFile.hasNext())
		{
			coord1[i]=openedFile.nextInt();
			coord2[i]=openedFile.nextInt();
			i+=1;
		}
		
		for(i=0;i<coord1.length;i++)
		{
			outputArea.append(String.format("%d %d\n",coord1[i],coord2[i]));
			
		}
		openedFile.close();
	}
	
	
}
