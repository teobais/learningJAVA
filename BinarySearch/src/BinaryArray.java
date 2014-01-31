import java.util.Random;
import java.util.Arrays;

public class BinaryArray {

	private int[] data;
	private static final Random generator = new Random();
	
	public BinaryArray(int size)
	{
		data = new int[size];
		
		//filling array with random integers with rang 10-99
		for (int i=0 ; i < size ; i++)
		{
			data[i] = 10 + generator.nextInt(90);
		}
		
		Arrays.sort(data);
	}
	
	//binary search execution to the existed data
	public int binarySearch(int searchElement)
	{
		int low = 0;
		int high = data.length - 1;
		int middle = (low + high + 1) / 2;
		int location = -1;	//return value, -1, if not found
		
		do	//repeating to find the specified element
		{
			//emfanisi enapomeinantwn stoixeiwn tou pinaka
			System.out.print(remainingElements(low,high));
			
			for(int i=0 ; i < middle ; i++)
			{
				System.out.print(" ");
			}
			System.out.println( "  * ");
			//to stoixeio vrisketai sti mesi
			if(searchElement == data[middle])
				location = middle;
			
			//to mesaio stoixeio einai polu upsilo
			else if (searchElement < data[middle])
				high = middle - 1;
			else //to mesaio stoixeio einai polu xamilo
				low = middle + 1;
			
			middle = (low + high + 1) / 2;
		}while ((low <= high) && (location == -1));
		
		return location;
	}
	
	public String remainingElements(int low,int high)
	{
		StringBuilder temporary = new StringBuilder();
		
		//emfanisi kenwn gia stoixisi
		for(int i=0 ; i < low ; i++)
			temporary.append(" ");	
		
		//emfanisi enapomeinantwn ston pinaka stoixeiwn 
		for(int i=low ; i<= high ; i++)
			temporary.append(data[i] + " ");
		
		temporary.append("\n");
		return temporary.toString();
	}
	
	public String toString()
	{
		return remainingElements(0,data.length - 1);
	}
}
