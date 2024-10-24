package com.Magento.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Job_Preparation_Magento.Util;
import com.Magento.Pages.AccountSuccessPage;
import com.Magento.Pages.HomePage;
import com.Magento.Pages.RegisterPage;
import com.Magento.TestBase.TestBase;
//import org.testng.annotations.Parameters;


public class RegisterTest  extends TestBase{
	
	public RegisterTest() throws Exception {
		super();
		
	}
	public WebDriver driver;
	public HomePage homePage;
	public RegisterPage registerPage;
	public AccountSuccessPage accountSuccessPage;
	
	@BeforeMethod
	public void registerSetup() {
		driver = initalizeBrowserAndOpenApplication(prop.getProperty("browser"));		
		homePage = new HomePage(driver);
		registerPage = homePage.navigateToCreateAnAccount();
		//accountSuccessPage = new AccountSuccessPage(driver);
	}
	@Test (priority=1)
	public void verifyingRegisterWithCorrectCredentials()  {
		accountSuccessPage = registerPage.combiningMandatoryDetailsToNavigateToAccountSuccessPageRegister
				(dataProp.getProperty("firstName"),
				dataProp.getProperty("lastName"), 
				Util.emailWithTimeDateStamp(), 
				prop.getProperty("validPassword"),
				dataProp.getProperty("confirmpassword") );		
		Assert.assertTrue(accountSuccessPage.validateAccountSuccessCreatedMessage());
	}
	@Test(priority=2)
	public void verifyingRegisterWithExistingEmail() {
		accountSuccessPage = registerPage.combiningMandatoryDetailsToNavigateToAccountSuccessPageRegister
				(dataProp.getProperty("firstName"),
				dataProp.getProperty("lastName"), 
				prop.getProperty("validEmail"), 
				prop.getProperty("validPassword"),
				dataProp.getProperty("confirmpassword") );		
		Assert.assertTrue(accountSuccessPage.validateExistingAccountWithThisEmail());	
	}
	@Test(priority = 3)
	
	public void verifyingRegisterWithoutAnyCredentials() {
	    // Wait for the "Create an Account" button to be clickable
	    ///WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    //wait.until(ExpectedConditions.elementToBeClickable(registerPage.createAnAccount));

	    // Click the "Create an Account" button
		//registerPage.clickOnCreateAnAccountBox();
		if (registerPage.createAnAccount.isDisplayed() && registerPage.createAnAccount.isEnabled()) {
		    registerPage.createAnAccount.click();
		} else {
		    // Log a message or throw an exception
		}
	    // Assert the expected condition
	    Assert.assertTrue(registerPage.firstNameRequiredWarningMessage());
	}
//	public void verifyingRegisterWithoutAnyCredentials() {
//		registerPage.clickOncreateAnAccountBox();
//		
//		//Assert.assertFalse(registerPage.firstNameRequiredWarningMessage());		
//		Assert.assertTrue(accountSuccessPage.validatingRequiredFieldFirstName());
//	}
	@Test(priority = 4)
	public void verifyingRegisterWithUnmatchConfirmPassword() {
		accountSuccessPage = registerPage.combiningMandatoryDetailsToNavigateToAccountSuccessPageRegister
				(dataProp.getProperty("firstName"),
				dataProp.getProperty("lastName"),
				dataProp.getProperty("validEmail"),
				dataProp.getProperty("validPassword"),
				dataProp.getProperty("unvalidConfirmPassword"));
		Assert.assertTrue(registerPage.firstNameRequiredWarningMessage());
		
	}
	
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
		
	
}


//String firstName, String lastName, String email, String password, String confirmPassword