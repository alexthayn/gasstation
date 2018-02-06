package Pump;

/**
 * 
 * @author tymcb
 *
 */
public class PumpThread extends Thread{

	//Variables
	private String type;
	private long amount;
	private boolean open;
	
	/**
	 * 
	 * @param obj
	 * @param name
	 */
	public PumpThread(PumpKiosk obj, String name) {
		super(obj, name);
		open = true;
	}
	
	/**
	 * 
	 * @param gasType
	 * @param gasAmount
	 * @throws Exception
	 */
	public void newCustomer(String gasType,double gasAmount) throws Exception {
		if(gasAmount < 0)
			throw new Exception("Cannot recieve negative amount of gas.");
		
		type = gasType;
		amount = (long) Math.floor(gasAmount * 100);
	}
	
	/**
	 * 
	 * @param gasType
	 */
	public void setGasType(String gasType) {
		type = gasType;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getGasType() {
		return type;
	}
	
	/**
	 * 
	 * @param gasAmount
	 * @throws Exception
	 */
	public void setAmount(double gasAmount) throws Exception{
		if(gasAmount < 0)
			throw new Exception("Cannot recieve negative amount of gas.");
		
		amount = (long) Math.floor(gasAmount * 100);
	}
	
	/**
	 * 
	 * @return
	 */
	public long getAmount() {
		return amount;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isOpen() {
		return open;
	}
	
	/**
	 * 
	 */
	public void setBusy() {
		open = false;
	}
	
	/**
	 * 
	 */
	public void setOpen() {
		open = true;
	}
	
	/**
	 * 
	 * @return
	 */
	public static PumpThread currentThread() {
		return ((PumpThread)Thread.currentThread());
	}
}
