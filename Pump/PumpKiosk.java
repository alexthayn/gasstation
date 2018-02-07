package Pump;

import Tank.TankException;

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
		return ((double)num) / 100;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub

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
				
				synchronized(this){
					System.out.println("\n" + Thread.currentThread().getName() + ":");
					System.out.println("Request: " + toDouble(amount) + " gallons of " + gasType);
					System.out.println("Amount pumped: " + toDouble(amount) + " gallons");
					System.out.print("Price per gallon: $");
					System.out.printf("%.2f\n", toDouble(curCost));
					System.out.print("Total cost: $");
					System.out.printf("%.2f\n", toDouble(amount) * toDouble(curCost));
					PumpThread.currentThread().setOpen();
				}
				
			}catch (PumpException pe) {
				synchronized(this){
					
					System.out.println("\n" + Thread.currentThread().getName() + ":");
					System.out.println("Request: " + toDouble(amount) + " gallons of " + gasType);
					System.out.println(pe);
					System.out.println("Amount pumped: " + toDouble(pe.getAmount()) + " gallons");
					System.out.print("Price per gallon: $");
					System.out.printf("%.2f\n", toDouble(curCost));
					System.out.print("Total cost: $");
					System.out.printf("%.2f\n", toDouble(pe.getAmount()) * toDouble(curCost));
					PumpThread.currentThread().setOpen();
					
				}
			}
			catch(TankException te) {
				synchronized(this){
					
					System.out.println("\n" + Thread.currentThread().getName() + ":");
					System.out.println("Request: " + toDouble(amount) + " gallons of " + gasType);
					System.out.println(te.getMessage());
					System.out.println("Amount pumped: " + toDouble(amount) + " gallons");
					System.out.print("Price per gallon: $");
					System.out.printf("%.2f\n", toDouble(curCost));
					System.out.print("Total cost: $");
					System.out.printf("%.2f\n", toDouble(amount) * toDouble(curCost));
					PumpThread.currentThread().setOpen();
					
				}
			}
			
			catch (Exception e) {
				System.out.println(e);
			}
			
			try {Thread.sleep(100);}catch(Exception e) {};
	}
}
