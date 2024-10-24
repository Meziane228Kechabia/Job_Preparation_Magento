package com.Magento.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;
	public LoginPage loginPage;
	
	
	@FindBy(linkText = "Create an Account")
	private WebElement createAnAccountOption;
	
	@FindBy (linkText = "Sign In ")
	private WebElement signinOption;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public RegisterPage navigateToCreateAnAccount () {
		createAnAccountOption.click();
		return new RegisterPage(driver);
	}
	public LoginPage navigateToSigninOption () {
		signinOption.click();
		return new LoginPage(driver);
		}
	
}
