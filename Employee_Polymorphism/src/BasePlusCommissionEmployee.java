
public class BasePlusCommissionEmployee extends CommissionEmployee{

	private double baseSalary;
	
	public BasePlusCommissionEmployee(String first, String last, String ssn,
			double sales, double rate,double salary)
	{
		super(first, last, ssn, sales, rate);
		setBaseSalary(salary);
	}
	
	public void setBaseSalary(double salary)
	{
		baseSalary = (salary < 0.0) ? 0.0 : salary;
	}
	
	public double getBaseSalary()
	{
		return baseSalary;
	}
	
	//upologismos apodoxwn kai epikalupsi me9odwn earnings stin CommissionEmployee
	@Override
	public double earnings()
	{
		return getBaseSalary() + super.earnings();
	}
	
	//epistrofi string anaparastasis tou antikeimenou BasePlusCommissionEmployee
	@Override
	public String toString()
	{
		return String.format("%s %s; %s: $%,.2f",
				"base-salaried",super.toString(),
				"base salary",getBaseSalary());
	}

}
