
public class EmployeeTest {

	public static void main(String[] args)
	{
		System.out.printf("Employees before instantiation: %d\n",Employee.getCount());
		
		Employee e1 = new Employee("Susan","Baker");
		Employee e2 = new Employee("Bob","Blue");
		
		//showing that count equals 2 after creating 2 new employees
		System.out.println("\nEmployees after instantiation: ");
		System.out.printf("via e1.getCount(): %d\n",e1.getCount());
		System.out.printf("via e2.getCount(): %d\n",e2.getCount());
		System.out.printf("via Employee.getCount(): %d\n",Employee.getCount());
		
		//feedbacking employees' names
		System.out.printf("\nEmployee 1: %s %s\nEmployee 2: %s %s\n",e1.getFirstName(),
				e1.getLastName(),e2.getFirstName(),e2.getLastName());
		
		//ta parapanw 2 upodeiknuoun oti einai upopsifia gia ti sullogi aporrimatwn
		e1 = null;
		e2 = null;
	}
}
