package maven.cucumber.testing.TestAssessment;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import maven.cucumber.testing.TestAssessment.Homepage;

public class TestSteps {

	WebDriver driver;

	ExtentReports report;
	ExtentTest test;

	@Before
	public void setupDriver() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Administrator\\Documents\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();

		
		test = TestRunner.report.startTest("Test Assessment");
	}

	@After
	public void closeDown() throws InterruptedException {
		Thread.sleep(3000);
		
		driver.close();
		TestRunner.report.endTest(test);
		driver.quit();
	}

	@Given("^I navigate to the React Application$")
	public void i_navigate_to_the_React_Application() {

		driver.get(Constant.websiteURL);
	}

	@When("^I click the Link to Automated Testing Exercise Form$")
	public void i_click_the_Link_to_Automated_Testing_Exercise_Form() {

		Homepage homepage = PageFactory.initElements(driver, Homepage.class);
		homepage.clickButton();

		test.log(LogStatus.INFO, "Automated testing exercise form page navigation");
	}

	@When("^I fill click the \"([^\"]*)\" dropdown menu$")
	public void i_fill_click_the_dropdown_menu(String arg1) {
		

		Form formpage = PageFactory.initElements(driver, Form.class);
		formpage.selectCountry(arg1);
		
	}

	@When("^I fill out the email field with \"([^\"]*)\"$")
	public void i_fill_out_the_email_field_with(String arg1) {

		Form formpage = PageFactory.initElements(driver, Form.class);
		formpage.fillEmail(arg1);
		
		test.log(LogStatus.INFO, "Correctly filled out email element");
	}

	@When("^I fill out the first password field with \"([^\"]*)\"$")
	public void i_fill_out_the_first_password_field_with(String arg1) {

		Form pass1 = PageFactory.initElements(driver, Form.class);
		pass1.fillPass1(arg1);
		
		test.log(LogStatus.INFO, "Correctly filled out first password field");
	}

	@When("^I fill out the second password field with \"([^\"]*)\"$")
	public void i_fill_out_the_second_password_field_with(String arg1) {

		Form pass2 = PageFactory.initElements(driver, Form.class);
		pass2.fillPass2(arg1);
		
		test.log(LogStatus.INFO, "Correctly filled out second password field");
		
		pass2.submitDetails();
	}

	@Then("^I should see a Success! Message$")
	public void i_should_see_a_Success_Message() {

		String message = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/h1")).getText();

		if (message.equals("Success!")) {
			test.log(LogStatus.PASS, "Passed");
		} else {
			test.log(LogStatus.FAIL, "Failed");
		}

		assertEquals("Success!", driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/h1")).getText());
	}

	@When("^I fill out the second password field with the wrong password \"([^\"]*)\"$")
	public void i_fill_out_the_second_password_field_with_the_wrong_password(String arg1) {

		Form pass2 = PageFactory.initElements(driver, Form.class);
		pass2.fillPass2(arg1);
		
		test.log(LogStatus.INFO, "Wrong password entered correctly");
		pass2.submitDetails();
	}

	@Then("^I should see a message stating that the passwords do not match\\.$")
	public void i_should_see_a_message_stating_that_the_passwords_do_not_match() {

		String message = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/p[10]")).getText();

		if (message.equals("The passwords do not match")) {
			test.log(LogStatus.PASS, "Passed");
		} else {
			test.log(LogStatus.FAIL, "Failed");
		}

		assertEquals("The passwords do not match",
				driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/p[10]")).getText());

	
	}
}
