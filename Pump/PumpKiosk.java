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

	public PumpKiosk()
	{
		dieselCommand = new PumpDieselCommand();
		midGradeCommand = new PumpMidGradeCommand();
		premiumCommand = new PumpPremiumCommand();
		unleadedCommand = new PumpUnleadedCommand();
	}
	
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
	
	private static double toDouble(long num) {
		return ((double)num) * 100;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		synchronized(this){
			long amount = PumpThread.currentThread().getAmount();
			String gasType = PumpThread.currentThread().getGasType();
			long curCost = 0;
			
			try {
				if(gasType.equals("diesel")) {
					curCost = dieselCost;
					dieselCommand.pump(amount);
				}
				else if(gasType.equals("premium")) {
					curCost = premCost;
					premiumCommand.pump(amount);
				}
				else if(gasType.equals("midgrade")) {
					curCost = midCost;
					midGradeCommand.pump(amount);
				}
				else if(gasType.equals("unleaded")) {
					curCost = unlCost;
					unleadedCommand.pump(amount);
				}
			}catch (PumpException pe) {
				System.out.println(pe);
				System.out.println("Amount pumped: " + toDouble(pe.getAmount()));
				System.out.println("Total cost: $" + toDouble(pe.getAmount() * curCost));
				PumpThread.currentThread().setOpen();
			}
			System.out.println("Amount pumped: " + toDouble(amount));
			System.out.println("Total cost: $" + toDouble(amount * curCost));
			PumpThread.currentThread().setOpen();
		}
	}
}
