package tests;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.Assert;

import pages.MainPage;
import pages.RegisterAsAPartnerPage;
import pages.SignInPage;
import pages.SignUpPage;


public class UserBase extends BaseTest {

    public MainPage mainPage;
    public SignUpPage signUpPage;
    public SignInPage signInPage;
    public RegisterAsAPartnerPage registerAsAPartnerPage;

    public void clickOnRegistrarse() {
        mainPage = new MainPage(driver);
        mainPage.goTo("Registrarse");
    }

    public void inputValidEmailAndRegister() {
    	String generatedString = RandomStringUtils.randomAlphabetic(4);
        signUpPage = new SignUpPage(driver);
        signUpPage.register(generatedString+"@email.com");
    }

    public void checkSuccessfulRegister() {
    	
        signUpPage = new SignUpPage(driver);
        Assert.assertTrue(signUpPage.getFormText().contains("Thanks for your interest."));
    }

    public void inputInvalidEmailAndRegister() {
         signUpPage = new SignUpPage(driver);
         signUpPage.register("valid@email");
    }

     public void checkUnsuccessfulRegister() {
        signUpPage = new SignUpPage(driver);
        Assert.assertTrue(signUpPage.checkEmailError().contains("^[^@ ]+@[^@ ]+\\.[^@ ]+$"));
    }
     
     public void clickOnLogin() {
    	 signUpPage = new SignUpPage(driver);
    	 signUpPage.clickOnIniciarSesion();
     }
     
     public void checkUserIsInLoginPage() {
    	 signInPage = new SignInPage(driver);
    	 Assert.assertTrue(signInPage.getSubmitText().contains("LOG IN TO YOUR ACCOUNT"));
     }
     
     public void clickOnRegisterAsAPartner() {
    	 signUpPage = new SignUpPage(driver);
    	 signUpPage.clickOnRegisterAsAPartner();
     }
     
     public void checkUserIsInRegisterAsAPartnerPage() {
    	 registerAsAPartnerPage = new RegisterAsAPartnerPage(driver);
    	 Assert.assertTrue(registerAsAPartnerPage.getFormText().contains("CREATE YOUR DEVELOPER ACCOUNT"));
     }
}