package Pump;

public class PumpDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		PumpKiosk pump = new PumpKiosk();
		
		PumpThread pump1 = new PumpThread(pump,"Pump 1");
		PumpThread pump2 = new PumpThread(pump,"Pump 2");
		
		try {
			pump1.newCustomer("diesel",20);
			pump2.newCustomer("unleaded",40);
		}catch(Exception e) {
			
		}
		
		pump1.start();
		pump2.start();
		
	}

}
