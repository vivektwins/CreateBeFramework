package api.payload;

public class User {

	
	String name;
	String salary;
	String age;
	
	public String getname() {
		return name;
	}
	
	public String setname(String name)
	{
		this.name = name;
		return name;
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
}
