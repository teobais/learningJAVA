
public class Invoice implements Payable{

	private String partNumber;
	private String partDescription;
	private int quantity;
	private double pricePerItem;
	
	public Invoice(String part,String Description,int count,double price)
	{
		partNumber = part;
		partDescription = Description;
		setQuantity(count);
		setPricePerItem(price);
	}
	
	public void setPartNumber(String part)
	{
		partNumber = part;
	}
	
	public String getPartNumber()
	{
		return partNumber;
	}
	
	public void setPartDecription(String Description)
	{
		partDescription = Description;
	}
	
	public String getPartDescription()
	{
		return partDescription;
	}
	
	public void setQuantity(int count)
	{
		quantity = (count < 0) ? 0 : count;
	}
	
	public int getQuantity()
	{
		return quantity;
	}
	
	public void setPricePerItem(double price)
	{
		pricePerItem = (price < 0.0 ) ? 0.0 : price;
	}
	
	public double  getPricePerItem()
	{
		return pricePerItem;
	}
	
	@Override
	public String toString()
	{
		return String.format("%s: \n%s: %s (%S) \n%s: %d \n%s: $%,.2f",
				"invoice","part number",getPartNumber(),getPartDescription(),
				"quantity",getQuantity(),"price per item",getPricePerItem());
	}
	
	@Override
	public double getPaymentAmount() {
		// TODO Auto-generated method stub
		return getQuantity() * getPricePerItem();
	}

	
}
