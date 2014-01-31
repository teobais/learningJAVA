import java.util.Random;
import java.util.Arrays;

public class LinearArray {

	private int[] data;	//pinakas timwn
	private static Random generator = new Random();
	
	//creates a predefined array, filling its positions with random numbers
	public LinearArray(int size)
	{
		data = new int[size];	//making area for the table
		for(int i=0;i<size;i++)
		{
			data[i] = 10 + generator.nextInt(90);
		}
	}//end of constructor
	
	//executing linear search to the data
	public int linearSearch(int searchKey)
	{
		//running-into table
		for (int index=0 ; index < data.length ; index++)
		{
			if(data[index] == searchKey)
			{
				return index;
			}
		}
		return -1;	//integer not found
	}
	
	//method to export values to a table
	public String toString()
	{
		return Arrays.toString(data);
	}
	
}
