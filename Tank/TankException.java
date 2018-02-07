package Tank;

/**
 * TankException is thrown when tank is empty or low on fuel
 * @author jacksonporter, alexthayn, tybayn
 *
 */
public class TankException extends Exception {
	
	/**
	 * Creates a TankException object with no message
	 */
	public TankException()
	{
		
	}
	
	/**
	 * Creates a TankException object with a message
	 * @param message message to be stored and able to be displayed
	 */
	public TankException(String message)
	{
		super(message);
	}
}
