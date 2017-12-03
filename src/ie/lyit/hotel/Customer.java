package ie.lyit.hotel;

import java.io.Serializable;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

//The Customer class and all other classes which inherit to or from custumer (Person, Name) implement the Serializable Interface -> to allow serialization 
public class Customer extends Person implements Serializable,User {
	//Customer has name, address, phoneNumber from Person AND
	private String emailAddress;
	private int number;
	
	private static int nextNumber = 1; //static for unique number - starts off at 1
	
	public Customer() {
		super();  // NOTE: Don' t need to call super() explicitly
		emailAddress = null;
		number = nextNumber++; // set number to static nextNumber before incrementing nextNumber
	}
	
	public Customer (String t, String fN, String sn, String address, String pNo, String email) {
		
		super (t, fN, sn, address, pNo);
		
		this.setEmailAddress(email);
		number = nextNumber ++;
	}
	
	public String toString() {
		// calls the toString method from the super class (Person) and add the number and the email address and returns it
		return number + ": " + super.toString() + ", " + emailAddress;
	}
	
	// compares two customers -> two customers are equal if they have the same customer number
	public boolean equals (Object obj) {
		Customer cObject;
		if(obj instanceof Customer) {
			cObject = (Customer) obj;
		}else 
			return false;
		
		return (this.number == cObject.number);
		
	}
	
	// GET and SET Methods
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) throws IllegalArgumentException {
		
		//Simple checks if the Email is valid - checks not all possibilities. If better checks required we can use regex for example
		
		//check if there is an @ in the email
		if ( emailAddress.indexOf("@") == -1) {
			 
			throw new IllegalArgumentException ("EMAIL IS NOT VALID! [EMAIL REQUIRE @]");
		}
		
		//check if there are characters before the @
		if ( emailAddress.indexOf("@") == 0) {
			throw new IllegalArgumentException ("EMAIL IS NOT VALID! [EMAIL REQUIRE CHAR[s] BEFORE @]");
		}
		
		//checks if there is . after the @
		if ( emailAddress.indexOf(".", emailAddress.indexOf("@")) == -1) {
			throw new IllegalArgumentException ("EMAIL IS NOT VALID! [EMAIL REQUIRE . BEVORE TLD]");
		}
		
		//checks if there are characters between the @ and the .
		if ( (emailAddress.indexOf(".") - emailAddress.indexOf("@")) < 2) {
			throw new IllegalArgumentException ("EMAIL IS NOT VALID! [EMAIL REQUIRE CHAR[s] BETWEEN @ AND .]");
		}
		
		
		
		this.emailAddress = emailAddress;
	}

	//No need for setNumber - it should not be possible to set own number!
	public int getNumber() {
		return number;
	}
	
	//Required for setting the static variable nextNumber after deserialization (reading from file
	public static void setNextNumber( int nextNumber) {
		Customer.nextNumber = nextNumber;
	}
	
	//Read the information of one Customer - It creates a JOptionPane and after OK_OPTION it calls the set Methods of the Customer class
	//When the Customer was created it will return true
	//When no Customer was created it will return false (exception, quit dialog)
	public boolean read(){
      JTextField txtCustomerNo = new JTextField();
      txtCustomerNo.setText("" + this.getNumber());
      txtCustomerNo.setEnabled(false); // The text field for the number is disabled - because you should not modify it
      
      JTextField txtTitle = new JTextField();
      txtTitle.requestFocusInWindow();
      //Check if there is already a Name in the Customer Object, than it will be set as default value for the textBox
      //This will be for edit --> because there we already have values in the object
      if(this.getName().getTitle() != null) {
    	  txtTitle.setText(this.getName().getTitle());
      }
      
      JTextField txtFirstName = new JTextField();
      if(this.getName().getFirstName() != null) {
    	  txtFirstName.setText(this.getName().getFirstName());
      }
      
      JTextField txtSurname = new JTextField();
      if(this.getName().getSurname() != null) {
    	  txtSurname.setText(this.getName().getSurname());
      }
      
      JTextField txtAddress = new JTextField();
      if(this.getAddress() != null) {
    	  txtAddress.setText(this.getAddress());
      }
      JTextField txtPhoneNumber = new JTextField();
      if(this.getPhoneNumber() != null) {
    	  txtPhoneNumber.setText(this.getPhoneNumber());
      }
      JTextField txtEmail = new JTextField();
      if(this.getEmailAddress() != null) {
    	  txtEmail.setText(this.getEmailAddress());
      }

      Object[] message = {
          "Customer Number:", txtCustomerNo,
          "Title:", txtTitle,
          "FirstName:", txtFirstName,
          "Surname:", txtSurname,
          "Address:", txtAddress,
          "PhoneNumber:", txtPhoneNumber,
          "Email:", txtEmail
      };

      int option = JOptionPane.showConfirmDialog(null, message, "Enter Customer details", JOptionPane.OK_CANCEL_OPTION);

      if (option == JOptionPane.OK_OPTION){
    	  // I catch the Exception maybe thrown by the set method checks - in case i will return false 
    	  try {
        	 this.setName( new Name(txtTitle.getText(), txtFirstName.getText(), txtSurname.getText() ) );
	         this.setAddress(txtAddress.getText());
	         this.setPhoneNumber(txtPhoneNumber.getText());
	         this.setEmailAddress(txtEmail.getText());
         }catch (IllegalArgumentException ex) {
        	 System.out.println(ex.getMessage());
        	 //Exception from the Checks was thrown - so no Customer will be created -> return false
        	 return false;
         }
          return true;
      }else {
    	  //Dialog was quit - so no Customer will be created -> return false
    	  return false;
      }
	}
	
	

}
