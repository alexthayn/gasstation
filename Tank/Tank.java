package Tank;

/**
 * Tank abstract class that sets prereqs for a Tank concrete class
 * @author jacksonportersnow and goofyChicken
 *
 */
public abstract class Tank {
	//Global variables
	private long capacity, amount;

	
	/**
	 * Creates a tank object (is a singleton object)
	 */
	public Tank() {};
	
//	/**
//	 * Returns instance of tank object (only one exists)
//	 * @return Tank object
//	 */
//	public abstract Tank getTank();
	
	/**
	 * Sets capacity of tank
	 * @param capacity capacity of tank
	 */
	protected void setCapacity(double capacity)
	{
		long c = (long) capacity*100;
		this.capacity = c;
	}
	
	/**
	 * Get the capacity of the tank
	 * @return double value of capacity
	 */
	public double getCapacity()
	{
		double capacity = (double) (this.capacity/100);
		return capacity;
	}
	
	/**
	 * Returns amount of gas inside the tank
	 * @return amount of gas inside tank
	 */
	public synchronized double getAmount()
	{
		double amount = (double) (this.amount/100);
		return amount;
	}
	
	/**
	 * Fill tank to a given amount up to capacity of tank
	 * @param amount given amount
	 * @throws TankException error when capacity is hit
	 */
	public void refill(double amount) throws TankException
	{
		long a = (long) amount*100;
		long fillRemaining = (this.amount + a) - this.capacity;
		
		if((this.amount + a) > this.capacity)
		{
			this.amount = this.capacity;
			throw new TankException("You have hit capacity, " + fillRemaining + " gallons could not be added.");
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
		long a = (long) amount*100;
		if(a > this.amount)
		{
			throw new TankException("Insufficient amount of fuel remaining.");
		}
		
		this.amount -= a;
		
	}
	
	/**
	 * Returns if the tank is empty or not
	 * @return
	 */
	public Boolean isEmpty() {
		return (this.amount <= 0);
	}
	
	
	
}
