package GasStation;
import Tank.*;

import java.util.Scanner;

import Pump.*;
import Store.Store;

/**
 * Driver class that allows the running of our GasStation program.
 * @author jacksonportersnow
 *
 */
public class Driver{
	
	
	/**
	 * This is the main driver class that creates a store and orders for the store to fulfill.
	 * @param args Command line arguments (not used currently)
	 */
	public static void main(String[] args){
		//Create a scanner object to get user input
		//Scanner input = new Scanner(System.in);
		
		//Print welcome message
		System.out.println("Welcome to TAJ's Gas Station!!\n");
		
		//Make Store
		Store theStore = new Store();
		
		/* USER INPUT OPTION
		//Print a blank line
		System.out.println();
		
		//Get Order
		System.out.print("Enter your name: ");
		String name = input.nextLine();
		
		System.out.print("\nEnter the type of fuel: (diesel, unleaded, midgrade, premium):");
		String type = input.nextLine();
		
		System.out.print("\nEnter the amount of fuel you wish to pump in gallons: ");
		String amount = input.nextLine();
		
		theStore.makeOrder(name, type, Double.parseDouble(amount));*/
		
		//Make orders in code manually
		theStore.makeOrder("Eliza", "unleaded", 10);
		theStore.makeOrder("George", "unleaded", 20);
		theStore.makeOrder("Fredrick", "premium", 50);
		theStore.makeOrder("Sammy", "midgrade", 10);
		theStore.makeOrder("Anne", "unleaded", 25);
		theStore.makeOrder("Bill", "diesel", 4900);
		theStore.makeOrder("Frank", "diesel", 50);
		theStore.makeOrder("Lola", "unleaded", 10);
		theStore.makeOrder("Dude", "premium", 25);
		theStore.makeOrder("Jack", "unleaded", 10);

		//Run orders!
		theStore.storeOpen();
		
	}
}
