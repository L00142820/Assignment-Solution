package ie.lyit.hotel;

public class UserMaker {
	private User cust;
	private User emp;
	
	public UserMaker() {
		cust = new Customer();
		emp = new Employee();
	}
	
	public boolean readCustomer() {
		return cust.read();
	}
	
	public Customer getCustomer() {
		return (Customer) cust;
	}
	
	public boolean readEmployee() {
		return emp.read();
	}

}
