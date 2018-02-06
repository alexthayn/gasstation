package Pump;

import Command.Command;

public class PumpDieselCommand implements Command {
	Pump pump;
	@Override
	public void pump() {
		// TODO Auto-generated method stub
		pump = new Pump();
	}

}
