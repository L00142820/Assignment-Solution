package ie.lyit.testers;

import ie.lyit.hotel.Employee;

import java.util.ArrayList;

import ie.lyit.hotel.*;

	public class EmployeeTester {

	public static void main(String[] args) {
		
		Employee employeeA = new Employee();
		
		System.out.println(employeeA);
		
		employeeA.setName(new Name("Mrs","Marge","Simpson"));
		employeeA.setAddress("USA");
		employeeA.setPhoneNumber("00000");
		employeeA.setDateOfBirth(new Date(1,2,1990));
		employeeA.setStartDate(new Date(3,10,2017));
		employeeA.setSalary(60000);
		
		System.out.println(employeeA);
		
		
		Employee employeeB = new Employee("Mr","Homer","Simpson","Adress","+353 00000", 1, 2, 1990,1300.90, new Date(1,1,2017));
		
		System.out.println(employeeB);
		
		if(employeeA.equals(employeeB)) {
			System.out.println(" EmployeeA is equal EmployeeB");
		}else {
			System.out.println("EmployeeA is not equal EmployeeB");
		}
		
		employeeA.calculateWage(2);
		System.out.println("Wage: " + employeeA.calculateWage(2) );
		
		employeeA.incrementSalary(500);
		System.out.println("EmployeeA new Salary: " + employeeA.getSalary()) ;
		
		ArrayList<Employee> employees =new ArrayList<Employee>();
		employees.add(employeeA);
		employees.add(employeeB);
		employees.add( new Employee("Mr","Bart","Simpson","Adress","+353 00000", 1, 2, 1990,1300.90, new Date(1,1,2017)) );
		employees.add( new Employee("Mrs","Lisa","Simpson","Adress","+353 00000", 1, 2, 1990,1300.90, new Date(1,1,2017)) );
		
		employees.trimToSize();
		
		for (Employee tmpEmp:employees) {
			System.out.println(tmpEmp);
		}
		
		
		
		
		

	}

}