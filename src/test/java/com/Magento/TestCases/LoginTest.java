package com.Magento.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Magento.Pages.AccountPage;
//import com.Magento.Pages.AccountPage;
import com.Magento.Pages.AccountSuccessPage;
import com.Magento.Pages.HomePage;
import com.Magento.Pages.LoginPage;
import com.Magento.TestBase.TestBase;

public class LoginTest extends TestBase{
	public LoginTest() throws Exception {
		super();
		
	}	
	
	public HomePage homePage;
	public WebDriver driver;
	public AccountSuccessPage accountSuccessPage;
	public LoginPage loginPage;
	public AccountPage accountPage;
	
	@BeforeMethod
	public void loginSetup() {
		driver = initalizeBrowserAndOpenApplication(prop.getProperty("browser"));
		homePage = new HomePage(driver);
		loginPage = homePage.navigateToSigninOption();			
		}	
	@Test (priority=1)
	public void verifyingSigningWithExistingCredentials() {
		accountSuccessPage = loginPage.navigToLoginPageByCombining3Actions(
				prop.getProperty("validEmail"),
				prop.getProperty("validPassword"));
		Assert.assertTrue(accountSuccessPage.validateAccountLoginWelcomMessage());
	}
	
	@Test(priority = 2)
	public void verifyingSigningWithInvalidEmail() {
		accountSuccessPage = loginPage.navigToLoginPageByCombining3Actions(
		dataProp.getProperty("invalidEmail"),
		prop.getProperty("validPassword"));
		Assert.assertTrue(accountSuccessPage.validateIncapacityToLoginWithInvalidEmail());
	}
	@Test(priority = 3)
	public void verifyingSigninWithInvalidPassword() {
		        accountSuccessPage = loginPage.navigToLoginPageByCombining3Actions(
				prop.getProperty("validEmail"),
				dataProp.getProperty("invalidPassword"));				
				Assert.assertTrue(accountSuccessPage.validateIncapacityToLoginWithInvalidPassword());	
				
	}
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	

}

	
