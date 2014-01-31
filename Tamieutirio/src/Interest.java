
public class Interest {

	public static void main(String[] args)
	{
		double amount;
		double principal=1000.0;
		double rate=0.05;
		
		System.out.printf("%s%40s\n","Year","Amount on deposit");
		
		for(int year=1;year<=10;year++)
		{
			amount=Math.pow(1.0+rate,year);
			System.out.printf("%4d%, 40.4f\n",year,amount);
		}
	}
}
