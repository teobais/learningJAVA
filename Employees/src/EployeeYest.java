
public class EployeeYest {

	public static void main(String[] args)
	{
		Date birth = new Date(7,24,1949);
		Date hire = new Date(3,12,1988);
		
		Employee kurios = new Employee("Thodoris","Bais",birth,hire);
		
		
		//ousiastika, kalei EMMESA tin public me9odo tis klasis Employee, toString()
		System.out.println(kurios);
	}
}
