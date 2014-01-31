import java.util.ArrayList;

public class ArrayListCollection {

	public static void main(String[] args)
	{
		//creating a new ArrayList from String
		ArrayList <String> items = new ArrayList <String> ();
		
		items.add("red");		//appending an element to list
		items.add(0,"yellow");	//input value to zero-pointer
		
		//header
		System.out.print("Display list contents with counter-controlled loop:" );
		
		//displaying color list
		for(int i=0;i<items.size();i++)
		{
			System.out.printf(" %s",items.get(i));
		}
		
		//displaying color list using foreach to display method
		display(items,"\nDisplay list contents with enhanced for statement:");
		
		//adding 2 colors to list
		items.add("green");
		items.add("yellow");
		display(items,"List with 2 new elements:");
		
		//removing an element
		items.remove("yellow");
		display(items,"Remove first instance of yellow: ");
		
		//removing an element that has a value of 1 to its pointer
		items.remove(1);
		display(items,"Remove second list element(green):");
		
		//checking if one value is appointed to the list
		System.out.printf("\"red\" is %s in the list\n",items.contains("red") ? "" : "not ");
	
		//displays elements's number of List
		System.out.printf("Size: %s\n", items.size());
	}
	
	public static void display(ArrayList <String> items,String header)
	{
		System.out.print(header);	//prints the header
		
		//prints each element to item
		for(String item:items)
			System.out.printf(" %s", item);
		
		System.out.println();
	}
}
