import java.io.*;
import java.util.*;

public class ReadFile {

	private Scanner x;
	
	
	public void openFile()
	{
		try
		{
			x=new Scanner(new File("customers.txt"));
		}
		catch(Exception e)
		{
			System.err.println("Could not find file.");
		}
	}
	
	public void readFile()
	{
		System.out.printf("%s %20s %20s\n-------------------" +
				"---------------------------\n","ID","First Name","Last Name");
		while(x.hasNext())
		{
			String id=x.next();
			String first=x.next();
			String last=x.next();
			
			System.out.printf("%s %20s %20s\n",id,first,last);
		}
	}
	
	public void closeFile()
	{
		x.close();
	}
}
