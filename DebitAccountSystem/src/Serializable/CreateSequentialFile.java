package Serializable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

import Serializable.AccountRecordSerializable;

public class CreateSequentialFile {

	private ObjectOutputStream output;	//exports data to a file
	
	//allowing user to define file name
	public void openFile()
	{
		try	//opening file
		{
			output=new ObjectOutputStream(new FileOutputStream("clients.ser"));
		}
		catch(IOException ioException)
		{
			System.err.println("Error opening file.");
		}
	}//openFile() end
	
	
	//adding records to file
	public void addRecords()
	{
		AccountRecordSerializable record;	//object that will be written to file
		int accountNumber=0;				//accNumber for a record object
		String firstName;					//name for record object
		String lastName;
		double balance;
		
		Scanner input=new Scanner(System.in);
		
		System.out.printf("%s\n%s\n%s\n%s\n\n","To terminate input, type the end-of-file indicator",
				"when you are prompted to enter input.","On UNIX/Linux/MAC type <ctrl> d + Enter",
				"On Windows type <ctrl> z + Enter");
		
		System.out.printf("%s\n%s","Enter account number(>0), first name, last name and" +
				"balance","? ");
		
		while(input.hasNext())	//repeat until end of file
		{
			try	//exporting values to file
			{
				accountNumber=input.nextInt();
				firstName=input.next();
				lastName=input.next();
				balance=input.nextDouble();
				
				if(accountNumber>0)
				{
					//creating a record
					record=new AccountRecordSerializable(accountNumber,firstName,lastName,
							balance);
					output.writeObject(record);	//exporting the record
				}
				else
				{
					System.out.println("Account number must be greater than 0.");
				}
			}
				catch(IOException ioException)
				{
					System.err.println("Error writing to file.");
				}
				catch(NoSuchElementException elementException)
				{
					System.err.println("Invalid input.Please try again.");
					input.nextLine();
				}
				
				System.out.printf("%s\n%s","Enter account number(>0), first name, last name and" +
						"balance","? ");
			}
		}
		
		
		public void closeFile()
		{
			try //closing file
			{
				if(output!=null)
				{
					output.close();
				}
			}
			catch(IOException ioException)
			{
				System.err.println("Error closing file.");
				System.exit(1);
			}
		}
	}

