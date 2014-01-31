
public class Increment {

	private int total = 0;
	private final int INCREMENT;	//sta9era metavliti xwris arxiki timi
	
	public Increment(int incrementValue)
	{
		INCREMENT = incrementValue;	//arxikopoiei tin sta9era metavliti(mia fora)
	}
	
	public void addIncrementToTotal()
	{
		total += INCREMENT;
	}
	
	public String toString()
	{
		return String.format("total = %d",total);
	}
}
