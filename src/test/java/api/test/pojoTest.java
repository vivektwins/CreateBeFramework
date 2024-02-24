package api.test;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import api.payload.Employee;
import api.payload.PojoUser;

public class pojoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//https://qaautomation.expert/2021/11/08/how-to-create-nested-json-object-using-jackson-api/
		
		PojoUser u = new PojoUser();
		
		PojoUser u1 = new PojoUser();
		
		PojoUser u2 = new PojoUser();
		
		String payload = "{\n"
				+ "  \"companyName\": \"QAAutomation\",\n"
				+ "  \"companyEmailId\": \"qaautomation@org.com\",\n"
				+ "  \"companyNumber\": \"+353891234121\", \n"
				+ "  \"companyAddress\": \"12, HeneryStreet, Dublin, D12PW20\", \n"
				+ "  \"supportedSalaryBanks\": [\n"
				+ "    \"AIB\",\n"
				+ "    \"BOI\",\n"
				+ "    \"PSB\"\n"
				+ "  ],\n"
				+ "  \"employee\": [\n"
				+ "    { \n"
				+ "      \"firstName\" : \"Vibha\",\n"
				+ "      \"lastName\" : \"Singh\",\n"
				+ "      \"age\" : 30,\n"
				+ "      \"salary\" : 75000.0,\n"
				+ "      \"designation\" : \"Manager\",\n"
				+ "      \"contactNumber\" : \"+919999988822\",\n"
				+ "      \"emailId\" : \"abc@test.com\"\n"
				+ "    },\n"
				+ "    {\n"
				+ "      \"firstName\" : \"Neha\",\n"
				+ "      \"lastName\" : \"Verma\",\n"
				+ "      \"age\" : 25,\n"
				+ "      \"salary\" : 60000.0,\n"
				+ "      \"designation\" : \"Lead\",\n"
				+ "      \"contactNumber\" : \"+914442266221\",\n"
				+ "      \"emailId\" : \"xyz@test.com\"\n"
				+ "    }\n"
				+ "  ],\n"
				+ "  \n"
				+ "}";
		
		Employee pojo = new Employee();
		Employee pojo1 = new Employee();
		
		
		/* Declare all the strings and int in one pojo class
		 * if it's nested json array or json object - Create one separate class each 
		 * and make one pojo class as final, pass the class as list 
		 * Create a object for pojo class
		 * Create multiple objects if we have different json object
		 * Once passed all the string values, create a list with object refernce and put it in list
		 * If we need "Employee" name also on the op, Call the setEmployee method on the final pojoclass 
		 * and pass the final list which we prepared 
		 * Once another nested json objet is also done, Create one array list for the whole object
		 * And pass the setemployee object reference on the list  
		 */
		
		
		
		u.companyName("QAAutomation");
		u.companyEmailId("qaautomation@org.com");
		u.companyNumber("+353891234121");
		u.companyAddress("12, HeneryStreet, Dublin, D12PW20");
		
		List<String> supportedSalaryBanks = new ArrayList<String>();
		supportedSalaryBanks.add("AIB");
		supportedSalaryBanks.add("BOI");
		supportedSalaryBanks.add("PSB");
		u.supportedSalaryBanks(supportedSalaryBanks);
		
		
		
		pojo.firstName("Vibha");
		pojo.lastName("Singh");
		pojo.setage(30);
		pojo.salary1(760000.00);
		pojo.designation("Manager");
		pojo.contactNumber("+919999988822");
		pojo.emailId("abc@test.com");
		List<Employee> pojoNestedJSONArray1 = new ArrayList<Employee>();
		pojoNestedJSONArray1.add(pojo);
		u.setEmployee(pojoNestedJSONArray1);
		
		pojo1.firstName("Neha");
		pojo1.lastName("Verma");
		pojo1.setage(25);
		pojo1.salary1(60000.00);
		pojo1.designation("Lead");
		pojo1.contactNumber("+914442266221");
		pojo1.emailId("xyz@test.com");
		
		u.setEmployee(pojoNestedJSONArray1);
	
		
		ArrayList<PojoUser> p = new ArrayList<PojoUser>();
		p.add(u);
		
		
		Gson gson = new Gson();
		String payload1 = gson.toJson(p);
		
		
		//System.out.println(gson.toJson(u));
		System.out.println(payload1);
		System.out.println(payload);
		
		
		

	}

}
