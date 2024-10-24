package com.Magento.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	public WebDriver driver;
	
	@FindBy (id = "email")
	private WebElement emailTextBox;
	
	@FindBy (id = "pass")
	private WebElement passwordTextBox;
	
	@FindBy (linkText = "Sign In")
	private WebElement signingButton;
	
	public LoginPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmail (String emailText) {
		emailTextBox.sendKeys(emailText);
	}
	public void enterPassword (String passwordText) {
		passwordTextBox.sendKeys(passwordText);
	}
	public void clickOnSigninButton () {
		signingButton.click();
	}
	public AccountSuccessPage  navigToLoginPageByCombining3Actions(String emailText, String passwordText) {
		emailTextBox.sendKeys(emailText);
		passwordTextBox.sendKeys(passwordText);
		signingButton.click();
		return new AccountSuccessPage(driver);
	}
	
	
	

}
