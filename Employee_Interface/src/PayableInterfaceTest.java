
public class PayableInterfaceTest {

	public static void main(String[] args)
	{
		Payable[] someObjects = new Payable[4];
		
		someObjects[0] = new Invoice("01234","seat",2,375.00);
		someObjects[1] = new Invoice("56789","tire",4,79.95);
		someObjects[2] = new SalariedEmployee("John","Smith","111-11-1111",800.00);
		someObjects[3] = new SalariedEmployee("Lisa","Barnes","888-88-8888",1200.00);
		
		System.out.println("Invoices and Employee processed polymorhically:\n");
		for(Payable current : someObjects)
		{
			System.out.printf("%s \n%s: $%,.2f\n\n",current.toString(),"payment due",current.getPaymentAmount());
		}
	}
}
