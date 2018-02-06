package Command;

import Pump.PumpException;

/**
 * 
 * @author tymcb
 *
 */
public interface Command {
	public void pump(long amount) throws PumpException;
}
