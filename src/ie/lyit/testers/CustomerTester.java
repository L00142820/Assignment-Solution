package ie.lyit.testers;

import ie.lyit.hotel.Customer;
import ie.lyit.hotel.Name;

public class CustomerTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Customer customerA = new Customer();
		System.out.println(customerA);
		
		customerA.setName( new Name("Mr", "Homer","Simpson"));
		customerA.setAddress("12 Hi Road, Letterkenny");
		customerA.setPhoneNumber("000 1234 5678");
		customerA.setEmailAddress("e@mail.ie");
		
		System.out.println(customerA);
		
		Customer customerB = new Customer("Ms","Lisa","Simpson","Lowland","00000","email");
		
		System.out.println(customerB);
		
		if(customerB.equals(customerA)) {
			System.out.println("customerB is equal customerA");
		}else {
			System.out.println("customerB is not equal customerA");
		}
		
		

	}

}
