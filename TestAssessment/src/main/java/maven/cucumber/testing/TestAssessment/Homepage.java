package maven.cucumber.testing.TestAssessment;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage {

	@FindBy(xpath = "//*[@id=\"root\"]/div/ul/li[10]/a")
	private WebElement atLinkButton;

	public void clickButton() {

		atLinkButton.click();

	}

}