package com.CucumberCraft.stepDefinitions;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.CucumberCraft.Screenshot.ScreenshotTaker;
import com.CucumberCraft.pageObjects.APT_pageObjects;

import cucumber.api.java.en.Given;

public class UserStrory_US859468 {
	static Logger log =LogManager.getLogger(UserStrory_US859468.class);
	WebDriver driver=ScreenshotTaker.getScreenshot();
	@Given("^user verify Dropdown named \"([^\"]*)\"$")
	public void user_verify_Dropdown_named(String arg1) throws Throwable {
		Assert.assertTrue(driver.findElement(By.xpath(APT_pageObjects.getSortByDropdown(arg1))).isDisplayed(),"Dropdown named  \""+arg1+"\" is present");
	}

	@Given("^user verifies that tab name \"([^\"]*)\" is present on the page$")
	public void user_verifies_that_tab_name_is_present_on_the_page(String arg1) throws Throwable {
		driver.findElement(By.xpath(APT_pageObjects.getTabName(arg1)));
	}


@Given("^user select the Dropdown with value \"([^\"]*)\"$")
public void user_select_the_Dropdown_with_value(String arg1) throws Throwable {
// Write code here that turns the phrase above into concrete actions
Select dropdown=new Select(driver.findElement(By.xpath(APT_pageObjects.getSortByDropdown(null))));
WebElement element=driver.findElement(By.xpath(APT_pageObjects.getSortByDropdown(null)));
dropdown.selectByVisibleText(arg1);
((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
((JavascriptExecutor)driver).executeScript("window.scrollBy(0,500)");
((JavascriptExecutor)driver).executeScript("window.scrollBy(500,1000)");
((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

}
}
