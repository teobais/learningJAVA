
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
	
	
	//upologizei tis apodoxes kai ulopoiei ti me9odo diasundesis Payable
	//i opoia itan abstract stin uperklasi Employee
	@Override
	public double getPaymentAmount()
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
