package Store;

import java.util.ArrayList;

import Command.*;
import Pump.*;
import Tank.*;

/**
 * 
 * @author jacksonportersnow
 *
 */
public class Store {
	//Global Variables
	PumpDieselCommand dieselCommand;
	PumpMidGradeCommand midGradeCommand;
	PumpPremiumCommand premiumCommand;
	PumpUnleadedCommand unleadedCommand;
	ArrayList<Tank> tanks;
	
	/**
	 * 
	 * @param numTanks
	 */
	public Store(int numTanks)
	{
		dieselCommand = new PumpDieselCommand();
		midGradeCommand = new PumpMidGradeCommand();
		premiumCommand = new PumpPremiumCommand();
		unleadedCommand = new PumpUnleadedCommand();
		
		tanks.add(DieselTank.getDieselTank());
	}
	
	public pumpDiesel(double amount, )
	
	
}
