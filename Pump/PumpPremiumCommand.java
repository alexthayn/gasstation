package Pump;

import Command.Command;
import Tank.TankException;
/**
 * Contains PumpDieselCommand which pumps diesel gas out of the diesel tank using a pump object.
 * @author alexthayn
 *
 */
public class PumpPremiumCommand implements Command {
	Pump pump;
	@Override
	public void pump(long amount) throws PumpException, TankException {
		// TODO Auto-generated method stub
		pump = new Pump();
		pump.pumpPremium(amount);
	}
}
