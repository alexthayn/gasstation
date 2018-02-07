package Tank;

/**
 * UnleadedTank class is a Singleton object that is a DieselTank that has a capacity and amount of gas.
 * @author jacksonportersnow, alexthayn, tybayn
 *
 */
public class UnleadedTank extends Tank {
	//Global Variables
	protected volatile static Tank myTank = null;
	
	/**
	 * Creates a new UnleadedTank object (singleton, must use getTank to get the instance)
	 */
	private UnleadedTank()
	{
		setCapacity(12000);
	}
	
	/**
	 * Returns THE instance of the UnleadedTank object (or creates it initially and returns it)
	 * @return UnleadedTank instance
	 */
	public static Tank getTank() {
		if(myTank == null)
		{
			synchronized (UnleadedTank.class) {
				if(myTank == null)
				{
					myTank = new UnleadedTank();
				}
			}
		}
		
		return myTank;
	}

}
