
public class PolymorhismTest {

	public static void main(String[] args)
	{
		CommissionEmployee commissionEmployee = new CommissionEmployee("Samantha","Paok",
				"234-56-7891",10000,.06);
		
		BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Samantha",
				"TB","132-56-7891",5000,.04,300);
		
		System.out.printf("%s %s:\n\n%s\n\n","Call CommissionEmployee's toString with superclass reference",
				"to superclass object",commissionEmployee.toString());
		
		System.out.printf("%s %s:\n\n%s\n\n","Call BasePlusCommissionEmployee's toString with subclass reference",
				"to subclass object",basePlusCommissionEmployee.toString());
		
		CommissionEmployee commissionEmployee2 = basePlusCommissionEmployee;
		System.out.printf("%s %s:\n\n%s\n\n","Call BasePlusCommissionEmployee's toString with subclass reference",
				"to superclass object",commissionEmployee2.toString());
	}
}
