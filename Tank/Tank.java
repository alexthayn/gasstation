package Tank;

/**
 * Tank abstract class that sets prereqs for a Tank concrete class
 * @author jacksonportersnow, tybayn, alexthayn
 *
 */
public abstract class Tank {
	//Global variables
	private long capacity, amount;

	
	/**
	 * Creates a tank object (is a singleton object)
	 */
	public Tank() {};
		
	/**
	 * Sets capacity of tank
	 * @param capacity capacity of tank
	 */
	protected void setCapacity(double capacity)
	{
		long c = (long) Math.floor(capacity * 100);
		this.capacity = c;
	}
	
	/**
	 * Get the capacity of the tank
	 * @return double value of capacity
	 */
	public double getCapacity()
	{
		double capacity = ((double)(this.capacity))/100;
		return capacity;
	}
	
	/**
	 * Returns amount of gas inside the tank
	 * @return amount of gas inside tank
	 */
	public synchronized double getAmount()
	{
		double amount = ((double) (this.amount))/100;
		return amount;
	}
	
	/**
	 * Fill tank to a given amount up to capacity of tank
	 * @param amount given amount
	 * @throws TankException error when capacity is hit
	 */
	public void refill(double amount) throws TankException
	{
		long a = (long) Math.floor(amount*100);
		
		if((this.amount + a) > this.capacity)
		{
			this.amount = this.capacity;
			throw new TankException("full");
		}
		
		
		this.amount += a;
	}
	
	/**
	 * Removes a specified amount of fuel from the tank until tank is empty.
	 * @param amount amount of fuel to remove
	 * @throws TankException error when tank is empty
	 */
	public synchronized void remove(double amount) throws TankException
	{
		long a = (long) Math.floor(amount*100);
		if((a > this.amount) || this.isEmpty())
		{
			throw new TankException("empty");
		}
		
		
		this.amount -= a;
		//System.out.println("TANK AT: " + this.amount + " gallons");
		
		
		if((this.amount/100) < 100.0)
		{
			throw new TankException("This gas tank is low, we have less than 100 gallons left.");
		}
	}
	
	/**
	 * Returns if the tank is empty or not
	 * @return returns if tank IS empty
	 */
	public Boolean isEmpty() {
		return (this.amount <= 0);
	}
}
