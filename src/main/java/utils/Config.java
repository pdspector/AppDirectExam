package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

	private static String filenameJenkins = "C:\\Users\\pspector\\Desktop\\Exam\\CAA_Automation_Java_Framework_Zalenium\\src\\resources\\properties\\config.apptest.properties";
	private static Properties config;
	static String testDataFilePath = "";

	static {
		
		config = new Properties();
			loadConfig( filenameJenkins );

	}

	private static void loadConfig ( String filename ){
		try {
			// load default configuration
			InputStream stream = new FileInputStream( filename );
			try {

				config.load(stream);
				System.out.println("Configuration loaded from  " + filename);
			}
			catch (Exception ex) {
				/* Handle exception. */
				ex.printStackTrace();
			}
			finally {
				stream.close();
			}
		}
		catch (IOException ex) {
			/* Handle exception. */
			System.out.println("Unable to find default configuration file " + new File("").getAbsolutePath() + "/" + filename);
		}
	}

	//@ Getters & Setters

	public static String getSourcePath() {
		return config.getProperty("sourcePath");
	}

	public static void setSourcePath(String sourcePath) {
		config.put("sourcePath", sourcePath);
	}
	
	public static String getUseLoginMethod() {
		return config.getProperty("useLoginMethod");
	}
	
	public static void setUseLoginMethod(String useLoginMethod) {
		config.put("useLoginMethod", useLoginMethod);
	}

	public static String getAppUserName() {
		return config.getProperty("appUserName");
	}

	public static void setAppUserName(String appUserName) {
		config.put("appUserName", appUserName);
	}


	public static String getAppPassword() {
		return config.getProperty("appPassword");
	}


	public static String getAppUrl() {
		return config.getProperty("appUrl");
	}

	public static String getJsonPath() {
		return config.getProperty("jsonPath");
	}

	public static void setJsonPath(String jsonPath) {
		config.put("jsonPath", jsonPath);
	}


	public static String getBrowserType() {
		return config.getProperty("browserType");
	}

	public static void setBrowserType(String browserType) {
		config.put("browserType", browserType);
	}


	public static String getDriversPath(String currentBrowser) {
		String driverPath = null;
		switch (currentBrowser){
		case "chrome":
		driverPath = config.getProperty("chromeDriverPath");
		break;
		case "firefox":
		driverPath = config.getProperty("firefoxDriverPath");
		break;
		case "ie":
		driverPath = config.getProperty("internetExplorerDriverPath");
		break;
		}

		return driverPath;
	}

	public static void setDriversPath(String driversPath) {
		config.put("driversPath", driversPath);
	}

	public static boolean isRemoteDriver() {
		return config.getProperty("remoteDriver").equalsIgnoreCase("1");
	}

	public static void setRemoteDriver(boolean remoteDriver) {
		config.put("remoteDriver", remoteDriver ? "1" : "0" );
	}

	public static String getGridHubAddress() {
		//TODO for now, the url to grid hub are in the envinronments vars
		return System.getenv("ZALENIUM_HOST") == null ? "localhost" : System.getenv("ZALENIUM_HOST");
		//return config.getProperty("gridHubAddress");
	}

	public static void setGridHubAddress(String gridHubAddress) {
		config.put("gridHubAddress", gridHubAddress);
	}

	public static String getReportsPath() {
		return config.getProperty("reportsPath");
	}

	public static void setReportsPath(String reportsPath) {
		config.put("reportsPath", reportsPath);
	}

	public static String getTestRailURL() {
		return config.getProperty("testRailURL");
	}

	public static void setTestRailURL(String tesRrailUrl) {
		config.put("testRailURL", tesRrailUrl);
	}
	
	public static String getTestRailUser() {
		return config.getProperty("testRailUser");
	}

	public static void setTestRailUser(String testRailUser) {
		config.put("testRailUser", testRailUser);
	}
	
	public static String getTestRailPassword() {
		return config.getProperty("testRailPassword");
	}

	public static void setTestRailPassword(String testRailPassword) {
		config.put("testRailPassword", testRailPassword);
	}
	
	public static String getTestRailProjectId() {
		return config.getProperty("testRailProjectId");
	}
	
	public static void setTestRailProjectId(String testRailProjectId) {
		config.put("testRailProjectId", testRailProjectId);
	}

	public static String getTestRailSuiteId() {
		return config.getProperty("testRailSuiteId");
	}
	
	public static void setTestRailSuiteId(String testRailSuiteId) {
		config.put("testRailSuiteId", testRailSuiteId);
	}

	public static String getEnvironmentBasedOnConfig() {
		String environment = "Sandbox";
		if(getAppUrl().contains("apptest")) environment = "AppTest";
		if(getAppUrl().contains("stage")) environment = "Stage";        
		return environment;
	}
}

