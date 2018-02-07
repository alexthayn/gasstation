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
	
	private static Tank dieselTank, premiumTank, unleadedTank;
	
	
	public Pump() {	
		dieselTank = DieselTank.getTank();
		premiumTank = PremiumTank.getTank();
		unleadedTank = UnleadedTank.getTank();
	};
	
	/**
	 * 
	 * @param name
	 * @param amount
	 * @param cost
	 * @throws TankException 
	 */
	public void pumpDiesel(long amount) throws PumpException, TankException {
		boolean warn = false;
		String warnString = null;
		for(int i =0; i<amount; i+=10) {
			try {
				dieselTank.remove(tickAmount);
			}catch(TankException te) {
				if(te.toString().contains("empty"))
					throw new PumpException("DIESEL TANK: Tank is empty.",i);
				else  if(warn == false)
				{
					warnString = te.toString();
					warn = true;
				}
			}
		}
		if(warnString != null)
			throw new TankException(warnString);
	}
	
	/**
	 * 
	 * @param amount
	 * @throws TankException 
	 */	
	public void pumpPremium(long amount) throws PumpException, TankException  {
		boolean warn = false;
		String warnString = null;
		for(int i =0; i<amount; i+=10) {
			try {
				premiumTank.remove(tickAmount);
			}catch(TankException te) {
				if(te.toString().contains("empty"))
					throw new PumpException("PREMIUM TANK: Tank is empty.",i);
				else if(warn == false)
				{
					warnString = te.toString();
					warn = true;
				}
			}
		}
		if(warnString != null)
			throw new TankException(warnString);
		
	}

	/**
	 * 
	 * @param amount
	 * @throws TankException 
	 */
	public void pumpUnleaded(long amount) throws PumpException, TankException  {
		boolean warn = false;
		String warnString = null;
		for(int i =0; i < amount; i+=10) {
			try {
				unleadedTank.remove(tickAmount);
			}catch(TankException te) {
				if(te.toString().contains("empty")) 
					throw new PumpException("UNLEADED TANK: Tank is empty.",i);
				else if(warn == false)
				{
					warnString = te.toString();
					warn = true;
				}
			}
		}
		if(warnString != null)
			throw new TankException(warnString);
	}
	
	/**
	 * 
	 * @param amount
	 * @throws TankException 
	 */
	public void pumpMidGrade(long amount) throws PumpException, TankException {
		boolean warn = false;
		String warnString = null;
		for(int i =0; i<amount; i+=10)
		{
			try{
				unleadedTank.remove(tickAmount/2);
				premiumTank.remove(tickAmount/2);
			}catch(TankException te) {
				if(te.toString().contains("empty"))
					throw new PumpException("Tank is empty.",i);
				else if(warn == false) {
					warnString = te.toString();
					warn = true;
				}
			}
		}
		if(warnString != null)
			throw new TankException(warnString);
	}
}
