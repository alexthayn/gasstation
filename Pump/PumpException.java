package Pump;

/**
 * PumpException used if there is a problem when pumping gas
 * @author tybayn
 *
 */
public class PumpException extends Exception{

private long amountPumped;
	
	/**
	 * Creates a PumpException object with no message or amount that was pumped.
	 */
	public PumpException()
	{
		
	}
	
	/**
	 * Creates a PumpException object with a message and amount of gas that was pumped.
	 * @param message Message to display
	 * @param amount amount of gasoline in gallons that was pumped
	 */
	public PumpException(String message, long amount)
	{
		super(message);
		amountPumped = amount;
	}
	
	/**
	 * Returns amount of gasoline that was pumped.
	 * @return amount of gasoline that was pumped in gallons before exception was thrown
	 */
	public long getAmount() {
		return amountPumped;
	}
}
