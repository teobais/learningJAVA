package Serializable;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import Serializable.AccountRecordSerializable;

public class ReadSequentialFile {

	private ObjectInputStream input;
	
	//allows user to choose the file to be opened
	public void openFile()
	{
		try
		{
			input=new ObjectInputStream(new FileInputStream("clients.ser"));
		}
		catch(IOException ioException)
		{
			System.err.println("Error opening file.");
		}
		
	}
	
	
	//reading a record from the file
	public void readRecords()
	{
		AccountRecordSerializable record;
		System.out.printf("%-10s%-12s%-12s%10s\n", "Account","First Name",
				"Last Name","Balance");
		
		try	//importing values from file
		{
			while(true)
			{
				record=(AccountRecordSerializable) input.readObject();
				
				//printing record data
				System.out.printf("%-10d%-12s%-12s%10.2f\n", record.getAccount(),
						record.getFirstName(),record.getLastName(),record.getBalance());
			}
		}
		catch(EOFException eof)
		{
			return;
		}
		catch(ClassNotFoundException classNotFound)
		{
			System.err.println("Unable to create object.");
		}
		catch(IOException io)
		{
			System.err.println("Error during reading from file.");
		}
	}
	
	
	//closing file;ending app
	public void closeFile()
	{
		try
		{
			if(input!=null)
			{
				input.close();
			}
		}
		catch(IOException io)
		{
			System.err.println("Error closing file.");
			System.exit(1);
		}
	}
}
