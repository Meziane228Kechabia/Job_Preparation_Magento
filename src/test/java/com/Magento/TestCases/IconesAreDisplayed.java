package com.Magento.TestCases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.Magento.Pages.HomePage;
import com.Magento.Pages.IconesPage;
import com.Magento.TestBase.TestBase;

public class IconesAreDisplayed extends TestBase{
	public IconesAreDisplayed () throws Exception{
		super();
	}

	public WebDriver driver;
	public IconesPage iconesPage;
	public HomePage homePage;
	
@BeforeMethod
	public void registerSetup() {
		driver = initalizeBrowserAndOpenApplication(prop.getProperty("browser"));		
		homePage = new HomePage(driver);
		iconesPage = new IconesPage(driver);
		
		
	}
@Test(priority = 1)
	public void verifyingLumaIconIsDisplayed() {	
	Assert.assertTrue(iconesPage.lumaMainPageIcon());
}
 @Test (priority = 2)
 public void verifyingWhatsNewIconIsDisplayed() {
	 Assert.assertTrue(iconesPage.whatsNewIcon());
 }
 
 @Test(priority=3)
 public void verifyingWomenIconIsDisplayed() {
	 Assert.assertTrue(iconesPage.womenIconeLink());
 }
 @Test(priority = 4)
 public void verifyingMenIconeIsDisplayed() {
	 Assert.assertTrue(iconesPage.menIconeLink());
 }
 @Test(priority =5)
 public void verifyingGearIconeIsDispalyed() {
	 Assert.assertTrue(iconesPage.gearIconeLink());
 }
 @Test(priority = 6)
 public void verifyingTrainingIconeIsDisplayed() {
	 Assert.assertTrue(iconesPage.trainingIconeLink());
 }
 @Test(priority =7)
 public void verifyingSaleIconeIsdisplayed() {
	 Assert.assertTrue(iconesPage.saleIconeLink());
 }
@AfterMethod
	public void tearDown() {
	driver.quit();
}


}
