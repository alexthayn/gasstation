package Command;

import Pump.PumpException;
import Tank.TankException;

/**
 * 
 * @author tymcb
 *
 */
public interface Command {
	public void pump(long amount) throws PumpException, TankException;
}
