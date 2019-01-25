package maven.cucumber.testing.TestAssessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Form {

	@FindBy(xpath = "//*[@id=\"root\"]/div/div/input[1]")
	private WebElement name;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/button")
	private WebElement countryButton;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/a[1]")
	private WebElement UKbutton;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/a[2]")
	private WebElement FranceButton;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div/div/div/a[3]")
	private WebElement GermanyButton;

	@FindBy(xpath = "//*[@id=\"nameInput\"]")
	private WebElement email;

	@FindBy(xpath = "//*[@id=\"passInput\"]")
	private WebElement password1;

	@FindBy(xpath = "//*[@id=\"passInput2\"]")
	private WebElement password2;

	@FindBy(xpath = "//*[@id=\"root\"]/div/div/button")
	private WebElement submitButton;

	
	
	public void fillEmail(String arg1) {
		email.sendKeys(arg1);
	}
	
	public void selectCountry( String country) {
		
		countryButton.click();
		
		if(country.equals("United Kingdom")) {
			UKbutton.click();
		}
		else if(country.equals("France")) {
			FranceButton.click();
		}
		else if(country.equals("Germany")) {
			GermanyButton.click();
		}
		
	}

	public void fillPass1(String arg1) {
		password1.sendKeys(arg1);
	}

	public void fillPass2(String arg1) {
		password2.sendKeys(arg1);
	}
	
	public void submitDetails() {
		submitButton.click();
	}

	
	



}
