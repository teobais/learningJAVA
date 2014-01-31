package CreditCheck;

public enum MenuOption {

	//defining enum data
	ZERO_BALANCE(1),
	CREDIT_BALANCE(2),
	DEBIT_BALANCE(3),
	END(4);
	
	private final int value;	//current menu option
	
	MenuOption(int valueOption)
	{
		value=valueOption;
	}//constructor end
	
	public int getValue()
	{
		return value;
	}
	
}
