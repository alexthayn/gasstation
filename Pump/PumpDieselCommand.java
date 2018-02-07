package Pump;

import Command.Command;
import Tank.TankException;

public class PumpDieselCommand implements Command {
	Pump pump;
	@Override
	public void pump(long amount) throws PumpException, TankException {
		// TODO Auto-generated method stub
		pump = new Pump();
		pump.pumpDiesel(amount);
	}
}
