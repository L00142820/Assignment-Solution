package ie.lyit.hotel;

import java.io.Serializable;

public class Employee extends Person implements Payable,User {
	
	private Date dateOfBirth;
	private Date startDate;
	private double salary;
	private int number;
	
	private static int nextNumber = 1; //static for unique number - starts off at 1
	
	private final double MAX_SALARY = 150000;
	
	public Employee () {
		
		super(); // NOTE: not needed because compiler will call it because of extends Person
		dateOfBirth = new Date();
		startDate = new Date();
		salary = 0.0;
		number = nextNumber++;
	}
	
	public Employee (String t, String fN, String sn, String address, String pNo, int bD, int bM, int bY, double salary, Date startDate) {
		
		super (t, fN, sn, address, pNo);
		dateOfBirth = new Date(bD, bM, bY);
		this.startDate = startDate;
		this.salary = salary;
		number = nextNumber++;
	}

	@Override
	public double calculateWage(double taxPercentage) {
		
		//return this.salary/12 - taxPercentage;
		double wage = salary/12;
		wage -= (wage * (taxPercentage/100));
		return wage;
	}

	@Override
	public double incrementSalary(double incrementAmount) {
		
		salary += incrementAmount;
		
		if ( salary > MAX_SALARY ) {
			salary = MAX_SALARY;
		}
		return salary;
		
	}
	
	@Override
	public String toString() {
		
		return number + " " + super.toString() + " " + salary;
	}
	
	@Override
	public boolean equals (Object obj) {
		
		Employee eObject;
		if(obj instanceof Employee) {
			eObject = (Employee) obj;
		}else 
			return false;
		
		return (this.number == eObject.number);	
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getNumber() {
		return number;
	}
	
	public Date getDateProbationEnds(int noDaysProbation) {
		Date dateProbationEnds = startDate;
		
		dateProbationEnds.setDay((dateProbationEnds.getDay() + noDaysProbation));
		
		return dateProbationEnds;
	}

	@Override
	public boolean read() {
		// TODO Auto-generated method stub
		System.out.println("Employee read()");
		return false;
	}
	
	

}
