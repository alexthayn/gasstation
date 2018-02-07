package Tank;

/**
 * DieselTank class is a Singleton object that is a DieselTank that has a capacity and amount of gas.
 * @author jacksonportersnow, alexthayn, tybayn
 *
 */
public class DieselTank extends Tank {
	//Global Variables
	protected volatile static Tank myTank = null;
	
	/**
	 * Creates a new DieselTank object (singleton, must use getTank to get the instance)
	 */
	private DieselTank()
	{
		setCapacity(12000);
	}
	
	/**
	 * Returns THE instance of the DieselTank object (or creates it initially and returns it)
	 * @return DieselTank instance
	 */
	public static Tank getTank() {
		if(myTank == null)
		{
			synchronized (DieselTank.class) {
				if(myTank == null)
				{
					myTank = new DieselTank();
				}
			}
		}
		
		return myTank;
	}

}
