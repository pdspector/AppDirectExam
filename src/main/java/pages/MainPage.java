package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;



public class MainPage extends BasePage {
	

	public MainPage (WebDriver driver) {
        super(driver);
    }
	
	@FindBy(how = How.LINK_TEXT, using = "Sign Up")
    private WebElement registrarse;
	
	
	
	
	public void goTo(String location) {
	
		if (location.equalsIgnoreCase("Registrarse")) {
		waitVisibility(By.className("ad-component--link")); 
		registrarse.click();
		}
	}
	

	
}