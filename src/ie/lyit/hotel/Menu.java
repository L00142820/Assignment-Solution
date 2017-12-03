package ie.lyit.hotel;


import java.util.Scanner;

// Creats a Menu for the option Add, List, View, Edit, Delete and Quit
public class Menu   {
	
	private int option;
	
	//Basic Constructor which initialise the option variable with 0
	public Menu() {
		option = 0;
	}
	
	//Displays the Menu on the console (system.out)
	public void display() {
		System.out.println("\t1. Add");
		System.out.println("\t2. List");
		System.out.println("\t3. View");
		System.out.println("\t4. Edit");
		System.out.println("\t5. Delete");
		System.out.println("\t6. Quit");
				
	}
	//Read an INT from the keyboard (System.in) and set the class variable option
	public void readOption () {
		Scanner kbInt = new Scanner(System.in);
		System.out.println("\n\t Enter Option [1|2|3|4|5|6]");
		option = kbInt.nextInt();
		
		
		
	}

	//Returns the option value
	public int getOption() {
		return option;
	}

}
