package CreditCheck;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.IllegalStateException;
import java.util.NoSuchElementException;
import java.util.Scanner;

import teo.ch17.debit.AccountRecord;

public class CreditInquiry {

	private MenuOption accountType;
	private Scanner input;
	private MenuOption choices[]={MenuOption.ZERO_BALANCE,MenuOption.CREDIT_BALANCE,
									MenuOption.DEBIT_BALANCE,MenuOption.END};

	//READING FILE RECORDS ; EXPORTING ONLY USEFUL RECORDS
	private void readRecords()
	{
		//object for saving written in file data
		AccountRecord record=new AccountRecord();
		
		try
		{
			//opening file to read from start
			input=new Scanner(new File("clients.txt"));
			
			while(input.hasNext())	//importing values from File
			{
				record.setAccount(input.nextInt());
				record.setFirstName(input.next());
				record.setLastName(input.next());
				record.setBalance(input.nextDouble());
				
				//print the record if you find the supposed data type
				if(shouldDisplay(record.getBalance()))
				{
					System.out.printf("%-10d%-12s%-12s%10.2f\n",record.getAccount(),
							record.getFirstName(),record.getLastName(),record.getBalance());
				}
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
		
		catch(FileNotFoundException fileNotFoundException)
		{
			System.err.println("File cannot be found.");
			System.exit(1);
		}
		
		finally
		{
			if(input!=null)
			{
				input.close();
			}
		}//finally end
	}//readRecords() end

	private boolean shouldDisplay(double balance)
	{
		if((accountType==MenuOption.CREDIT_BALANCE) && (balance<0))
			return true;
		
		else if((accountType==MenuOption.DEBIT_BALANCE) && (balance>0))
			return true;
		
		else if((accountType==MenuOption.ZERO_BALANCE) && (balance==0))
			return true;
		
		return false;
	}//end of shouldDisplay()
	
	
	//getting user request
	private MenuOption getRequest()
	{
		Scanner textIn=new Scanner(System.in);
		int request=1;
		
		//printing choices
		System.out.printf("\n%s\n%s\n%s\n%s\n%s\n", "Enter request",
				"1-List accounts with zero balances","2-List accounts with credit balances"
				,"3-List accounts with debit balances","4-End of run");
		
		try
		{
			do	//user input request
			{
				System.out.print("\n? ");
				request=textIn.nextInt();
			}
			while((request<1) || (request>4));
		}
		
		catch(NoSuchElementException elementException)
		{
			System.err.println("Invalid input.");
			System.exit(1);
		}
		
		return choices[request-1];
	}//end of getRequest()
	
	public void processRequests()
	{
		//getting user request(for example, 0,debit or credit balance)
		accountType=getRequest();
		
		while(accountType!=MenuOption.END)
		{
			switch(accountType)
			{
			case ZERO_BALANCE:
				System.out.println("\nAccounts with zero balances:\n");
				break;
			case CREDIT_BALANCE:
				System.out.println("\nAccounts with credit balances:\n");
				break;
			case DEBIT_BALANCE:
				System.out.println("\nAccounts with debit balances:\n");
				break;
			}//switch end
			
			readRecords();
			accountType=getRequest();
		}
	}
	
	
}



