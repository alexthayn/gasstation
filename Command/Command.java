package Command;

import Pump.PumpException;
import Tank.TankException;

/**
 * General Command interface for our pumpcommands
 * @author tymcb
 *
 */
public interface Command {
	/**
	 * Pumps specified amount of gas out of a tank.
	 * @param amount amount of gas to remove in gallons
	 * @throws PumpException thrown if there is problem when pumping gas.
	 * @throws TankException thrown if there is low gas or out of gas within tank.
	 */
	public void pump(long amount) throws PumpException, TankException;
}
