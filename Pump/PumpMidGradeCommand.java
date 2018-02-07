package Pump;

import Command.Command;
import Tank.TankException;
/**
 * Contains PumpDieselCommand which pumps diesel gas out of the diesel tank using a pump object.
 * @author alexthayn
 *
 */
public class PumpMidGradeCommand implements Command {
	Pump pump;
	
	@Override
	public void pump(long amount) throws PumpException, TankException {
		pump = new Pump();
		pump.pumpMidGrade(amount);
	}

}
