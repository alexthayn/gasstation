package Command;

import Tank.TankException;

/**
 * 
 * @author tymcb
 *
 */
public interface Command {
	public void pump(long amount) throws TankException;
}
