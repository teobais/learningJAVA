
public abstract class Employee {

	private String firstName;
	private String lastName;
	private String socialSecurityNumber;
	
	public Employee(String first,String last,String ssn)
	{
		firstName = first;
		lastName = last;
		socialSecurityNumber = ssn;
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
	
	@Override
	public String toString()
	{
		return String.format("%s %s\nsocial security number: %s",
				getFirstName(),getLastName(),getSocialSecurityNumber());
	}
	
	//abstract method overrided from subclasses
	public abstract double earnings();	//de dinetai edw i ulopoiisi tis
	//orizetai edw, wste meta, ka9e employee object, pou kalei 
	//ta opoia orizontai apo tis antistoixes epikaluptomenes me9odous tn upoklasewn
}
