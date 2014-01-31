
public class InitArray {

	//creating and printing 2d arrays
	public static void main(String[] args)
	{
		int[][] array1={ {1,2,3,} , {4,5,6} };
		int[][] array2={ {1,2} , {3} , {4,5,6} };
		
		System.out.println("Values in array1 by row are:");
		outputArray(array1);	//prints array1 by row
		
		System.out.println("Values in array2 by row are:");
		outputArray(array2);	//prints array2 by row
	}
	
	//prints row and columns of a 2d array
	public static void outputArray(int[][] array)
	{
		//2d's array iteration loop
		for(int row=0;row<array.length;row++)
		{
			//current column iteration loop
			for(int column=0;column<array[row].length;column++)
			{
				System.out.printf("%d ", array[row][column]);
			}
			
			System.out.println();
		}
	}
}
