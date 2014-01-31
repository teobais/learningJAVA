
public class Factorial {

	public static long factorial(long number)
	{
		if(number <= 1)
			return 1;
		else
			return number * factorial(number - 1);
	}
	
	public static void main(String[] args)
	{
		for(int count=0;count<=21;count++)
		
			System.out.printf("%d! = %d\n",count,factorial(count));
	}
}
