package api.utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Extent_report {
	
		static ExtentTest test;
		static ExtentReports extent;
		static 
		
		
		public void start() {
			ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");
			//create ExtentReports and attach reporter(s)
			  ExtentReports extent = new ExtentReports();
			  extent.attachReporter(htmlReporter);
			  
		}
}
