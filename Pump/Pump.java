package Pump;
import Tank.*;

/**
 * 
 * @author tymcb and goofyChicken
 *
 */
public class Pump{
	//Tick amount is the amount of gas we remove each time call the tanks
	//we remove 0.1 gallons each time, 0.1 = 100 long
	private final double tickAmount = 0.1;
	
	private static Tank dieselTank;
	private static Tank premiumTank;
	private static Tank unleadedTank;
	
	
	public Pump() {	
		
	};
	
	/**
	 * 
	 * @param name
	 * @param amount
	 * @param cost
	 * @throws TankException 
	 */
	public void pumpDiesel(long amount) throws PumpException{
		for(int i =0; i<amount; i++) {
			try {
				dieselTank.remove(tickAmount);
			}catch(TankException te) {
				if(te.equals("empty"))
					throw new PumpException("Tank is empty.",i);
			}
			i+=10;
		}	
	}
	
	/**
	 * 
	 * @param amount
	 * @throws TankException 
	 */	
	public void pumpPremium(long amount) throws PumpException {
		for(int i =0; i<amount; i++) {
			try {
				premiumTank.remove(tickAmount);
			}catch(TankException te) {
				if(te.equals("empty"))
					throw new PumpException("Tank is empty.",i);
			}
			i+=10;
		}
	}

	/**
	 * 
	 * @param amount
	 * @throws TankException 
	 */
	public void pumpUnleaded(long amount) throws PumpException {
		for(int i =0; i<amount; i++) {
			try {
				unleadedTank.remove(tickAmount);
			}catch(TankException te) {
				if(te.equals("empty"))
					throw new PumpException("Tank is empty.",i);
			}
			i+=10;
		}
	}
	
	/**
	 * 
	 * @param amount
	 * @throws TankException 
	 */
	public void pumpMidGrade(long amount) throws PumpException {
		pumpUnleaded(5);
		pumpPremium(5);
	}
}
