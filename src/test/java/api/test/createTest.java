package api.test;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import api.endpoints.BaseClass;
import api.endpoints.params_endpoints;
import api.payload.PojoUser;
import api.payload.dataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


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
	
	@Test
	public void test()
	{
		Response response = params_endpoints.createAPI(payload);
				response.then().log().all();
				
		Assert.assertEquals(response.getStatusCode(),200);
		test1 = extent.createTest("API Hit");
		test1.log(Status.INFO, "url" + " : " + BaseClass.base_url);
		test1.log(Status.INFO, "response" + " : " + response.prettyPrint());
		if (response.getStatusCode()==200)
		{
			test1.pass("200 status code");
		}
		else
		{
			test1.fail("some other status code");
		}
		
	}
	
	@AfterSuite
	 public void tearDown() {
	test1.pass("All pass");
	test1.info("test completed");
	  
	  //write results into the file
	  extent.flush();
	}
	
	@Test(dataProvider = "test-data",dataProviderClass = dataProvider.class)
	public void datapro(String a)
	{
		System.out.println(a);
		System.out.println(a);
	}
}
