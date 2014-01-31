import java.util.Scanner;

public class mo {

	public static void main(String[] args)
	{
		System.out.println("Ypologismos MO");
		System.out.println("Ari9mos perasmenwn ma9imatwn: ");
		Scanner input = new Scanner(System.in);
		int ma9imata=input.nextInt();
		
		System.out.println("MO mexri stigmis: ");
		double temp_mo=input.nextDouble();
		
		System.out.println("1.Manual eisagwgi va9mwn metepeita ma9imatwn\n2.Eisagwgi MO gia sugkekrimeno ari9mo ma9imatwn\nChoose:");
	
		
		int option=input.nextInt();
		if(option==1)
		{
			manual_input mo1=new manual_input();
			mo1.eisagwgi_vathmwn(ma9imata,temp_mo);
			input.close();
		}
		
		else if(option==2)
		{
			mo_next_courses mo2=new mo_next_courses();
			mo2.get_mo(ma9imata,temp_mo);
			input.close();
		}
	}
}
