package tests;

import org.testng.annotations.Test;

import utils.ExtentTestManager;


public class UserTest extends UserBase {
	

	@Test(priority = 0, description="User inputs valid email account and clicks in sign up button.")
	public void tc1() {
		ExtentTestManager.getTest().setDescription("User inputs valid email account and clicks in sign up button.");
		clickOnRegistrarse();
		inputValidEmailAndRegister();
		checkSuccessfulRegister();
	}

	@Test(priority = 1, description="User inputs invalid email account and clicks in sign up button.")
	public void tc2() {
		ExtentTestManager.getTest().setDescription("User inputs invalid email account and clicks in sign up button.");
		clickOnRegistrarse();
		inputInvalidEmailAndRegister();
		checkUnsuccessfulRegister();
	}
	
	@Test(priority = 2, description="User goes to login page through Register page.")
	public void tc3() {
		ExtentTestManager.getTest().setDescription("User goes to login page through Register page.");
		clickOnRegistrarse();
		clickOnLogin();
		checkUserIsInLoginPage();
	}
	
	@Test(priority = 3, description="User goes to register with a partner account page through the Register page.")
	public void tc4() {
		ExtentTestManager.getTest().setDescription("User goes to register with a partner account page through the Register page.");
		clickOnRegistrarse();
		clickOnRegisterAsAPartner();
		checkUserIsInRegisterAsAPartnerPage();
	}
	
}
