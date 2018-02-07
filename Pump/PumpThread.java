package Pump;

/**
 * PumpThread class that creates additional functionality needed for our threads while running a PumpKiosk
 * @author tymcb
 *
 */
public class PumpThread extends Thread{

	//Variables
	private String type;
	private long amount;
	private boolean open;
	
	/**
	 * Creates a new PumpThread
	 * @param obj PumpKiosk object reference
	 * @param name Name of Pump
	 */
	public PumpThread(PumpKiosk obj, String name) {
		super(obj, name);
		open = true;
	}
	
	/**
	 * Sets the type of order/pump that is supposed to be fulfilled
	 * @param gasType Type of gas to be pumped
	 * @param gasAmount Amount of gas to be pumped in gallons
	 * @throws Exception Thrown if amount of gas incorrect (negative number)
	 */
	public void newCustomer(String gasType,double gasAmount) throws Exception {
		if(gasAmount < 0)
			throw new Exception("Cannot recieve negative amount of gas.");
		
		type = gasType;
		amount = (long) Math.floor(gasAmount * 100);
	}
	
	/**
	 * Sets the type of gas to be pumped
	 * @param gasType type of gas to be pumped
	 */
	public void setGasType(String gasType) {
		type = gasType;
	}
	
	/**
	 * Returns the type of gas to be pumped
	 * @return type of gas to be pumped
	 */
	public String getGasType() {
		return type;
	}
	
	/**
	 * sets the amount of gas to be pumped in gallons
	 * @param gasAmount amount of gas to be pumped in gallons
	 * @throws Exception Thrown if amount of gas incorrect (negative number)
	 */
	public void setAmount(double gasAmount) throws Exception{
		if(gasAmount < 0)
			throw new Exception("Cannot recieve negative amount of gas.");
		
		amount = (long) Math.floor(gasAmount * 100);
	}
	
	/**
	 * Returns amount of gas to be pumped in gallons
	 * @return amount of gas to be pumped in gallons
	 */
	public long getAmount() {
		return amount;
	}
	
	/**
	 * Returns boolean is pumpthread (pumpkiosk) is being used
	 * @return boolean if pumped IS being used
	 */
	public boolean isOpen() {
		return open;
	}
	
	/**
	 * Sets the pumpthread (pumpkiosk) to IN USE.
	 */
	public void setBusy() {
		open = false;
	}
	
	/**
	 * Sets the pumpthread (pumpkiosk) to READY TO USE.
	 */
	public void setOpen() {
		open = true;
	}
	
	/**
	 * Returns PumpThread object during runtime (the current calling thread is returned)
	 * @return PumpThread object (thread that called is returned)
	 */
	public static PumpThread currentThread() {
		return ((PumpThread)Thread.currentThread());
	}
}
