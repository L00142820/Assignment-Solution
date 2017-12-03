package ie.lyit.hotel;

import java.io.Serializable;

public class Name implements Serializable{
	


	private String title;
	private String firstName;
	private String surname;
	
	//Default Constructor 
	//Initialize the strings of the class with null
	public Name() {
		title = firstName = surname = null;
	}
	
	//Constructor to set the strings from the class
	public  Name(String t, String fN, String sN) {
		this.setTitle(t);;
		this.setFirstName(fN);
		this.setSurname(sN);
	}
	
	// get Methods
	// ==> 	called when retrieving part of an object
	//		e.g. if(n1.getSurname().equals(n2.getSurname()))
	
	// set Methods
	// ==> 	called when setting part of an object
	//		e.g.  n1.setTitle("Mrs"); n1.setFirstName("Marge"); na1.setSurname("Simpson");
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) throws IllegalArgumentException {
		String tmpTitle = title.toLowerCase(); // Convert the title to lower case and store it in tmptitle to compare it
		//CHeck if the title is correct otherwise throws an exception
		//It will compare to lowerCase, so Miss or miss will be accepted
		if ( tmpTitle.compareTo("mr") == 0  || tmpTitle.compareTo("mrs") == 0 || tmpTitle.compareTo("miss") == 0 ) {
			// Make sure that the tilte is in correct format, First Letter Uppercase and the rest lowercase
			//So if you type miss (what is correct title) it will be convertet to Miss
			this.title = title.substring(0, 1).toUpperCase() + title.substring(1).toLowerCase();
		}else {
			throw new IllegalArgumentException("TITLE IS NOT VALID! |Mr|Mrs|Miss|");
		}
		
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surName) {
		this.surname = surName;
	}
	
	//toString() Method
	//	==> called when a String of the class is used
	//		e.g. System.out.Print(n1); or System.out.print(n1.toString());
	//@Override
	public String toString() {
		//return "Name [title=" + title + ", firstName=" + firstName + ", surname=" + surname + "]";
		return title + " " + firstName + " " + surname;
	}
	
	//equals() Method
	// ==> 	Called when comparing an object with another object
	//		e.g. if(na.equals(n2))
	//@Override
	public boolean equals(Object obj) {
		Name nObject; 
		if(obj instanceof Name) {
			nObject = (Name)obj;
		}else {
			return false;
		}
		return this.title.equals(nObject.title) 
				&& this.firstName.equals(nObject.firstName) 
				&& this.surname.equals(nObject.surname);
	}
	
	public boolean isFemale() {
		if( title.equalsIgnoreCase("Miss") || title.equalsIgnoreCase("Ms") || title.equalsIgnoreCase("Mrs")) {
			return true;
		}else {
			return false;
		}
	}
	
}
