package ie.lyit.testers;

import ie.lyit.hotel.Customer;
import ie.lyit.hotel.Menu;
import ie.lyit.serialize.CustomerSerializer;
import ie.lyit.serialize.CustomerSerializerDAO;

public class CustomerSerializerTester {

	public static void main(String[] args) {
		
		// Creates an Object from customerSerializer
		//CustomerSerializer customerSerializer = new CustomerSerializer();
		
		//Creates an Object using the DAO Interface
		CustomerSerializerDAO customerDAO = new CustomerSerializer();
		
		//deserialize the file
		customerDAO.readRecordsFromFile();
		
		//create the menue
		Menu menuObj  = new Menu();
		
		//Loop until the user want to quit
		//Displays the menu, readOption, execute option 
		do {
			menuObj.display();
			menuObj.readOption();
			try {
				
			
			switch(menuObj.getOption()) {
			case 1: customerDAO.add(); break;
			case 2: customerDAO.list(); break;
			case 3: customerDAO.view(); break;
			case 4: customerDAO.edit(); break;
			case 5: customerDAO.delete(); break;
			case 6: break;
			default: System.out.println("invalid option"); 
			}
			}catch (IllegalArgumentException ex) {
				
				System.out.println(ex.getMessage());
			}
			
		}while(menuObj.getOption() != 6);
		
		// Before the Program close it will serialize the customerList to a file
		customerDAO.writeRecordToFile();
		

	

	}

}
