

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import teo.ch17.debit.AccountRecord;


public class ReadTextFile {

	private Scanner input;
	
	//allows user to open a file
	public void openFile()
	{
		try
		{
			input=new Scanner(new File("clients.txt"));
		}
		catch(FileNotFoundException fileNotFoundException)
		{
			System.err.println("Error opening file.");
			System.exit(1);
		}
	}	
		//reading a record from file
	 public void readRecords()
	 {
		 AccountRecord record=new AccountRecord();
		 System.out.printf("%-10s%-12s%-12s%10s\n","Account","First Name",
				 "Last Name", "Balance");
		 
		 try	//reading records from file using Scanner object
		 {
			 while(input.hasNext())
			 {
				 record.setAccount(input.nextInt());
				 record.setFirstName(input.next());
				 record.setLastName(input.next());
				 record.setBalance(input.nextDouble());
				 
				 //printing record data
				 System.out.printf("%-10d%-12s%-12s%10.2f\n", record.getAccount(),
						 record.getFirstName(),record.getLastName(),record.getBalance());
			 }
		 }
		 catch (NoSuchElementException elementException)
		 {
			 System.err.println("File improperly formed.");
			 input.close();
			 System.exit(1);
		 }
		 catch(IllegalStateException stateException)
		 {
			 System.err.println("Error reading from file.");
			 System.exit(1);
		 }
	 }
	
	public void closeFile()
	{
		if(input!=null)
		{
			input.close();
		}
	}
	
}
