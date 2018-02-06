package Pump;

import Command.Command;

public class PumpPremiumCommand implements Command {

	
	public PumpPremiumCommand() {};
	
	@Override
	public void execute(Pump pump, double amount, double cost) {
		// TODO Auto-generated method stub
		int pumpId = pump.getId();
		String com = "Pump " + pumpId + ":premium:" + amount + ":" + cost;
		Thread fill = new Thread(pump,com);
		fill.start();
	}
}
