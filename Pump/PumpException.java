package Pump;

public class PumpException extends Exception{

private long amountPumped;
	
	public PumpException()
	{
		
	}
	
	public PumpException(String message, long amount)
	{
		super(message);
		amountPumped = amount;
	}
	
	public long getAmount() {
		return amountPumped;
	}
}
