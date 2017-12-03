package ie.lyit.testers;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import ie.lyit.hotel.Date;

public class DateTest {

	private Date d1;
	private Date d2;
	
	@Before
	public void setUp() throws Exception {
		d1 = new Date();
	}

	@Test
	public void testDate() {
		assertEquals(d1.getDay(),0);
		assertEquals("Month should be 0",d1.getMonth(),0);
		assertEquals("Year should be 0",d1.getYear(),0);
		
	}

	@Test(expected = IllegalArgumentException.class)
	public void testDateIntIntInt() {
		d2 = new Date(32,13,2017);
	}

	@Test
	public void testSetDay() {
		d1.setDay(21);
		assertEquals(d1.getDay(),21);
	}

	@Test
	public void testSetMonth() {
		d1.setMonth(12);
		assertEquals(d1.getMonth(),12);
	}

	@Test
	public void testSetYear() {
		d1.setYear(1990);
		assertEquals(d1.getYear(),1990);
	}

}
