package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SignInPage extends BasePage {
	
	public SignInPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.CLASS_NAME, using = "adb-container_header")
	private WebElement login;
	
	public String getSubmitText() {
		return login.getText();
	}

}
