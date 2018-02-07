package Tank;

/**
 * PremiumTank class is a Singleton object that is a DieselTank that has a capacity and amount of gas.
 * @author jacksonportersnow, alexthayn, tybayn
 *
 */
public class PremiumTank extends Tank {
	//Global Variables
	protected volatile static Tank myTank = null;
	
	/**
	 * Creates a new PremiumTank object (singleton, must use getTank to get the instance)
	 */
	private PremiumTank()
	{
		setCapacity(12000);
	}
	
	/**
	 * Returns THE instance of the PremiumTank object (or creates it initially and returns it)
	 * @return PremiumTank instance
	 */
	public static Tank getTank() {
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
