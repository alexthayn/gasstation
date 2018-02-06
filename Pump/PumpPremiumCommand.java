package Pump;

import Command.Command;
import Tank.TankException;

public class PumpPremiumCommand implements Command {
	Pump pump;
	@Override
	public void pump(long amount) throws TankException {
		// TODO Auto-generated method stub
		pump = new Pump();
		pump.pumpDiesel(amount);
	}
}
