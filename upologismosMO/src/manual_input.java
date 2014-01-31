import java.util.Scanner;
public class manual_input {

	//private double sum=0;
	private	int count=0;
	private double total=0;
	private double grade;
	
	public void eisagwgi_vathmwn (int courses,double mo)
	{
		double gin=courses*mo;
		Scanner input=new Scanner(System.in);
		
		System.out.println("THODORIS___BAIS\nEnter grade or -1 to quit");
		grade=input.nextDouble();
		
		while(grade!=-1)
		{
			total+=grade;
			count+=1;
			
			System.out.print("Va9mos ma9imatos: ");
			grade=input.nextDouble();
			
			//input.close();
		}
	
	if(count!=0)
	{
		double mo2=total/count;
		double gin2=count*mo2;
		double telikos_mo=(gin+gin2)/(count+courses);
		
		practice_diplwma mo3=new practice_diplwma();
		double practice=mo3.practice(count+courses,telikos_mo);
		
	//	System.out.printf("TELIKOS MO: %.2f\n",telikos_mo);
		
		
		
		
	
		if(practice==0)
		{
			double mo_no_practice=telikos_mo;
			int courses_no_practice=count+courses;
			double diplwma=mo3.diplwma(courses_no_practice,mo_no_practice);
			System.out.printf("TELIKOS MO: %.2f\n",diplwma);
		}
		else
		{
			double mo_with_practice=practice;
			int courses_with_practice=count+courses+1;
			double diplwma=mo3.diplwma(courses_with_practice, mo_with_practice);
			
			if(diplwma==0)
			{
			System.out.printf("TELIKOS MO: %.2f\n",practice);	
			}
			else
			{
				System.out.printf("TELIKOS MO: %.2f\n",diplwma);	
			}
			
		}
		
		
		
	}

	else
	{
		System.out.println("No grades entered.");
	}
	}
		
}
