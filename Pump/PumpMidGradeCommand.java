package Pump;

import Command.Command;
import Tank.TankException;

public class PumpMidGradeCommand implements Command {
	Pump pump;
	@Override
	public void pump(long amount) throws PumpException {
		pump = new Pump();
		pump.pumpMidGrade(amount);
	}

}
