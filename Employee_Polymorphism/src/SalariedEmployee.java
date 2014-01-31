
public class SalariedEmployee extends Employee{

	

	private double weeklySalary;
	
	public SalariedEmployee(String first, String last, String ssn,double salary)
	{
		super(first, last, ssn);
		setWeeklySalary(salary);
	}

	public void setWeeklySalary(double salary)
	{
		weeklySalary = salary < 0.0 ? 0.0 : salary;		
	}
	
	private double getWeeklySalary()
	{
		return weeklySalary;
	}
	
	
	//computing earnings and overriding abstract method earnings() to Employee
	@Override
	public double earnings()
	{
		return getWeeklySalary();
	}
	
	//return SalariedEmployees object's string format
	@Override
	public String toString()
	{
		return String.format("salaried employee: %s\n%s: $%,.2f",
				super.toString(),"weekly salary",getWeeklySalary());
	}
	
}
