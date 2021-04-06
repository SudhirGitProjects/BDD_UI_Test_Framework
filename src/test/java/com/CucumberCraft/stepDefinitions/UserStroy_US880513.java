package com.CucumberCraft.stepDefinitions;



import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.CucumberCraft.Screenshot.ScreenshotTaker;
import com.CucumberCraft.pageObjects.APT_pageObjects;

import cucumber.api.java.en.Given;


public class UserStroy_US880513 {
	static Logger log =LogManager.getLogger(UserStroy_US880513.class);
	WebDriver driver=ScreenshotTaker.getScreenshot();
	
	@Given("^user verify that field \"([^\"]*)\" field in promo heading$")
	public void user_verify_that_field_field_in_promo_heading(String arg1) throws Throwable {
	    Assert.assertTrue(driver.findElement(By.xpath(APT_pageObjects.getAllPromocodeNameinHeading(arg1))).isDisplayed());
	   
	}

	@Given("^user verify that field \"([^\"]*)\" field is present$")
	public void user_verify_that_field_field_is_present(String arg1) throws Throwable {
		String PageContent =driver.getPageSource();
		Assert.assertTrue(PageContent.contains(arg1), "Element is not present on the screen");
		
	}

}
