package teo.ch17.debit;

import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import teo.ch17.debit.AccountRecord;

public class CreateTextFile {

	private Formatter output;	//object-used to write to a file
	
	//allows a user to open a file
	public void openFile()
	{
		try
		{
			output=new Formatter("clients.txt");	//file open
		}
		catch (FileNotFoundException filesNotFoundException)
		{
			System.err.println("Error opening or creating file.");
			System.exit(1);
		}
	}
	
	
	//adding records to file
	public void addRecords()
	{
		//object that will be written in the file
		AccountRecord record=new AccountRecord();
		
		Scanner input=new Scanner(System.in);
		System.out.printf("%s\n%s\n%s\n%s\n\n", "To terminate input, type the end-of-file indicator",
		"when you are prompted to enter input","On UNIX/Linux/Mac OS X type <ctrl> d then press Enter",
		"On Windows type <ctrl> z then press Enter");
		
		System.out.printf("%s\n%s", "Enter account number(>0), frst name, last name," +
				"and balance","? ");
		
		while(input.hasNext())
		{
			try	//exporting values to file
			{
				//retrieving data from file
				record.setAccount(input.nextInt());		//reading account number
				record.setFirstName(input.next());		//reading first name
				record.setLastName(input.next());		//reading last name
				record.setBalance(input.nextDouble());	//reading balance
				
				if(record.getAccount()>0)
				{
					//writes a new record
					output.format( "%d %s %s %.2f\r\n", record.getAccount(),
							record.getFirstName(), record.getLastName(),
							record.getBalance());
				}
				
				else
				{
					System.out.println("Account number must be greater than 0.");
				}
			}//end of try
			
			catch (FormatterClosedException formatterCloseddException)
			{
				System.err.println("Error writing to file.");
				return;
			}//end of catch
			
			catch(NoSuchElementException elementException)
			{
				System.err.println("Invalid input.Please try again");
				input.nextLine();
			}//end of catch
			
			System.out.printf("%s %s\n%s","Enter account number (>0)","first name" +
					"last name and balance","? ");
		}
	}
	
	public void closeFile()
	{
		if(output!=null)
		{
			output.close();
		}
	}
}
