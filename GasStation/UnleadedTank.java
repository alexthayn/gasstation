package GasStation;

public class UnleadedTank extends Tank {
	//Global Variables
	protected volatile static Tank myTank = null;
	
	private UnleadedTank()
	{
		setCapacity(12000);
	}
	
	//@Override
	public static Tank getUnleadedTank() {
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
