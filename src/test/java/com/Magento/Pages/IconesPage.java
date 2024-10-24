package com.Magento.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IconesPage {
	public WebDriver driver;
	
	@FindBy (xpath="//a[@class='logo']")
	private WebElement lumaMainPageIcon;
	
	@FindBy (linkText = "What's New")
	private WebElement whatsNewLink;
	
	@FindBy (xpath = "//*[@id=\"ui-id-4\"]/span[1]")
	private WebElement womenLink;
	 @FindBy(css="#ui-id-5 > span.ui-menu-icon.ui-icon.ui-icon-carat-1-e")
	 private WebElement menLink;
	 @FindBy (xpath = "//*[@id=\"ui-id-6\"]")
	 private WebElement gearLink;
	 @FindBy(css="#ui-id-7 > span.ui-menu-icon.ui-icon.ui-icon-carat-1-e")
	 private WebElement trainingLink;
	 @FindBy(xpath="//*[@id=\"ui-id-8\"]")
	 private WebElement saleLink;
	
	public IconesPage (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public boolean lumaMainPageIcon() {
		boolean displayStatus = lumaMainPageIcon.isDisplayed();
		return displayStatus; 
		
	}
	public boolean whatsNewIcon() {
		boolean displayStatus = whatsNewLink.isDisplayed();
		return displayStatus;
	}
	 public boolean womenIconeLink() {
		 boolean displayStatus = womenLink.isDisplayed();
		 return displayStatus;
	 }
	 public boolean menIconeLink() {
		 boolean displayStatus = menLink.isDisplayed();
		 return displayStatus;
	 }
	 public boolean gearIconeLink() {
		 boolean displayStatus = gearLink.isDisplayed();
		 return displayStatus;
	 }
	 public boolean trainingIconeLink() {
		 boolean displayStatus = trainingLink.isDisplayed();
		 return displayStatus;
	 }
	public boolean saleIconeLink() {
		boolean displayStatus = saleLink.isDisplayed();
		return displayStatus;
	}

}
