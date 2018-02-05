package GasStation;

public class PremiumTank extends Tank {
	//Global Variables
	protected volatile static Tank myTank = null;
	
	private PremiumTank()
	{
		setCapacity(12000);
	}
	
	//@Override
	public static Tank getPremiumTank() {
		if(myTank == null)
		{
			synchronized (PremiumTank.class) {
				if(myTank == null)
				{
					myTank = new PremiumTank();
				}
			}
		}
		
		return myTank;
	}

}
