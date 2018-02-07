package GasStation;
import Tank.*;

import java.util.Scanner;

import Pump.*;
import Store.Store;

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
		Scanner input = new Scanner(System.in);
		
		//Print welcome message
		System.out.println("Welcome to TAJ's Gas Station!!\n");
		
		//Make Store
		Store theStore = new Store();
		
		//Print a blank line
		System.out.println();
		
		//Get Order
		System.out.print("Enter your name: ");
		String name = input.nextLine();
		
		System.out.print("\nEnter the type of fuel: (diesel, unleaded, midgrade, premium):");
		String type = input.nextLine();
		
		System.out.print("\nEnter the amount of fuel you wish to pump in gallons: ");
		String amount = input.nextLine();
		
		theStore.makeOrder(name, type, Double.parseDouble(amount));
		theStore.makeOrder("Eliza", "unleaded", 10);

		
		//Run orders!
		theStore.storeOpen();
		
		
		
		
		
		
		
		
		
		
		
		
		/*
		Tank diesel = DieselTank.getTank();
		Tank premium = PremiumTank.getTank();
		Tank unleaded = UnleadedTank.getTank();
		Pump pump1 = new Pump();
		Pump pump2 = new Pump();
		Thread nozzle1 = new Thread(pump1,"Pump 1:premium:15:3.80");
		Thread nozzle2 = new Thread(pump2,"Pump 2:midgrade:20:3.40");
		
		try
		{
			diesel.refill(50);
			premium.refill(50);
			unleaded.refill(50);
			
			nozzle1.start();
			nozzle2.start();

		}catch(TankException te) {
			System.out.println(te);
		}catch(Exception e) {
			System.out.println(e);
		}
		*/
		
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
