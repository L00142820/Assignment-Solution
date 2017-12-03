package ie.lyit.hotel;

import java.io.Serializable;

public class Date   {
	private int day;
	private int month;
	private int year;
	
	public Date() {
		day = month = year = 0;
	}
	
	public Date(int d, int m, int y) throws IllegalArgumentException{
		
		if(d < 1 || d > 31 || m < 1 || m > 12 || y < 1) {
			throw new IllegalArgumentException ("DATE IS NOT VALID");
		}
		
		this.day = d;
		this.month = m;
		this.year = y;
	}
	
	
	public int getDay() {
		return day;
	}

	public void setDay(int day) throws IllegalArgumentException {
		
		if  (day < 1 || day > 31) {
			throw new IllegalArgumentException("DAY IS NOT IN RANGE 1 TO 31");
		}
		
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) throws IllegalArgumentException {
		
		if (month < 1 || month > 12) {
			throw new IllegalArgumentException("MONTH IS NOT IN RANGE 1 TO 12");
		}
		
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) throws IllegalArgumentException {
		
		if (year < 1 ) {
			throw new IllegalArgumentException("YEAR CANNOT BE NEGATIVE");
		}
		
		this.year = year;
	}

	public String toString() {
		return day + "/" + month + "/" + year;
	}
	
	/*public boolean equals(Object obj) {
		Date nObject; 
		if(obj instanceof Date) {
			nObject = (Date)obj;
		}else {
			return false;
		}
		return (this.day == nObject.day
				&& this.month == nObject.month
				&& this.year == nObject.year);
	}*/
	
	public boolean equals(Object o){
		// First check if o is a null reference to prevent run-time exceptions
		if(o == null) 
         return false;
	
		// Next check if o references the current object, if it does it must be equal
		if (this == o)
			return true;
         
		// Next check if o is in fact a Date object
		if(!(o instanceof Date))
			return false;
		else
		{
			// If none of the above are true, cast o to a Date object so that
            // we can compare the object's instance variables and methods
			Date other = (Date)o;
			
			return (this.day == other.day) &&
				   (this.month == other.month) &&
				   (this.year == other.year);
		}
	}

}
