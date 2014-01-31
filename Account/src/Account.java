
public class Account {

	private double balance;
	
	//constructor-voi9aei otn dimiourgoume apef9eias arxikopoiimena antikeimena
	public Account(double initialBalance)
	{
		if(initialBalance>0.0)
		{
			balance = initialBalance;
		}
	}
	
	public void credit(double amount) 
	{
		balance=balance+amount;
	}

	public double getBalance()
	{
		return balance;		
	}
}
