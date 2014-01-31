package  teo.ch17.debit;

public class AccountRecord {

	private int account;
	private String firstName;
	private String lastName;
	private double balance;
	
	//this "no-args" constructor calls another constructor with default values
	public AccountRecord()
	{
		this(0,"","",0.0);	//calls a 4 argument constructor
	}
	
	//-----------------------------------------------------------------------
	//initializing a record												//---
	public AccountRecord(int acct,String first,String last,double bal)	//---
	{																	//---		
		setAccount(acct);												//---
		setFirstName(first);											//---
		setLastName(last);												//---
		setBalance(bal);												//---
	}//end of 4 argument "AccountRecord" constructor					//---
	//-----------------------------------------------------------------------
	
	//sets account number
	public void setAccount(int acct)
	{
		account=acct;
	}
	
	
	//getting account number
	public int getAccount()
	{
		return account;
	}
	
	
	//sets the name
	public void setFirstName(String first)
	{
		firstName=first;
	}
	
	
	//gets the name
	public String getFirstName()
	{
		return firstName;
	}
	
	
	//sets lastname
	public void setLastName(String last)
	{
		lastName=last;
	}
	
	
	//gets lastname
	public String getLastName()
	{
		return lastName;
	}
	
	
	//sets balance
	public void setBalance(double bal)
	{
		balance=bal;
	}
	
	
	//gets balance
	public double getBalance()
	{
		return balance;
	}
}

