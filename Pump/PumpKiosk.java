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

	public void setDieselCost(double cost) {
		dieselCost = (long) Math.floor(cost * 100);
	}
	
	public void setPremiumCost(double cost) {
		premCost = (long) Math.floor(cost * 100);
	}
	
	public void setMidgradeCost(double cost) {
		midCost = (long) Math.floor(cost * 100);
	}
	
	public void setUnleadedCost(double cost) {
		unlCost = (long) Math.floor(cost * 100);
	}
	
	public double getDieselCost() {
		return ((double) dieselCost) / 100.00;
	}
	
	public double getPremiumCost() {
		return ((double) premCost) / 100.00;
	}
	
	public double getMidgradeCost() {
		return ((double) midCost) / 100.00;
	}
	
	public double getUnleadedCost() {
		return ((double) unlCost) / 100.00;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		long amount = PumpThread.currentThread().getAmount();
		String gasType = PumpThread.currentThread().getGasType();
		
		try {
			if(gasType.equals("diesel"))
				dieselCommand.pump(amount);
			else if(gasType.equals("premium"))
				premiumCommand.pump(amount);
			else if(gasType.equals("midgrade"))
				midGradeCommand.pump(amount);
			else if(gasType.equals("unleaded"))
				unleadedCommand.pump(amount);
		}catch (Exception e) {
			
		}
		
		PumpThread.currentThread().setOpen();
		
	}

}
