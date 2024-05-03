package api.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.AssertJUnit;
import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import api.endpoints.BaseClass;
import api.endpoints.params_endpoints;
import api.payload.PojoUser;
import api.payload.dataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.Parameters;


public class createTest {
	
	Faker faker; 
	PojoUser payload;
	ExtentSparkReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test1,test2;
	
	
	@BeforeClass
	public void setupdata()
	{
		htmlReporter = new ExtentSparkReporter("extentReport.html");
		//create ExtentReports and attach reporter(s)
		  extent = new ExtentReports();
		  extent.attachReporter(htmlReporter);
//		faker = new Faker();
		payload = new PojoUser();
		payload.setname("vivek");
		payload.setage("25");
		payload.setsalary("10000");
		
		
		//params_endpoints.userPayload(payload);
		
	}
	
	@Test (groups= {"demo"})
	public void test()
	{
		Response response = params_endpoints.createAPI(payload);
				response.then().log().all();
				
		AssertJUnit.assertEquals(response.getStatusCode(),200);
		test1 = extent.createTest("API Hit");
		test1.log(Status.INFO, "url" + " : " + BaseClass.base_url);
		test1.log(Status.INFO, "response" + " : " + response.prettyPrint());
		if (response.getStatusCode()==200)
		{
			test1.pass("200 status code");
		}
		else
		{
			Assert.fail("some other status code");
		}
		
		System.out.println("grouping the cases on test method");
	}
	
//	@AfterMethod
//	@AfterSuite
//	 public void tearDown() {
//	test1.pass("All pass");
//	test1.info("test completed");
//	  
//	  //write results into the file
//	  extent.flush();
//	}
//	
	@Test(dataProvider = "test-data",dataProviderClass = dataProvider.class)
	public void datapro(String a)
	{
		System.out.println(a);
		System.out.println(a);
	}
	
	@Test(groups= {"demo"})
	public void group() {
		System.out.println("grouping the cases on group method");
	}
	
	@Test (threadPoolSize = 4, invocationCount = 4, timeOut = 1000) 
	@Parameters ({"a","b"})
	public void test_parameter(String a, String b) {
		System.out.println("The thread ID is "+ Thread.currentThread().getId());
		if(a.contains("1"))
		{
		System.out.println(a);
		}
		if(b.contains("2"))
		{
		System.out.println(b);
		}
		System.out.println(a+b +"-"+"testing parameter");
	}
	
	
	
	@Test
	public void header()
	{
		String host= "https://reqres.in/";

		
		String body = "{\n"
				+ "    \"name\": \"morpheus\",\n"
				+ "    \"job\": \"leader\"\n"
				+ "}";
		Response response1= given().contentType(ContentType.JSON).body(body).when().post(host+"api/users").then()
				.extract().response();
		System.out.println(response1.asPrettyString());
		
		System.out.println(response1.getSessionId());
		
		//Get request header value
		System.out.println(response1.getHeader("Content-Type") + "-------");
		
		//Get request header value

		System.out.println(response1.headers());
		
		for(Header r: response1.headers())
		{
			System.out.println(r.getName() + "and - " + r.getValue());
		}
		
		AssertJUnit.assertEquals(response1.getStatusCode(),201);
		AssertJUnit.assertEquals(response1.jsonPath().getString("name"),"morpheus");
		System.out.println(response1.jsonPath().getString("name"));
	}
	
	
//	@Test 
//	@Parameters({"v","v2"})
//	public void param(String a, String b	) {
//	}
	
}
