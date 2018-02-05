package GasStation;
import Tank.*;

/**
 * 
 * @author jacksonportersnow
 *
 */
public class Driver{

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args){
		//Print welcome message
		System.out.println("Buidling a gas station...");
		
		Tank diesel = DieselTank.getDieselTank();
		Tank premium = PremiumTank.getPremiumTank();
		Tank unleaded = UnleadedTank.getUnleadedTank();
		
		try
		{
			diesel.refill(12000);
			

		}catch(TankException te)
		{
			System.out.println(te + "... shit...");
		}
		
		System.out.println("Diesel Tank Amount: " + diesel.getAmount());
		
		try
		{
			premium.refill(20000);
			

		}catch(TankException te)
		{
			System.out.println(te + "... shit...");
		}
		
		System.out.println("Premium Tank Amount: " + premium.getAmount());
		
		try
		{
			unleaded.refill(1000);

		}catch(TankException te)
		{
			System.out.println(te + "... shit...");
		}
		
		System.out.println("Unleaded Tank Amount: " + unleaded.getAmount());		
		
		
		
	}
}
