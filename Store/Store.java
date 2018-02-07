package Store;

import java.util.LinkedList;
import java.util.Queue;

import Command.*;
import Pump.*;
import Tank.*;

/**
 * 
 * @author jacksonportersnow
 *
 */
public class Store {
	////Global Variables\\\\
	
	//Singleton Tank Classes 
	Tank dieselTank, premiumTank, unleadedTank;
		
	//PumpKiosk
	PumpKiosk pumpKiosk;
	
	//PumpKiosk Threads (number of pumps)
	PumpThread pump1, pump2;
	
	//Stack of requests
	Queue<CustomerOrder> queue;
	
	
	public Store()
	{
		//Debug Message
		System.out.println("Making Store!");
		
		//Get Instance of Singleton Variables
		dieselTank = DieselTank.getTank();
		premiumTank = PremiumTank.getTank();
		unleadedTank = UnleadedTank.getTank();
		
		try {
			dieselTank.refill(5000);
			premiumTank.refill(5000);
			unleadedTank.refill(5000);
		}catch(TankException te) {
			
		}
		
		//Instantiate Variables 		
		pumpKiosk = new PumpKiosk();
		pumpKiosk.setDieselCost(2.50);
		pumpKiosk.setUnleadedCost(2.45);
		pumpKiosk.setPremiumCost(3.00);
		pumpKiosk.setMidgradeCost(2.75);
		
		pump1 = new PumpThread(pumpKiosk, "Pump 1");
		pump2 = new PumpThread(pumpKiosk, "Pump 2");
		
		queue = new LinkedList<CustomerOrder>();
		
		//Debug Message
		System.out.println("Store created!");
	}
	
	public void makeOrder(String name, String type, double amount)
	{
		queue.add(new CustomerOrder(name, type, amount));
	}
	
	public CustomerOrder popOrder()
	{
		return queue.remove();
	}
	
	public void storeOpen()
	{
		//Initial order
		CustomerOrder current = queue.remove();
		
		try {
			pump1.newCustomer(current.getType(), current.getAmount());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println(e1);
		}
		pump1.start();		
		
		
		/*
		while(current != null)
		{
			if(pump1.isOpen())
			{
				current = queue.remove();
			}
		}
		*/
	}
	
}
