package ie.lyit.serialize;

import ie.lyit.hotel.Customer;

public interface CustomerSerializerDAO {
	public void writeRecordToFile();
	public void readRecordsFromFile();
	public void add();
	public void list();
	public Customer view();
	public void delete();
	public void edit();

}
