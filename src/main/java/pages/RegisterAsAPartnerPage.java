package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class RegisterAsAPartnerPage extends BasePage {
	
	public RegisterAsAPartnerPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CLASS_NAME, using = "adb-container_header")
	private WebElement form;
	
	public String getFormText() {
		return form.getText();
	}
}
