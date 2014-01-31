
public class InitArray {

	public static void main(String[] args)
	{
		//checking command line No of arguments
		if(args.length !=3)
			System.out.println("Error:Please re-enter the entire command,including\n an " +
					"array size, initial value and increment");
		else
		{
			//takes the table's length from the first argument
			int arrayLength=Integer.parseInt(args[0]);
			int[] array=new int[arrayLength];	//creates a table
			
			//takes the initial value and increases from command line's argument
			int initialValue=Integer.parseInt(args[1]);
			int increment=Integer.parseInt(args[2]);
			
			//computing the value of each table element
			for(int counter=0;counter<array.length;counter++)
			{
				array[counter]=initialValue+increment*counter;
			}
			
			System.out.printf("%s%8s\n", "Index","Value");
			
			//printing thesis pointer and array value
			for(int counter=0;counter<array.length;counter++)
			{
				System.out.printf("%5d%8d\n",counter,array[counter]);
			}
		}
	}
}
