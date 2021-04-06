package com.CucumberCraft.stepDefinitions;

import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import com.CucumberCraft.ExcelReadWrite.DataSourceDecider;
import com.CucumberCraft.JSONparser.JsonParser;
import com.CucumberCraft.Screenshot.ScreenshotTaker;
import com.CucumberCraft.pageObjects.APT_pageObjects;


import cucumber.api.java.en.Given;

public class UserStory_US859355 {
	ArrayList <String> jsonData=new ArrayList <String>();
	static Logger log =LogManager.getLogger(UserStory_US859342.class);
	WebDriver driver=ScreenshotTaker.getScreenshot();
	
	@Given("^user clicks on the Expand button against at \"([^\"]*)\" to see details$")
	public void user_clicks_on_the_Expand_button_against_at_to_see_details(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String obtainedData=DataSourceDecider.dataFinder(arg1);
       driver.findElement(By.xpath(APT_pageObjects.getExpand(obtainedData))).click();
	}

	@Given("^user launch the Json url \"([^\"]*)\"$")
	public void user_launch_the_Json_url(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String obtainedData=DataSourceDecider.dataFinder(arg1);
		jsonData=JsonParser.parser(obtainedData);
		System.out.println(jsonData);
		
	}

	@Given("^user verifies the UI with respect to Json$")
	public void user_verifies_the_UI_with_respect_to_Json() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    for (int i=0; i<jsonData.size();i++) {
			driver.getPageSource().contains(jsonData.get(i));
			}
	    
	    ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,500)");
	    ((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)");
		((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	@Given("^user verify that the PromoBox is present on the page$")
	public void user_verify_that_the_PromoBox_is_present_on_the_page() throws Throwable {
		List<WebElement> listPromobox=new ArrayList<WebElement>();
		listPromobox=driver.findElements(By.xpath(APT_pageObjects.getAllPromocodeBox(null)));
		for (int i=0;i<listPromobox.size();i++) {
			Assert.assertTrue(listPromobox.get(i).isDisplayed(),"promobox number \""+ i +"\"  is displayed" );
		}
	    
	}

	@Given("^user verify that all the PromoBox have \"([^\"]*)\" field in it$")
	public void user_verify_that_all_the_PromoBox_have_field_in_it(String arg1) throws Throwable {
		 List<WebElement> listPromobox=new ArrayList<WebElement>();
		switch(arg1) {
	  
	   case "Promotion dates:": 
		  
			listPromobox=driver.findElements(By.xpath(APT_pageObjects.getAllPromocodeBox(arg1)));
			for (int i=0;i<listPromobox.size();i++) {
				Assert.assertTrue(listPromobox.get(i).isDisplayed(),"promobox  \""+ i +"\"  have \""+arg1+"\" field in it" );
			}
           break; 
       case "PST codes:": 
    	   
			listPromobox=driver.findElements(By.xpath(APT_pageObjects.getAllPromocodeBox(arg1)));
			for (int i=0;i<listPromobox.size();i++) {
				Assert.assertTrue(listPromobox.get(i).isDisplayed(),"promobox  \""+ i +"\"  have \""+arg1+"\" field in it" );
			}
           break; 
       case "TA codes:": 
    	   listPromobox=driver.findElements(By.xpath(APT_pageObjects.getAllPromocodeBox(arg1)));
			for (int i=0;i<listPromobox.size();i++) {
				Assert.assertTrue(listPromobox.get(i).isDisplayed(),"promobox  \""+ i +"\"  have \""+arg1+"\" field in it" );
			}
			 break;
       case "Partner codes:": 
    	   listPromobox=driver.findElements(By.xpath(APT_pageObjects.getAllPromocodeBox(arg1)));
			for (int i=0;i<listPromobox.size();i++) {
				Assert.assertTrue(listPromobox.get(i).isDisplayed(),"promobox  \""+ i +"\"  have \""+arg1+"\" field in it" );
			}
			 break;
       case "Keywords:": 
    	   listPromobox=driver.findElements(By.xpath(APT_pageObjects.getAllPromocodeBox(arg1)));
			for (int i=0;i<listPromobox.size();i++) {
				Assert.assertTrue(listPromobox.get(i).isDisplayed(),"promobox  \""+ i +"\"  have \""+arg1+"\" field in it" );
			}
			 break; 
       default: 
           System.out.println("Are you sure this field \""+arg1+"\" is inside the Prormo box:"); 
	   
	   
	   }
	   
	}

	

	

@Given("^user verifies expand button is disabled against promo code \"([^\"]*)\"$")
public void user_verifies_expand_button_is_disabled_against_promo_code(String arg1) throws Throwable {
	String obtainedData=DataSourceDecider.dataFinder(arg1);
	//WebElement element=driver.findElement(By.xpath(APT_pageObjects.getExpand(obtainedData)));
	//Assert.assertTrue(!driver.findElement(By.xpath(APT_pageObjects.getExpand(obtainedData))).;,"Expand button is disabled");
	WebElement element = driver.findElement(By.xpath(APT_pageObjects.getExpand(obtainedData)));
	Assert.assertTrue(element.getAttribute("src").contains("/Collapse-icon.svg"));
	element.click();
	Assert.assertTrue(element.getAttribute("src").contains("/Collapse-icon.svg"));
	element.click();
	Assert.assertTrue(element.getAttribute("src").contains("/Collapse-icon.svg"));
	
  
}

}


