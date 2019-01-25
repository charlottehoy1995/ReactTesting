package maven.cucumber.testing.TestAssessment;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.relevantcodes.extentreports.ExtentReports;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;



@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\Administrator\\eclipse-workspace\\TestAssessment\\src\\test\\java\\formAccurate.feature")

public class TestRunner {
	public static ExtentReports report;
	
	@BeforeClass
	public static void setup() {
		report = new ExtentReports("C:\\Users\\Administrator\\Desktop\\TestAssessment.html", true);
		
	}
	
	@AfterClass
	public static void teardown() {
		report.flush();
		
	}
}


