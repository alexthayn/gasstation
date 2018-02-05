package Pump;
import Tank.*;

/**
 * 
 * @author tymcb
 *
 */
public class Pump implements Runnable{
	
	private final double tickAmount = 0.1;
	
	private String name = null;
	private double amount = 0.0, cost = 0.0;
	
	private static Tank dieselTank;
	private static Tank premiumTank;
	private static Tank unleadedTank;
	
	
	public Pump() {	};
	
	public void diesel(){
		
		double pumped = 0.0;
		double total = 0.0;
		
		while (pumped < amount) {
			dieselTank = DieselTank.getDieselTank();
			
			try {
				dieselTank.remove(tickAmount);
				pumped += tickAmount;
				total += (cost * tickAmount);
				System.out.println(name + ":" +pumped + ":$" + total);
			}catch(TankException te) {
				
			}
			
			if(dieselTank.isEmpty())
				break;
		}
	}
	
	public void premium() {
		premiumTank = PremiumTank.getPremiumTank();
	}
	
	public void midgrade() {
		
	}
	
	public void unleaded() {
		unleadedTank = UnleadedTank.getUnleadedTank();
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String info = Thread.currentThread().getName();
		String brokenInfo[] = info.split(":");
		name = brokenInfo[0];
		amount = Double.parseDouble(brokenInfo[2]);
		cost = Double.parseDouble(brokenInfo[3]);
		
		if(brokenInfo[1].equals("diesel")) {
			System.out.println("Made a diesel request for " + name);
			this.diesel();}
		else if(brokenInfo[1].equals("premium"))
			this.premium();
		else if(brokenInfo[1].equals("midgrade"))
			this.midgrade();
		else if(brokenInfo[1].equals("unleaded"))
			this.unleaded();
		
	}
	
	
}
