
public class CommissionEmployee3 {

	private String firstName;
	private String lastName;
	private String socialSecurityNumber;
	private double grossSales;
	private double commissionRate;
	
	public CommissionEmployee3(String first,String last,String ssn,double sales,double rate)
	{
		firstName = first;
		lastName = last;
		socialSecurityNumber = ssn;
		setGrossSales(sales);
		setCommissionRate(rate);
	}
	
	public void setFirstName(String first)
	{
		firstName = first;
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public void setLastName(String last)
	{
		lastName = last;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public void setSocialSecurityNumber(String ssn)
	{
		socialSecurityNumber = ssn;
	}
	
	public String getSocialSecurityNumber()
	{
		return socialSecurityNumber;
	}
	
	public void setGrossSales(double sales)
	{
		grossSales = (sales < 0.0 ) ? 0.0 : sales;
	}
	
	public double getGrossSales()
	{
		return grossSales;
	}
	
	public void setCommissionRate(double rate)
	{
		commissionRate = ( rate > 0.0 && rate < 1.0 ) ? rate : 0.0;
	}
	
	public double getCommissionRate()
	{
		return commissionRate;
	}
	
	public double earnings()
	{
		return getCommissionRate() * getGrossSales();
	}
	
	@Override //upodeiknuei oti afti i me9odos epikaluptei 1 me9odo tis uperklasis
	public String toString()
	{
		return String.format("%s: %s %s\n%s: %s\n%s: %.2f\n%s: %.2f","Commission employee",firstName,lastName,
				"Social Security Number", socialSecurityNumber,"grossSales",getGrossSales(),"Commission Rate",
				getCommissionRate());
	}
	
	
}
