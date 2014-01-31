import java.util.Scanner;

public class practice_diplwma  {

	private double f2mo=0;
	private double ff2mo=0;
	public double practice (int fcourses,double fmo)
	{
		double fgin=fcourses*fmo;
	
		String nai="Nai";
		String oxi="Oxi";
		
		System.out.println("9eleis na proste9ei kai o va9mos tis praktikis?");
		Scanner input=new Scanner(System.in);
		
		String answer=input.next();
		if(answer.equals(nai)){
			f2mo=(fgin+10)/(fcourses+1);
		
		return f2mo;
		}
		
		else
	{
		return fmo;//gia na tin perasw stin manual_input prp 
							//na kanw ekxwrisi se mia metavliti ti me9odo
	}
	}
	
	public double diplwma(int ffcourses,double ffmo)
	{
		double ffgin=ffcourses*ffmo;
		
		String nai="Nai";
		String oxi="Oxi";
		
		System.out.println("9eleis na proste9ei kai o va9mos tis diplwmatikis?");
		Scanner input=new Scanner(System.in);
		
		String answer=input.next();
		if(answer.equals(nai)){
			ff2mo=(ffgin+60)/(ffcourses+6);
		
		return ff2mo;		//gia na tin perasw stin manual_input prp 
		}
		else
		{
			return ffmo;//na kanw ekxwrisi se mia metavliti ti me9odo
		}
	}
	
	
	
}
