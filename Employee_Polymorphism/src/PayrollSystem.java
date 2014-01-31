
public class PayrollSystem {

	public static void main(String[] args)
	{
		SalariedEmployee salaried = new SalariedEmployee("John","Smith","111-11-1111",800.00);
		HourlyEmployee hourly = new HourlyEmployee("Karen","Price","222-22-2222",16.75,40);
		CommissionEmployee commission = new CommissionEmployee("Bob","Lewis","444-44-4444",5000,.06);
		BasePlusCommissionEmployee basePlus = new BasePlusCommissionEmployee("SUe","Jones","333-33-3333",
				10000,.04,300);
		
		System.out.println("Employee processed individually:\n");
		System.out.printf("%s\n%s: $%,.2f\n\n",salaried,"earned",salaried.earnings());
		System.out.printf("%s\n%s: $%,.2f\n\n",hourly,"earned",hourly.earnings());
		System.out.printf("%s\n%s: $%,.2f\n\n",commission,"earned",commission.earnings());
		System.out.printf("%s\n%s: $%,.2f\n\n",basePlus,"earned",basePlus.earnings());
				
				
		
		Employee[] employees = new Employee[4];
		
		employees[0]=salaried;
		employees[1]=hourly;
		employees[2]=commission;
		employees[3]=basePlus;
		
		System.out.println("Employee processed polymorhically:\n");
		
		for(Employee currentEmployee : employees)
		{
			System.out.println(currentEmployee);
			if(currentEmployee instanceof BasePlusCommissionEmployee)
			{
				//upovivasmos typou anaforas Employee
				//se anafora BasePlusCommissionEmployee
				BasePlusCommissionEmployee employee = (BasePlusCommissionEmployee) currentEmployee;
				employee.setBaseSalary(1.10 * employee.getBaseSalary());
				
				System.out.printf("New base salary with 10%% incrase is: $%,.2f\n",employee.getBaseSalary());
			}
			System.out.printf("earned $%,.2f\n\n",currentEmployee.earnings());
		}
		
		for(int j=0;j<employees.length;j++)
		{
			System.out.printf("Employee %d is a %s\n",j,employees[j].getClass().getName());
		}
	}
}
