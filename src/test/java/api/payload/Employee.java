package api.payload;

public class Employee {
	
	String firstName;
	String lastName;
	double salary1;
	String designation;
	String contactNumber;
	String emailId;
	String employee;
	int age;
	
	public String employee(String employee)
	{
		
		this.employee= employee;
		return employee;
	}
	
	public String firstName() {
		return firstName;
	}
	
	public String firstName(String firstName)
	{
		this.firstName = firstName;
		return firstName;
	}
	
	public String lastName() {
		return lastName;
	}
	
	public String lastName(String lastName)
	{
		this.lastName = lastName;
		return lastName;
	}
	
	public double salary1() {
		return salary1;
	}
	
	public double salary1(double salary1)
	{
		this.salary1 = salary1;
		return salary1;
	}
	
	public String designation() {
		return designation;
	}
	
	public String designation(String designation)
	{
		this.designation = designation;
		return designation;
	}
	
	public String contactNumber() {
		return contactNumber;
	}
	
	public String contactNumber(String contactNumber)
	{
		this.contactNumber = contactNumber;
		return contactNumber;
	}
	
	public String emailId() {
		return emailId;
	}
	
	public String emailId(String emailId)
	{
		this.emailId = emailId;
		return emailId;
	}
	
	public int getage() {
		return age;
	}
	
	public int setage(int age)
	{
		this.age = age;
		return age;
	}


}
