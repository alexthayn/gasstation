package Tank;

/**
 * Tank abstract class that sets prereqs for a Tank concrete class
 * @author jacksonportersnow
 *
 */
public abstract class Tank {
	//Global variables
	private double capacity, amount;

	
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
		this.capacity = capacity;
	}
	
	/**
	 * Get the capacity of the tank
	 * @return double value of capacity
	 */
	public double getCapacity()
	{
		return this.capacity;
	}
	
	/**
	 * Returns amount of gas inside the tank
	 * @return amount of gas inside tank
	 */
	public double getAmount()
	{
		return this.amount;
	}
	
	/**
	 * Fill tank to a given amount up to capacity of tank
	 * @param amount given amount
	 * @throws TankException error when capacity is hit
	 */
	public void refill(double amount) throws TankException
	{
		double fillRemaining = (this.amount + amount) - this.capacity;
		
		if((this.amount + amount) > this.capacity)
		{
			this.amount = this.capacity;
			throw new TankException("You have hit capacity, " + fillRemaining + " gallons could not be added.");
		}
		
		
		this.amount += amount;
	}
	
	/**
	 * Removes a specified amount of fuel from the tank until tank is empty.
	 * @param amount amount of fuel to remove
	 * @throws TankException error when tank is empty
	 */
	public synchronized void remove(double amount) throws TankException
	{
		if(amount > this.amount)
		{
			throw new TankException("Insufficient amount of fuel remaining.");
		}
		
		this.amount -= amount;
		
	}
	
	/**
	 * Returns if the tank is empty or not
	 * @return
	 */
	public Boolean isEmpty() {
		return (this.amount <= 0);
	}
	
	
	
}
