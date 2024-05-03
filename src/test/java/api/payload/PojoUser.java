package api.payload;

import java.util.List;

public class PojoUser {

	
	String name;
	String salary;
	String age;
	String value;
	int id;
	String department;
	List<String> list1;
	String companyName;
	String companyEmailId;
	String companyNumber;
	String companyAddress;
	List<String> supportedSalaryBanks;
	String firstName;
	String lastName;
	double salary1;
	String designation;
	String contactNumber;
	String emailId;
	String employee;
	List<Employee> Employee;
	String job;
	
	
	public String getname() {
		return name;
	}
	
	public String setname(String name)
	{
		this.name = name;
		return name;
	}
	
	public String getjob()
	{
		return job;
	}
	
	public String setjob(String job)
	{
	  this.job= job;
	  return job;
	}
	public String getsalary() {
		return salary;
	}
	
	public String setsalary(String salary)
	{
		this.salary = salary;
		return salary;
	}
	public String getage() {
		return age;
	}
	
	public String setage(String age)
	{
		this.age = age;
		return age;
	}
	public void listall(int id, String department, String value)
	{
		this.id = id;
		this.department = department;
		this.value= value;
	}
	
	public void listvalues(List<String> list1)
	{
		this.list1= list1;
	}
	
	public String companyName() {
		return companyName;
	}
	
	public String companyName(String companyName)
	{
		this.companyName = companyName;
		return companyName;
	}
	
	public String companyEmailId() {
		return companyEmailId;
	}
	
	public String companyEmailId(String companyEmailId)
	{
		this.companyEmailId = companyEmailId;
		return companyEmailId;
	}
	
	public String companyNumber() {
		return companyNumber;
	}
	
	public String companyNumber(String companyNumber)
	{
		this.companyNumber = companyNumber;
		return companyNumber;
	}
	
	
	public String companyAddress() {
		return companyAddress;
	}
	
	public String companyAddress(String companyAddress)
	{
		this.companyAddress = companyAddress;
		return companyAddress;
	}
	
	
	public List<String> supportedSalaryBanks(List<String> supportedSalaryBanks)
	{
		this.supportedSalaryBanks = supportedSalaryBanks;
		return supportedSalaryBanks;
	}
	
	  public List<Employee> Employee() {
	        return Employee;
	    }
	 
	    public void setEmployee(List<Employee> Employee) {
	        this.Employee = Employee;
	    }
	
	
}
