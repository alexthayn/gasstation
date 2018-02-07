package Pump;

import Command.Command;
import Tank.TankException;

public class PumpPremiumCommand implements Command {
	Pump pump;
	@Override
	public void pump(long amount) throws PumpException {
		// TODO Auto-generated method stub
		pump = new Pump();
		pump.pumpPremium(amount);
	}
}
