/**
 * Class: B.Sc. in Computing
 * Instructor: Maria Boyle
 * Description: Tester for the Date class
 * Date: 18/09/2017
 * @author Maria Boyle
 * @version 1.0
**/
package ie.lyit.testers;

import java.util.Scanner;

import ie.lyit.hotel.Date;

public class DateTester{
	public static void main(String[] args) {
		Date d1 = new Date();
        System.out.println(d1);      

	    d1.setDay(4);
		d1.setMonth(6);
		d1.setYear(1941);
		
		System.out.println(d1);
      
		Date d2 = new Date(28, 12, 1982);
        System.out.println(d2);
      
		if(d1.equals(d2))
			System.out.println("Date's are equal.");
		else
			System.out.println("Date's are not equal.");
		
		Date myDate1 = new Date();
		boolean goodInput = false;
		int setDayTo = 32; int setMonthTo = 13; int setYearTo = -2010;
		Scanner keyboard = new Scanner(System.in);
		
		do {
			try {
				myDate1.setDay(setDayTo);
				myDate1.setMonth(setMonthTo);
				myDate1.setYear(setYearTo);
				goodInput = true;
			}catch (IllegalArgumentException ex) {
				System.out.println("Incorrect day, month or year");
				
				System.out.print("RE-ENTER VALID ARGUMENT FOR DAY: ");
				setDayTo = keyboard.nextInt();
				System.out.print("RE-ENTER VALID ARGUMENT FOR MONTH: ");
				setMonthTo = keyboard.nextInt();
				System.out.print("RE-ENTER VALID ARGUMENT FOR YEAR: ");
				setYearTo = keyboard.nextInt();
			}
		}while(!goodInput);
		
		keyboard.close();
   }
}

