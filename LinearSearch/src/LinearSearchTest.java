import java.util.Scanner;

public class LinearSearchTest {

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int searchInt;	//search key
		int position;	//position of search key in a table
		
		LinearArray array1 = new LinearArray(10);
		System.out.println(array1 + "\n");
		
		System.out.print("Please enter an integer value(-1 to quit): ");
		
		//getting user input
		searchInt = input.nextInt();
		while(searchInt != -1)
		{
			position = array1.linearSearch(searchInt);
			if(position == -1)
				System.out.println("The integer " + searchInt + " was not found.\n");
			else
				System.out.println("The integer " + searchInt + " was found in position " + position + ".\n");
			
			System.out.print("Please enter an integer value(-1 to quit): ");
			searchInt = input.nextInt();
		}
	}
}
