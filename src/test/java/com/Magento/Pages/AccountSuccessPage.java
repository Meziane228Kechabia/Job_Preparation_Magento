package com.Magento.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {
	public WebDriver driver;
	
	@FindBy (xpath = "//*[@id=\"maincontent\"]/div[1]/div[2]/div/div/div")
	private WebElement accountSuccessfullyCreatedMessage;
	
	@FindBy (linkText = "click here")
	private WebElement accountAlreadyExistWithThisEmail;
	
	@FindBy(xpath = "//html/body/div[2]/header/div[1]/div/ul/li[1]/span")
	private WebElement welcomeSigninMessage;
	
	@FindBy(xpath = "//*[@id=\"maincontent\"]/div[2]/div[2]/div/div/div")
	private WebElement incorectPasswordWarningMessageForSignin;
	
	@FindBy(css = "#maincontent > div.page.messages > div:nth-child(2) > div > div > div")
	private WebElement incorectEmailWarningMessageForSignin;		
	
	@FindBy (id = "firstname-error")
	private WebElement thisIsRequiredFieldFirstName;
	
	public AccountSuccessPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public boolean  validateAccountSuccessCreatedMessage () {
		boolean displayStatus = accountSuccessfullyCreatedMessage.isDisplayed();
		return displayStatus;		
	}
	public boolean validateExistingAccountWithThisEmail () {
		boolean displayStatus = accountAlreadyExistWithThisEmail.isDisplayed();
		return displayStatus;		
	}
	public boolean validateAccountLoginWelcomMessage () {
		boolean displayStatus = welcomeSigninMessage.isDisplayed();
		return displayStatus;
	}
	public boolean validateIncapacityToLoginWithInvalidPassword () {
		boolean dispalyStatus = incorectPasswordWarningMessageForSignin.isDisplayed();
		return dispalyStatus;
	}
	public boolean validateIncapacityToLoginWithInvalidEmail () {
		boolean displayStatus  = incorectEmailWarningMessageForSignin.isDisplayed();
		return displayStatus;
	}
	public boolean validatingRequiredFieldFirstName () {
		boolean dispalyStatus = thisIsRequiredFieldFirstName.isDisplayed();
		return dispalyStatus;
	}
	
//// For assertion purpose using getText(); instead of isDisplayed();
//	public boolean validateIncapacityToLoginWithWrongEmail () {
//		//Getting the text of the warning message
//		String warningMessageText = incorectPasswordWarningMessageForSignin.getText();
//		//Check if the warning message contains the expected value
//		boolean containsExpectedMessage = warningMessageText.contains("invalidPasswordloginWarningMessage");
//		return containsExpectedMessage;		
//	}
	
	
	
}
