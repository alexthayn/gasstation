package GasStation;
import Tank.*;
import Pump.*;

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
		Pump pump1 = new Pump();
		Pump pump2 = new Pump();
		Thread nozzle1 = new Thread(pump1,"Pump 1:diesel:20:2.30");
		Thread nozzle2 = new Thread(pump2,"Pump 2:diesel:30:2.30");
		
		try
		{
			diesel.refill(40);
			
			nozzle1.start();
			Thread.sleep(100);
			nozzle2.start();

		}catch(TankException te) {
			System.out.println(te);
		}catch(Exception e) {
			System.out.println(e);
		}
		/*Tank diesel = DieselTank.getDieselTank();
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
		
		System.out.println("Unleaded Tank Amount: " + unleaded.getAmount());	*/	
		
		
		
	}
}
