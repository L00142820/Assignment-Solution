package ie.lyit.testers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ie.lyit.hotel.Date;
import ie.lyit.hotel.Employee;

public class EmployeeTest {

	private Employee e1;
	
	@Before
	public void setUp() throws Exception {
		e1= new Employee("Miss","Lisa","Simpson","Springfield","0860987653",
				20,12,1992,2500, new Date(1,1,2009));
		e1.setStartDate(new Date(1,1,2009));
		
	}

	@Test
	public void testGetDateProbationEnds() {
		
		assertEquals(e1.getDateProbationEnds(30), new Date(31,1,2009) );
	}

}
