package ie.lyit.hotel;

public interface Payable  {
	
	public abstract double calculateWage (double taxPercentage);
	public abstract double incrementSalary(double incrementAmount);

}
