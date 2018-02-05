package Pump;
import Tank.*;

/**
 * 
 * @author tymcb
 *
 */
public class Pump implements Runnable{
	
	private final double tickAmount = 0.1;
	
	private static Tank dieselTank;
	private static Tank premiumTank;
	private static Tank unleadedTank;
	
	
	public Pump() {	};
	
	public void diesel(String name, double amount, double cost){
		
		double pumped = 0.0;
		double total = 0.0;
		
		while (pumped < amount) {

			try {
				Thread.sleep(50);
			}catch(Exception e) {
				
			}

			dieselTank = DieselTank.getDieselTank();
			synchronized(dieselTank) {	
				try {
					
						dieselTank.remove(tickAmount);
						pumped += tickAmount;
						total += (cost * tickAmount);
						System.out.println(name + ":" +pumped + ":$" + total + "\nRemaining in diesel tank: " + dieselTank.getAmount() + " g.\n");
					
				}catch(TankException te) {
					System.out.println(te);
					break;
				}
				
				if(dieselTank.isEmpty()) {
					System.out.println("Tank is empty!");
					break;
				}
			}

		}
	}
	
	public void premium(String name, double amount, double cost) {
		premiumTank = PremiumTank.getPremiumTank();
	}
	
	public void midgrade(String name, double amount, double cost) {
		
	}
	
	public void unleaded(String name, double amount, double cost) {
		unleadedTank = UnleadedTank.getUnleadedTank();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String info = Thread.currentThread().getName();
		String brokenInfo[] = info.split(":");
		String name = brokenInfo[0];
		double amount = Double.parseDouble(brokenInfo[2]);
		double cost = Double.parseDouble(brokenInfo[3]);
		
		if(brokenInfo[1].equals("diesel")) {
			System.out.println("Made a diesel request for " + name);
			this.diesel(name, amount, cost);}
		else if(brokenInfo[1].equals("premium"))
			this.premium(name, amount, cost);
		else if(brokenInfo[1].equals("midgrade"))
			this.midgrade(name, amount, cost);
		else if(brokenInfo[1].equals("unleaded"))
			this.unleaded(name, amount, cost);
		
	}
	
	
}
