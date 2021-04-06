package com.CucumberCraft.Screenshot;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import com.CucumberCraft.stepDefinitions.MasterStepDefs;
import com.CucumberCraft.supportLibraries.DriverManager;
import com.CucumberCraft.supportLibraries.Util;


public class EventHandler extends MasterStepDefs  implements WebDriverEventListener{
	private static RemoteWebDriver driver=(RemoteWebDriver) DriverManager.getWebDriver();
	private static Capabilities caps =driver.getCapabilities();
	private static String browserName = caps.getBrowserName();
	private static String browserVersion = caps.getVersion();
	
	
	static Logger log;
	

	static {
		log = Logger.getLogger(EventHandler.class);
	}
	@Override
	public void afterAlertAccept(WebDriver arg0) {
		
		currentScenario.embed(Util.takeScreenshot (arg0),
				"image/png");		
		log.info("Alert is accepted on : " +arg0.getTitle()); 
	}

	@Override
	public void afterAlertDismiss(WebDriver arg0) {
		currentScenario.embed(Util.takeScreenshot (arg0),
				"image/png");		
		log.info("Alert is dismissed on : " +arg0.getTitle()); 
		
		
	}

	@Override
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		currentScenario.embed(Util.takeScreenshot (arg1),
				"image/png");	
		log.info("value is changing on the page : " +arg1.getTitle()); 
		
	}

	@Override
	public void afterClickOn(WebElement arg0, WebDriver arg1) {

		currentScenario.embed(Util.takeScreenshot (arg1),
				"image/png");
		log.info("Webelement is clicked on page : " +arg1.getTitle()); 
	}

	@Override
	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		
		currentScenario.embed(Util.takeScreenshot (arg2),
				"image/png");
		log.info("Webelement is located on page : " +arg2.getTitle()); 
	}

	@Override
	public void afterNavigateBack(WebDriver arg0) {
		currentScenario.embed(Util.takeScreenshot (arg0),
				"image/png");
		log.info("Navigating backward...and url is :" +arg0.getCurrentUrl()); 
	}

	@Override
	public void afterNavigateForward(WebDriver arg0) {
		currentScenario.embed(Util.takeScreenshot (arg0),
				"image/png");
		log.info("Navigating forward.... and url is :" +arg0.getCurrentUrl()); 
	}

	@Override
	public void afterNavigateRefresh(WebDriver arg0) {
		currentScenario.embed(Util.takeScreenshot (arg0),
				"image/png");
		log.info("Page is refresed: and title of the page is :" +arg0.getTitle()); 
	}

	@Override
	public void afterNavigateTo(String arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		currentScenario.embed(Util.takeScreenshot (arg1),
				"image/png");	
		log.info("Navigated to: "+arg0 +" using: "+browserName +" version: "+browserVersion); 
		
	}

	@Override
	public void afterScript(String arg0, WebDriver arg1) {
		currentScenario.embed(Util.takeScreenshot (arg1),
				"image/png");
		
	}

	@Override
	public void beforeAlertAccept(WebDriver arg0) {
		
		log.info("Locating alert on the page : " +arg0.getTitle()); 
	}

	@Override
	public void beforeAlertDismiss(WebDriver arg0) {
		
		log.info("Alert is located and should be dismissed soon on page : " +arg0.getTitle()); 
	}

	@Override
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
	
	
		log.info("A value change is goin to performed on the page : " +arg1.getTitle()); 
	}

	@Override
	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		
	
		log.info("A click is to be performed on the page : " +arg1.getTitle()); 
	}

	@Override
	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		
		
		log.info("finding element on the page  : " +arg2.getTitle()); 
	}

	@Override
	public void beforeNavigateBack(WebDriver arg0) {
		
		log.info("Navigating back to new page from  : " +arg0.getTitle()); 
	}

	@Override
	public void beforeNavigateForward(WebDriver arg0) {
		
		log.info("Navigating forward to new page from  : " +arg0.getTitle()); 
	}

	@Override
	public void beforeNavigateRefresh(WebDriver arg0) {
		
		log.info("Refresing page  : " +arg0.getTitle()); 
	}

	@Override
	public void beforeNavigateTo(String arg0, WebDriver arg1) {
		
		log.info("Navigating to new page from  : " +arg1.getTitle()); 
	}

	@Override
	public void beforeScript(String arg0, WebDriver arg1) {
		currentScenario.embed(Util.takeScreenshot (arg1),
				"image/png");
		log.info("Script is going to excute on the page : " +arg1.getTitle()); 
	}

	@Override
	public void onException(Throwable arg0, WebDriver arg1) {
		currentScenario.embed(Util.takeScreenshot (arg1),
				"image/png");	
		log.info("An Exception has been occureed on the page : " +arg1.getTitle()+" browser will closed soon"); 
		
		log.info(arg0.getMessage());
		arg1.close();
	}


}
