package Store;

public class CustomerOrder {
	//Global Variables
	String type, name;
	Double amount;
	
	public CustomerOrder(String name, String type, double amount)
	{
		this.name = name;
		this.type = type;
		this.amount = amount;
	}
	
	public String getType() {
		return this.type;
	}
	
	public double getAmount() {
		return this.amount;
	}
	
	@Override
	public String toString()
	{
		return name + ":" + type + ":" + amount;
	}
}
