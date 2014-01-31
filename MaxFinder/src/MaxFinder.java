import java.util.Scanner;

public class MaxFinder
{

	public void determineMax()
	{
		Scanner input=new Scanner(System.in);
		System.out.print("Enter 3 doubles with space between each one: ");
		double num1=input.nextDouble();
		double num2=input.nextDouble();
		double num3=input.nextDouble();
		input.close();
		double result=maximum(num1,num2,num3);
		
		System.out.println("Max is:"+result); 	//sunenwsi sumvoloseirwn
	}
		
	public double maximum(double x,double y,double z)
	{
			/*double maxValue=x;
			
			if(y>maxValue)
			{
				maxValue=y;
			}
			
			if(z>maxValue)
			{
				maxValue=z;
			}
			
			return maxValue;  */
		
		return Math.max(x, Math.max(y,z));	//prosfora sunektikotias ston kwdika
	
	
	}
	
}
