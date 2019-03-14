package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
 
    //Constructor
    public BasePage(WebDriver driver) {
    	this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 100);
    }
 
    //Wait Wrapper Method
    public void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.elementToBeClickable(elementBy));
    }
    
    public void waitVisibility(WebElement elementBy) {
    	wait.until(ExpectedConditions.visibilityOf(elementBy));
    }
    
    //Dismiss popup
    public void dismissPopUp(By elementBy) {
    	driver.findElement(elementBy).click();
    }
    
    //Wait for Size
    public void waitUntilCountChanges(final By elementBy, final int par) {
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                int elementCount = driver.findElements(elementBy).size();
                if (elementCount == par)
                    return true;
                else
                    return false;
            }
        });
    }
    
    public WebElement clickOnCorrectCheckbox(List<WebElement> list1, List<WebElement> list2, String email) {
    	Integer indexes = null;
    	for (WebElement element : list2) {
    		if (element.getText().equalsIgnoreCase(email)) {
    			indexes = list2.indexOf(element);
    		}
    	}	
		WebElement checkbox = list1.get(indexes);
    	return checkbox;
    }
    
    public WebElement getElementFromListByText(List<WebElement> list1, String email) {
    	 Integer indexes = null;
    	for (WebElement element : list1) {
    		if (element.getText().equalsIgnoreCase(email)) {
    			indexes = list1.indexOf(element);
    		}
    	}	
		WebElement option = list1.get(indexes);
    	return option;
    }
}