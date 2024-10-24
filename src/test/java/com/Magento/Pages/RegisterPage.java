package com.Magento.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class RegisterPage {
	public WebDriver driver;
	
	@FindBy (id = "firstname")
	private WebElement firstNameBox;
	
	@FindBy (id = "lastname")
	private WebElement lastNameBox;
	
	@FindBy (id = "email_address")
	private WebElement emailBox;
	
	@FindBy (id = "password")
	private WebElement passwordBox;
	
	@FindBy (id = "password-confirmation")
	private WebElement confirmPasswordBox;
	
	@FindBy (xpath = "//button[@type='submit' and @title='Create an Account']")
	public WebElement createAnAccount;
	
	
	
	//@FindBy (css = "#form-validate > div > div.primary > button")
	//public WebElement createAnAccount;
	
	
	
	@FindBy(id="firstname-error")	
	private WebElement firstNameRequiredField;
	
	public RegisterPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}
	
	public void enterFirstName (String firstNameText) {
		firstNameBox.sendKeys(firstNameText);
	}
	public void enterLastName (String lastNameText) {
		lastNameBox.sendKeys(lastNameText);
	}
	public void enterEmail (String emailText) {
		emailBox.sendKeys( emailText);
	}
	public void enterPassword (String passwordText) {
		passwordBox.sendKeys(passwordText);
	}
	public void enterConfirmPassword (String confirmpasswordText ) {
		confirmPasswordBox.sendKeys(confirmpasswordText);
	}
	public void clickOnCreateAnAccountBox() {
		createAnAccount.click();
		
	}	
	
	public AccountSuccessPage combiningMandatoryDetailsToNavigateToAccountSuccessPageRegister(
		String firstNameText, 
		String lastNameText, 
		String emailText,
		String passwordText, 
		String confirmpasswordText) {
		firstNameBox.sendKeys(firstNameText);
		lastNameBox.sendKeys(lastNameText);
		emailBox.sendKeys(emailText);
		passwordBox.sendKeys(passwordText);
		confirmPasswordBox.sendKeys(confirmpasswordText);
		createAnAccount.click();
		return new AccountSuccessPage(driver);
	}
	public boolean firstNameRequiredWarningMessage() {
		boolean displayStatus = firstNameRequiredField.isDisplayed();
		return displayStatus;
	}
	
	
	
	}
