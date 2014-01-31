import java.util.Scanner;

public class BinarySearchTest {

	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		int searchInt;	//search key
		int position;	//position of search key in a table
		
		BinaryArray binary = new BinaryArray(15);
		System.out.print(binary);
		
		System.out.print("Please enter an integer value(-1 to quit): ");
		searchInt = input.nextInt();
		System.out.println();
		
		while(searchInt != -1)
		{
			position = binary.binarySearch(searchInt);
			if(position == -1)
				System.out.println("The integer " + searchInt + " was not found.\n");
			else
				System.out.println("The integer " + searchInt + " was found in position " + position + ".\n");
			
			System.out.print("Please enter an integer value(-1 to quit): ");
			searchInt = input.nextInt();
			System.out.println();
		}
		
	}
}
