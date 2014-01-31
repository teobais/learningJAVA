import java.util.Scanner;

public class mo_next_courses {

	public void get_mo(int courses,double mo)
	{
		double initial_ginomeno=courses*mo;
		
		System.out.println("Ektimwmenos ari9mos metepeita perasmenwn ma9imatwn:");
		Scanner input=new Scanner(System.in);
		int arithm=input.nextInt();
		System.out.println("Antistoixos MO:");
		double mo2=input.nextDouble();
		
		double secondary_ginomeno=arithm*mo2;
		double third=initial_ginomeno+secondary_ginomeno;
		int final_arithm=courses+arithm;
		
		System.out.printf("TELIKOS MO : %.2f",third/final_arithm );
	input.close();
	}
}
