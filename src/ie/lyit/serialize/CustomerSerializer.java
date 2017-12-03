package ie.lyit.serialize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import ie.lyit.hotel.Customer;
import ie.lyit.hotel.UserMaker;


public class CustomerSerializer implements Serializable,CustomerSerializerDAO {
	
	public static ArrayList <Customer> customerList;
	private final String FILENAME = "customer.bin";
	
	//Default Constructor
	public CustomerSerializer() {
		//Cunstruct arrayList of Customers
		customerList = new ArrayList<Customer>();
	}
	
	//Method for serilize customers to a file customer.bin
	public void writeRecordToFile () {
		ObjectOutputStream os = null;
		
		try {
			//creates an File and object Outputstream and serialize customerList
			FileOutputStream fileStream = new FileOutputStream(FILENAME);
			
			os = new ObjectOutputStream(fileStream);
			
			os.writeObject(customerList);
			
		}catch (FileNotFoundException ex) {
			System.out.println("Cannot create file to store customer");
		}catch ( Exception ex) {
			System.out.println(ex.getMessage());
		}finally {
			try {
				os.close();	
			}catch (IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
	
	//Method for deserialize customers from a file customer.bin
	public void readRecordsFromFile() {
		ObjectInputStream is = null;
		
		try {
			Path p = Paths.get(FILENAME);
			
			if(Files.exists(p) && Files.isReadable(p) ) {

				//creates an File and object InputStream and deserialize the file and read it into customerList
				FileInputStream fileStream = new FileInputStream(FILENAME);
				
				is = new ObjectInputStream(fileStream);
				
				customerList = (ArrayList<Customer>) is.readObject();
				is.close();
			}else {
				System.out.println("File: " +FILENAME+ " does not exist or is not readable! New File will be created!");
			}
			
			
		}catch (FileNotFoundException ex) {
			System.out.println("Cannot find file: " + FILENAME);
		}catch ( Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		//Only enter the code for searching the highest number if the list is not empty.
		if (!customerList.isEmpty()) {
			int maxNumber = 1;
			
			//Search for the highest customerNumber in the arrayList and save it in maxNumber
			for ( Customer tmp:customerList) {
				if (tmp.getNumber()> maxNumber) {
					maxNumber = tmp.getNumber();
				}
			}
			//Increment maxNumber to the next higher number for the new Customer 
			//and than set the static variable nextNumber for the Customer class
			maxNumber++;  
			Customer.setNextNumber(maxNumber);	
		}
	}
	
	// add a new Customer to customerList
	//Uses the read method from the Customer Class
	public void add () {
		//**********Using the Facade Pattern**************************
		UserMaker user = new UserMaker();
		
		//Customer cust = new Customer();
		if (user.readCustomer() ) {
			//customerList.add(cust);
			customerList.add(user.getCustomer());
			customerList.trimToSize(); 
		}else {
		//Set the nextNumber to the Number of the new created Customer cust -> because it was increased in the initialization of cust 
		//but the read function was quit and so no new customer would be added	
		//Customer.setNextNumber(cust.getNumber());
		Customer.setNextNumber(user.getCustomer().getNumber());
		}
		
	}
	
	//Lists all Customers from the customerList
	public void list() {
		for (Customer tmp:customerList) {
			System.out.println(tmp);
		}
	}
	
	//Shows one Customer
	//Read 1 int Value from the keyboard -> customer number
	//If the customer exist it returns the customer otherwise null
	public Customer view() {
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("Enter Customer number: ");
		
		int customerToView = keyboard.nextInt();
		
		
		for ( Customer tmp:customerList) {
			if(tmp.getNumber() == customerToView) {				
				return tmp;
			}
		}
		System.out.println("Customer does not exist!");
		return null;
	}
	
	//Delete one Customer from the customerList
	public void delete() {
		Customer tmp = view();  // view method is used to search for the customer because if customer exists the method returns the customer
		
		if (tmp != null) {
			customerList.remove(tmp);
			customerList.trimToSize(); 
		}
		
		
		
	}
	
	//Edit one customer
	public void edit () {
		Customer tmp = view(); // view method is used to search for the customer because if customer exists the method returns the customer
		
		if (tmp != null) {
			int index = customerList.indexOf(tmp);
			tmp.read();
			customerList.set(index, tmp);
		}
	}


}
