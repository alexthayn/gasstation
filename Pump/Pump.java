package Pump;
import Tank.*;

/**
 * 
 * @author tymcb
 *
 */
public class Pump implements Runnable{
	
	
	
	private final long tickAmount = 100;
	
	private static Tank dieselTank;
	private static Tank premiumTank;
	private static Tank unleadedTank;
	
	private boolean occupied;
	private int id;
	
	
	public Pump() {	
		
	};
	
	/**
	 * 
	 * @param name
	 * @param amount
	 * @param cost
	 */
	public void pumpDiesel(long amount){
		
	}
	
	/**
	 * 
	 * @param amount
	 */
	
	public void pumpPremium(long amount) {
		
	}

	/**
	 * 
	 * @param amount
	 */
	public void pumpUnleaded(long amount) {
		
	}
	
	/**
	 * 
	 * @param amount
	 */
	public void pumpMidGrade(long amount) {
		pumpUnleaded(50);
		pumpPremium(50);
	}

}
