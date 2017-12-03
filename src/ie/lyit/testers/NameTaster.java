package ie.lyit.testers;

import java.util.ArrayList;

import ie.lyit.hotel.Name;

public class NameTaster {

	public static void main(String[] args) {
		// Create a Name object called personA
		Name personA = new Name();
		
		// display personA's details on screen
		System.out.println(personA);
		
		// set personA's name
		personA.setTitle("Mr");
		personA.setFirstName("Homer");
		personA.setSurname("Simpson");
		
		// display personA's details on screen
		System.out.println(personA);
		
		Name personB = new Name("Mrs","Marge","Simpson");
		
		System.out.println(personB);
		
		if(personA.equals(personB)) {
			System.out.println(personA + " is the same as " + personB);
		}else {
			System.out.println(personA + " is not the same as " + personB);
		}
		
		if(personA.isFemale()) {
			System.out.println(personA + " is female");
		}else {
			System.out.println(personA + " is not female");
		}
		
		if(personB.isFemale()) {
			System.out.println(personB + " is female");
		}else {
			System.out.println(personB + " is not female");
		}
		
		ArrayList<Name> names = new ArrayList<Name>();
		names.add(new Name("Mr","Bart","Simpson"));
		names.add(personA);
		names.add(personB);
		names.trimToSize();
		
		for( Name tmpName:names) {
			System.out.println(tmpName);
		}
		
		if(nameSearch(personA,names)) {
			System.out.println(personA + " found in the list ");
		}else {
			System.out.println(personA + "not found in the name list");
		}

	}
	
	public static boolean nameSearch(Name nameSearch, ArrayList<Name> listOfNames) {	
		for(Name tmpName : listOfNames) {
			if(tmpName.equals(nameSearch)) {
				return true;
			}
		}
		return false;
	}

}
