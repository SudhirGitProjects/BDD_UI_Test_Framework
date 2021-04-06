package com.CucumberCraft.stepDefinitions;
import static org.testng.Assert.assertEquals;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.CucumberCraft.ExcelReadWrite.DataSourceDecider;
import com.CucumberCraft.ExcelReadWrite.ExcelReadWrite;
import com.CucumberCraft.Screenshot.ScreenshotTaker;
import com.CucumberCraft.pageObjects.GooglePage;
import com.CucumberCraft.supportLibraries.DriverManager;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class Browser_Excel_StepDef {
	static Logger log = LogManager.getLogger("Test_Steps.class");
	WebDriver driver;
	@Given("^user launches browser with url \"([^\"]*)\"$")
	public void user_launches_browser_with_url(String url) throws Throwable {
	    String ObtainedUrl=DataSourceDecider.urlFinder(url);
	    driver=ScreenshotTaker.getScreenshot();
	    driver.manage().window().maximize();
        driver.get(ObtainedUrl);
        
	}
	
	@Given("^user loads the data from \"([^\"]*)\" located at \"([^\"]*)\"$")
	public void user_loads_the_data_from_located_at(String dataSource, String path) throws Throwable {
	    // data for  Excel sheet and  data base data
		// excel sheet: (first argument: Excel) and (second argument: DB)
		if(dataSource.toLowerCase().equals("excel"))
		{
			ExcelReadWrite.loadExcelFileData(path);
		}
		else if(dataSource.toLowerCase().equals("db"))
		{
			
		}
		else
		{
			throw new Exception("problem: Data source is not defined!!!!+ "//n"
					          +" solution: Use excel or db only in feature file" );
		}
		
		
		
	}
	@Then("^user search for keyword \"([^\"]*)\"$")
	public void user_search_for_keyword(String data) throws Throwable {
		String Obtaineddata =DataSourceDecider.dataFinder(data);
		driver.findElement(By.name(GooglePage.Searchbox)).sendKeys(Obtaineddata);
		driver.findElement(By.xpath(GooglePage.SearchButton)).click();

	}
	
	@Then("^user click on the first hyperlink$")
	public void user_click_on_the_first_hyperlink() throws Throwable {
	
		WebDriverWait wait = new WebDriverWait(driver, 10);
		 
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable((By.xpath(GooglePage.Link))));
		element.click();
	  
	  
	}
	@Then("^user check the title is \"([^\"]*)\"$")
	public void user_check_the_title_is(String arg1) throws Throwable {
	    String title=driver.getTitle();
	    assertEquals(title, arg1);
	  
	}
	    
	@Then("^user check that multiple keywords are present \"([^\"]*)\"$")
		public void user_check_that_multiple_keywords_are_present(String arg1) throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
			String ObtainedData =DataSourceDecider.dataFinder(arg1);
			String[] a=ObtainedData.split("'");
			((JavascriptExecutor)driver).executeScript("window.scrollBy(0,1000)");
			((JavascriptExecutor)driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
			for (int i=0; i<a.length;i++) {
			driver.getPageSource().contains(a[0]);
			}
			
 
		}

		


}

