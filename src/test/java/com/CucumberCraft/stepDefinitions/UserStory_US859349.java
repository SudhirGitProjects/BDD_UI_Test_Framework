package com.CucumberCraft.stepDefinitions;

import java.util.Calendar;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.Assert;

import com.CucumberCraft.ExcelReadWrite.DataSourceDecider;
import com.CucumberCraft.Screenshot.ScreenshotTaker;
import com.CucumberCraft.pageObjects.APT_pageObjects;

import cucumber.api.java.en.Then;

public class UserStory_US859349 {
	
	
	static Logger log =LogManager.getLogger(UserStory_US859349.class);
	WebDriver driver=ScreenshotTaker.getScreenshot();
	@Then("^user validates the field named \"([^\"]*)\" is present on the page$")
	public void user_validates_the_field_named_is_present_on_the_page(String arg1) throws Throwable {
	Assert.assertTrue(driver.findElement(By.xpath(APT_pageObjects.getlabelNames(arg1))).isDisplayed());
	  
	}

	@Then("^user validates the checkbox named \"([^\"]*)\" present on the page$")
	public void user_validates_the_checkbox_named_present_on_the_page(String arg1) throws Throwable {
		Assert.assertTrue(driver.findElement(By.xpath(APT_pageObjects.checkBox(arg1))).isDisplayed());    
	}

	@Then("^user validates the button named \"([^\"]*)\" present on the page$")
	public void user_validates_the_button_named_present_on_the_page(String arg1) throws Throwable {
	
		
			Assert.assertTrue(driver.findElement(By.xpath(APT_pageObjects.getButtonByItsName(arg1))).isDisplayed());
		
	}

	@Then("^user validates the TextBox named \"([^\"]*)\" present on the page$")
	public void user_validates_the_TextBox_named_present_on_the_page(String arg1) throws Throwable {
		Assert.assertTrue(driver.findElement(By.xpath(APT_pageObjects.getTextBox(arg1))).isDisplayed());
	}

	@Then("^user validates the radio button named \"([^\"]*)\" present on the page$")
	public void user_validates_the_radio_button_named_present_on_the_page(String arg1) throws Throwable {
		Assert.assertTrue(driver.findElement(By.xpath(APT_pageObjects.getRadioButton(arg1))).isDisplayed());
	

	}

	@Then("^user validates the calendar icon is present against textbox named \"([^\"]*)\"$")
	public void user_validates_the_calendar_icon_is_present_against_textbox_named(String arg1) throws Throwable {
		
	List<WebElement> calendars= driver.findElements(By.xpath(APT_pageObjects.calendar(arg1)));
	    
	  if(arg1.contains("Effective")) {
			Assert.assertTrue(calendars.get(0).isDisplayed());
		}
		else if(arg1.contains("to")){
			Assert.assertTrue(calendars.get(1).isDisplayed());
		}
		
	}
	@Then("^user validates texbox named \"([^\"]*)\" have button next to it$")
	public void user_validates_texbox_named_have_button_next_to_it(String arg1) throws Throwable {
	   Assert.assertTrue(driver.findElement(By.xpath(APT_pageObjects.getButton(arg1))).isDisplayed());
	}

	@Then("^user enters text \"([^\"]*)\" in textbox named \"([^\"]*)\"$")
	public void user_enters_text_in_textbox_named(String arg1, String arg2) throws Throwable {
		String obtainedData=DataSourceDecider.dataFinder(arg1);
		driver.findElement(By.xpath(APT_pageObjects.getTextBox(arg2))).clear();
		driver.findElement(By.xpath(APT_pageObjects.getTextBox(arg2))).sendKeys(obtainedData);
	}

	@Then("^user click on the plus button in the textbox named \"([^\"]*)\"$")
	public void user_click_on_the_plus_button_in_the_textbox_named(String arg1) throws Throwable {
		driver.findElement(By.xpath(APT_pageObjects.getButton(arg1))).click();
	}

	@Then("^user validates the message \"([^\"]*)\" on the screen$")
	public void user_validates_the_message_on_the_screen(String arg1) throws Throwable {
		
	    Assert.assertEquals(driver.findElement(By.xpath(APT_pageObjects.getKeywordsMessages(arg1))).getText(), arg1);
	}
	
	@Then("^user can see the max five keywords from entered \"([^\"]*)\" in the bubble$")
	public void user_can_see_the_max_five_keywords_from_entered_in_the_bubble(String arg1) throws Throwable {
		String obtainedData=DataSourceDecider.dataFinder(arg1);
	  List<WebElement> chips=driver.findElements(By.xpath(APT_pageObjects.matChip()));
	  String[] keywords=obtainedData.split(",");
	  for(int i=0; i<chips.size();i++) {
		  Assert.assertEquals(chips.get(i).getText(), keywords[i]);
	  }
	  
	  
	}

	@Then("^user can remove bubble by clicking on \"([^\"]*)\" crros icon$")
	public void user_can_remove_bubble_by_clicking_on_crros_icon(String arg1) throws Throwable {
		List<WebElement> cancel= driver.findElements(By.xpath(APT_pageObjects.getMatChipCancel()));
	   cancel.get(Integer.parseInt(arg1)).click();
		  
	}
	
	@Then("^user click on the calendar button in textbox named \"([^\"]*)\"$")
	public void user_click_on_the_calendar_button_in_textbox_named(String arg1) throws Throwable {
	
		List<WebElement> calendars= driver.findElements(By.xpath(APT_pageObjects.calendar(arg1)));
		  if(arg1.contains("Effective")) {
				calendars.get(0).click();
			}
			else if(arg1.contains("to")){
				calendars.get(0).click();
				calendars.get(1).click();
			}
		  
	}
	@Then("^user enters text \"([^\"]*)\" in date textbox named \"([^\"]*)\"$")
	public void user_enters_text_in_date_textbox_named(String arg1, String arg2) throws Throwable {
		String obtainedData=DataSourceDecider.dataFinder(arg1);
		List<WebElement> textbox= driver.findElements(By.xpath(APT_pageObjects.getTextBox(arg2)));
		
		 if(arg2.contains("Effective")) {
			 textbox.get(0).clear();
			 textbox.get(0).sendKeys(obtainedData);
			}
			else if(arg2.contains("to")){
				 textbox.get(1).clear();
				 textbox.get(1).sendKeys(obtainedData);
			}   
	}
	@Then("^select date from the calendar with month \"([^\"]*)\" date \"([^\"]*)\" year \"([^\"]*)\"$")
	public void select_date_from_the_calendar_with_month_date_year(String arg1, String arg2, String arg3) throws Throwable {
	  // Date date=new Date(Integer.parseInt(arg1),Integer.parseInt(arg2),Integer.parseInt(arg3));
	  
      int year = Calendar.getInstance().get(Calendar.YEAR);
	
	     driver.findElement(By.xpath(APT_pageObjects.monthOrYear(String.valueOf(year)))).click();
       driver.findElement(By.xpath(APT_pageObjects.getYearInYearBox(arg3))).click();
       switch(arg1){
       case "01":
    	   driver.findElement(By.xpath(APT_pageObjects.getYearInYearBox("January"))).click();
    	   break;
       case "02":
    	   driver.findElement(By.xpath(APT_pageObjects.getYearInYearBox("February"))).click();
    	   break;
       case "03":
    	   driver.findElement(By.xpath(APT_pageObjects.getYearInYearBox("March"))).click();
    	   break;
       case "04":
    	   driver.findElement(By.xpath(APT_pageObjects.getYearInYearBox("April"))).click();
    	   break;
       case "05":
    	   driver.findElement(By.xpath(APT_pageObjects.getYearInYearBox("May"))).click();
    	   break;
       case "06":
    	   driver.findElement(By.xpath(APT_pageObjects.getYearInYearBox("June"))).click();
    	   break;
       case "07":
    	   driver.findElement(By.xpath(APT_pageObjects.getYearInYearBox("July"))).click();
    	   break;
       case "08":
    	   driver.findElement(By.xpath(APT_pageObjects.getYearInYearBox("August"))).click();
    	   break;
       case "09":
    	   driver.findElement(By.xpath(APT_pageObjects.getYearInYearBox("September"))).click();
    	   break;
       case "10":
    	   driver.findElement(By.xpath(APT_pageObjects.getYearInYearBox("October"))).click();
    	   break;
       case "11":
    	   driver.findElement(By.xpath(APT_pageObjects.getYearInYearBox("November"))).click();
    	   break;
       case "12":
    	   driver.findElement(By.xpath(APT_pageObjects.getYearInYearBox("December"))).click();
    	   break;
       }
       
       driver.findElement(By.xpath(APT_pageObjects.getYearInYearBox(arg2))).click();
      
	   }
	@Then("^user click on \"([^\"]*)\" in calendar$")
	public void user_click_on_in_calendar(String arg1) throws Throwable {
		 driver.findElement(By.xpath(APT_pageObjects.nextOrpreviousCalenderButton(arg1))).click();
	 
	}
	
	@Then("^user selects radio button named \"([^\"]*)\"$")
	public void user_selects_radio_button_named(String arg1) throws Throwable {
		driver.findElement(By.xpath(APT_pageObjects.getRadioButton(arg1))).click();
	}
 
	  
	@Then("^user clicks on the button \"([^\"]*)\"$")
	public void user_clicks_on_the_button(String arg1) throws Throwable {
		driver.findElement(By.xpath(APT_pageObjects.getButtonByItsName(arg1))).click();;
	}
}
