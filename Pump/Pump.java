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
	
	private boolean occupied;
	private int id;
	
	
	public Pump(int id) {	
		occupied = false;
		this.id = id;
	};
	
	/**
	 * 
	 * @param name
	 * @param amount
	 * @param cost
	 */
	public void diesel(String name, double amount, double cost){
		
		double pumped = 0.0;
		double total = 0.0;
		
		while (pumped < amount) {

			try {Thread.sleep(10);}catch(Exception e) {}

			dieselTank = DieselTank.getTank();
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
					System.out.println("Diesel Tank is empty!");
					break;
				}
			}

		}
	}
	
	/**
	 * 
	 * @param name
	 * @param amount
	 * @param cost
	 */
	public void premium(String name, double amount, double cost) {

		double pumped = 0.0;
		double total = 0.0;
		
		while (pumped < amount) {

			try {Thread.sleep(10);}catch(Exception e) {}

			premiumTank = PremiumTank.getTank();
			synchronized(premiumTank) {	
				try {
					
						premiumTank.remove(tickAmount);
						pumped += tickAmount;
						total += (cost * tickAmount);
						System.out.println(name + ":" +pumped + ":$" + total + "\nRemaining in premium tank: " + premiumTank.getAmount() + " g.\n");
					
				}catch(TankException te) {
					System.out.println(te);
					break;
				}
				
				if(premiumTank.isEmpty()) {
					System.out.println("Premium Tank is empty!");
					break;
				}
			}

		}
	}
	
	/**
	 * 
	 * @param name
	 * @param amount
	 * @param cost
	 */
	public void midgrade(String name, double amount, double cost) {
		
		double pumped = 0.0;
		double total = 0.0;
		
		while (pumped < amount) {

			try {Thread.sleep(10);}catch(Exception e) {}

			premiumTank = PremiumTank.getTank();
			unleadedTank = UnleadedTank.getTank();
			synchronized(unleadedTank) {	
				try {
					
						unleadedTank.remove(tickAmount/2);
						premiumTank.remove(tickAmount/2);
						pumped += tickAmount;
						total += (cost * tickAmount);
						System.out.println(name + ":" +pumped + ":$" + total + 
								"\nRemaining in unleaded tank: " + unleadedTank.getAmount() + " g." +
								"\nRemaining in premium tank: " + premiumTank.getAmount() + " g.\n");
					
				}catch(TankException te) {
					System.out.println(te);
					break;
				}
				
				if(unleadedTank.isEmpty()) {
					System.out.println("Unleaded Tank is empty!");
					break;
				}
				if(premiumTank.isEmpty()) {
					System.out.println("Premium Tank is empty!");
					break;
				}
			}

		}
	}
	
	/**
	 * 
	 * @param name
	 * @param amount
	 * @param cost
	 */
	public void unleaded(String name, double amount, double cost) {

		double pumped = 0.0;
		double total = 0.0;
		
		while (pumped < amount) {

			try {Thread.sleep(10);}catch(Exception e) {}

			unleadedTank = UnleadedTank.getTank();
			synchronized(unleadedTank) {	
				try {
					
						unleadedTank.remove(tickAmount);
						pumped += tickAmount;
						total += (cost * tickAmount);
						System.out.println(name + ":" +pumped + ":$" + total + "\nRemaining in unleaded tank: " + unleadedTank.getAmount() + " g.\n");
					
				}catch(TankException te) {
					System.out.println(te);
					break;
				}
				
				if(unleadedTank.isEmpty()) {
					System.out.println("Tank is empty!");
					break;
				}
			}

		}
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isInUse() {
		return occupied;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getId() {
		return this.id;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//Declare pump as being used.
		occupied = true;
		
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
		
		occupied = false;
	}
}
