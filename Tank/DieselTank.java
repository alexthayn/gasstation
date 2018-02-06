package Tank;

public class DieselTank extends Tank {
	//Global Variables
	protected volatile static Tank myTank = null;
	
	private DieselTank()
	{
		setCapacity(12000);
	}
	
	//@Override
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
