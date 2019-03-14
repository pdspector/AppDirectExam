package tests;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utils.Config;

public class BaseTest extends Config {

	public static String environment = "AppTest";
	public WebDriver driver;
	public WebDriverWait wait;
	public static String browserName;
	public URL url;
	public String testName;
	
	
	@SuppressWarnings("deprecation")
	@Parameters("browser")
	@BeforeClass
	public void setUp(@Optional("chrome") String browser) throws MalformedURLException {

		if(browser.equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.gecko.driver", Config.getDriversPath("firefox"));
			DesiredCapabilities capabilities = DesiredCapabilities.firefox();
			capabilities.setCapability("marionette", true);
			capabilities.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
			capabilities.setCapability("name", testName);
			if(Config.isRemoteDriver()){
				System.out.println(Config.getGridHubAddress());
				driver = new RemoteWebDriver(new URL(Config.getGridHubAddress()), capabilities);
			}else{
				driver = new FirefoxDriver(capabilities);
			}

		}else if (browser.equalsIgnoreCase("ie")) {

			System.setProperty("webdriver.ie.driver", Config.getDriversPath("ie"));
			DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
			caps.setCapability(CapabilityType.BROWSER_NAME, BrowserType.IEXPLORE);
			caps.setCapability("ignoreZoomSetting", true);
			caps.setCapability("name", testName);

			if(Config.isRemoteDriver()){
				driver = new RemoteWebDriver(new URL(Config.getGridHubAddress()), caps);
			}else{
				driver = new InternetExplorerDriver(caps);
			}


		}else if (browser.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", Config.getDriversPath("chrome"));

			ChromeOptions cap = new ChromeOptions();
			cap.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
			cap.setCapability("name", testName);
			
				driver = new ChromeDriver(cap);
			
		}
		driver.get(Config.getAppUrl());
		driver.manage().window().maximize();
		
		}

	
	
	@AfterMethod
	public void returnToMainPage() {
		driver.get(Config.getAppUrl());
	}

	@AfterClass
	public void tearDown() throws IOException {
		driver.quit();
	}
	

	@AfterSuite
	public void openReport() throws IOException{
		File htmlFile = new File(Config.getReportsPath() + "ExtentReportResults.html");
		Desktop.getDesktop().browse(htmlFile.toURI());
	}
	
	
	 public WebDriver getDriver() {
	    	return driver;
	    }
	    
	    public String getBrowser() {
	    	return browserName;
	    }
	    
	    public String getBrowser(int run) {
	        String run2 = null;
	    	switch (run) {
	    	case 0:
	    		run2 = "Firefox";
	    		break;
	    	case 1:
	    		run2 = "Google Chrome";
	    		break;
	    	case 2:
	    		run2 = "Internet Explorer";
	    		break;
	    	}
	    	
	    	return run2;
	    }
}