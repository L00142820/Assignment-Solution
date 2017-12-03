package ie.lyit.hotel;

import java.io.Serializable;

public abstract class Person  implements Serializable {
	protected Name name;
	protected String address;
	protected String phoneNumber;
	
	// can't be called because Person is abstract
	public Person() {
		name = new Name();
		address = phoneNumber = null;
	}
	
	public Person (String t, String fN, String sn, String address, String phoneNumber) {
		name = new Name(t, fN, sn);
		this.address = address;
		this.phoneNumber = phoneNumber;
	}
	
	public String toString() {
		return name + ", " + address + ", " + phoneNumber;
	}
	
	public boolean equals (Object obj) {
		Person pObject;
		if(obj instanceof Person) {
			pObject = (Person) obj;
		}else 
			return false;
		
		return (name.equals(pObject.name) && 
				address.equals(pObject.address) && 
				phoneNumber.equals(pObject.phoneNumber));
		
	}

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) throws IllegalArgumentException{
		//check if the number is e correct number with regex
		//it allows a '+', '-' or any diget at the beginning and after it any diget, '/', '.', ' ', '-' and it must end with a diget
		// or you can just put in a '-' minus when you dont want to enter a number
		if(phoneNumber.matches("(^([+|-|\\d])[0-9/. \\-]*\\d$|-)")) {  
			this.phoneNumber = phoneNumber;
		}else {
			
			throw new IllegalArgumentException("PHONE NUMBER IS NOT VALID! IN CASE OF NO NUMBER ENTER - (MINUS)");
		}
		
	}
	
	

}
