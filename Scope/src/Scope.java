
public class Scope {

	private int x=1;
	
	public void begin()
	{
		int x=5;
		System.out.println("local x in method begin is "+x);
		
		useLocalVariable();
		useField();
		useLocalVariable();
		useField();

		System.out.println("\nlocal x in method begin is "+x);
	}
	
	public void useLocalVariable()
	{
		int x=25;
		
		System.out.println("\nlocal x entering on method useVariable is "+x);
		++x;
		System.out.println("local x before exiting method useVariable is "+x);
	}
	
	public void useField()
	{
		System.out.println("\nfield x entering on method useField is "+x);
		x*=10;
		System.out.println("local x before exiting method useField is "+x);
	}
}
