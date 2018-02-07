package GasStation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import Pump.Pump;
import Pump.PumpKiosk;
import Pump.PumpThread;
import Tank.DieselTank;
import Tank.PremiumTank;
import Tank.Tank;

/**
 * UnitTest class to test that correct fuel is being pulled out
 * @author alexthayn
 */
class UnitTests {
	Tank premiumTank = PremiumTank.getTank();
	Tank dieselTank = DieselTank.getTank();
	
	
	/**
	 * Parameterized UnitTest for the PremiumTank to verify correct fuel is being pulled out.
	 * @param type Type of gasoline (diesel, unleaded, midgrade, premium)
	 * @param amount Amount in gallons of gasoline
	 * @param fuelRemaining Amount of fuel that should be remaining in tank in gallons
	 */
	@ParameterizedTest(name="{index}=>type= {0}, amount = {1}, fuelRemaining = {2}")
	@CsvSource({
		"Premium, 12, 188",
		"Premium, 25, 363",
		"Premium, 100, 463",
		"Premium, 150, 513",
		//Edge cases
		"Premium, 0, 713",
		"Premium, 800, 113"
	})
	void premiumTankTest(String type, double amount, double fuelRemaining) {
		try {
			
			premiumTank.refill(200);
			
			premiumTank.remove(amount);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		System.out.println("The amount remaining in the premium tank is: " + premiumTank.getAmount());
		assertEquals(fuelRemaining, premiumTank.getAmount(), .5);
	}

	/**
	 * Parameterized UnitTest for the DieselTank to verify correct fuel is being pulled out.
	 * @param type Type of gasoline (diesel, unleaded, midgrade, premium)
	 * @param amount Amount in gallons of gasoline
	 * @param fuelRemaining Amount of fuel that should be remaining in tank in gallons
	 */
	@ParameterizedTest(name="{index}=>type= {0}, amount = {1}, fuelRemaining = {2}")
	@CsvSource({
		"Diesel, 12, 188",
		"Diesel, 25, 363",
		"Diesel, 100, 463",
		"Diesel, 150, 513",
		//Edge cases
		"Diesel, 0, 713",
		"Diesel, 1000, 0.0"
	})
	void dieselTankTest(String type, double amount, double fuelRemaining) {
		try {
			dieselTank.refill(200);
			
			dieselTank.remove(amount);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		System.out.println("The amount remaining in the diesel tank is: " + dieselTank.getAmount());
		assertEquals(fuelRemaining, dieselTank.getAmount(), .001);
		
	}
}
