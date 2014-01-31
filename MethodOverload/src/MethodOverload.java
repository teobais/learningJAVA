
public class MethodOverload {

	public void testOverloadMethods()
	{
		System.out.printf("Square of 7 is %d\n",square(7));
		System.out.printf("Square of 7,5 is %.2f\n",square(7.5));
	}
	
	public int square(int x)
	{
		System.out.printf("\nCalled square with int argument: %d\n",x);
		return x*x;
	}
	
	public double square(double x)
	{
		System.out.printf("\nCalled square with double argument: %.2f\n",x);
		return x*x;
	}
}
