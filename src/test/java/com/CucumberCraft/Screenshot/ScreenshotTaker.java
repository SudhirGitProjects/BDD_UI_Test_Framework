package com.CucumberCraft.Screenshot;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.openqa.selenium.support.events.EventFiringWebDriver;


import com.CucumberCraft.supportLibraries.DriverManager;

public class ScreenshotTaker {

	private static EventHandler handler=new EventHandler();
	static Logger log;

	static {
		log = Logger.getLogger(ScreenshotTaker.class);
	}

public static EventFiringWebDriver getScreenshot(){
	WebDriver driver=DriverManager.getWebDriver();
	
	EventFiringWebDriver eventDriver=new EventFiringWebDriver(driver);
	 SessionId session =  ((RemoteWebDriver) driver).getSessionId();
	    log.info("creating browser session having session id: "+ session);
	return eventDriver.register(handler);	
	
	
}

public static void takeSnapShot(WebDriver driver,String path) throws Exception{

    //Convert web driver object to TakeScreenshot

    TakesScreenshot scrShot =((TakesScreenshot)driver);

    //Call getScreenshotAs method to create image file

            File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

        //Move image file to new destination

            File DestFile=new File(path);

            //Copy file at destination

            FileUtils.copyFile(SrcFile, DestFile);

}

	

}
