package pages;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class SignUpPage extends BasePage {
	

	public SignUpPage (WebDriver driver) {
        super(driver);
    }
	
	@FindBy(how = How.NAME, using = "emailAddress")
    private WebElement inputEmail;

    @FindBy(how = How.CSS, using = ".adb-button__primary.adb-toolbar--item")
    private WebElement signUp;

    @FindBy(how = How.CSS, using = ".adb-text__full_width.user-error")
    private WebElement inputEmailError;
    
    @FindBy(how = How.LINK_TEXT, using = "Log In")
    private WebElement login;
    
    @FindBy(how = How.LINK_TEXT, using = "Sign Up")
    private WebElement registerAsAPartner;
	
	
	public void register(String email) {
	
		inputEmail.sendKeys(email);
        signUp.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
	}
	
    public String getFormText() {
    	
        return driver.findElement(By.className("signupConfirmationPanel")).getText();
        		
    }

    public String checkEmailError() {
    	System.out.println(driver.findElement(By.cssSelector("input[class='adb-text__full_width user-error']")).getAttribute("pattern").toString());
        return driver.findElement(By.cssSelector("input[class='adb-text__full_width user-error']")).getAttribute("pattern").toString();
    }
    
    public void clickOnIniciarSesion() {
    	login.click();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    
    public void clickOnRegisterAsAPartner() {
    	registerAsAPartner.click();
    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

	
}