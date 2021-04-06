package com.CucumberCraft.stepDefinitions;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.CucumberCraft.Screenshot.ScreenshotTaker;
import com.CucumberCraft.pageObjects.APT_pageObjects;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UserStory_US869555 {
	static Logger log =LogManager.getLogger(UserStrory_US859468.class);
	WebDriver driver=ScreenshotTaker.getScreenshot();
	@When("^user checks that maximum (\\d+) promo box are present in search result$")
	public void user_checks_that_maximum_promo_box_are_present_in_search_result(int arg1) throws Throwable {
	  List<WebElement> boxNumber= driver.findElements(By.xpath(APT_pageObjects.getAllPromocodeBox(null)));
	  Assert.assertEquals(boxNumber.size(),arg1);
	  ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,500)");
	  ((JavascriptExecutor)driver).executeScript("window.scrollBy(500,1000)");
	  ((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	@Then("^user can see page number and pagination icon$")
	public void user_can_see_page_number_and_next_icon() throws Throwable {
		Assert.assertFalse(driver.findElements(By.xpath(APT_pageObjects.getEnabledPagination())).isEmpty());
		Assert.assertFalse(driver.findElements(By.xpath(APT_pageObjects.getEnabledPagination())).isEmpty());
		((JavascriptExecutor)driver).executeScript("window.scrollBy(0,500)");
		((JavascriptExecutor)driver).executeScript("window.scrollBy(500,1000)");
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	   
	}

	@When("^promo box is less than (\\d+) then user can't see page number and pagination icon$")
	public void promo_box_is_less_than_then_user_can_t_see_page_number_and_pagination_icon(int arg1) throws Throwable {
		 List<WebElement> boxNumber= driver.findElements(By.xpath(APT_pageObjects.getAllPromocodeBox(null)));
		  Assert.assertTrue(boxNumber.size()<arg1);
		  List<WebElement> enabled= driver.findElements(By.xpath(APT_pageObjects.getEnabledPagination()));
		  List<WebElement> disabled= driver.findElements(By.xpath(APT_pageObjects.getDiabledPagination()));
		  Assert.assertEquals(0,enabled.size() );
		  Assert.assertEquals(0,disabled.size() );
			((JavascriptExecutor)driver).executeScript("window.scrollBy(0,500)");
			((JavascriptExecutor)driver).executeScript("window.scrollBy(500,1000)");
			((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
}
