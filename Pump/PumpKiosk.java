package Pump;

public class PumpKiosk implements Runnable{

	//Global variables
	private long dieselCost;
	private long premCost;
	private long midCost;
	private long unlCost;
	
	PumpDieselCommand dieselCommand;
	PumpMidGradeCommand midGradeCommand;
	PumpPremiumCommand premiumCommand;
	PumpUnleadedCommand unleadedCommand;

	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
