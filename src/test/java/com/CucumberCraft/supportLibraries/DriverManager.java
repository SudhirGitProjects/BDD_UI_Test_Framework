package com.CucumberCraft.supportLibraries;


import java.util.HashSet;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;


import com.experitest.selenium.MobileWebDriver;

import io.appium.java_client.AppiumDriver;

/**
 * A generic WebDriver manager, which handles multiple instances of WebDriver.
 * 
 * 
 */
public class DriverManager {
	public static HashSet<SessionId> sessionSet=new HashSet<SessionId>();

	/*
	 * Used for Multithreading of WebDriver Object
	 */
	@SuppressWarnings("rawtypes")
	private static ThreadLocal<AppiumDriver> appiumDriver = new ThreadLocal<AppiumDriver>();
	private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
	private static ThreadLocal<MobileWebDriver> seetestDriver = new ThreadLocal<MobileWebDriver>();
	private static ThreadLocal<SeleniumTestParameters> testParameters = new ThreadLocal<SeleniumTestParameters>();
	

	static Logger log;

	static {
		log = Logger.getLogger(DriverManager.class);
	}

	// WebDriver Object Creation

	public static WebDriver getWebDriver() {
		 
		if (webDriver.get() == null) {
			// this is need when running tests from IDE
			log.info("Thread has no WedDriver, creating new one");
			setWebDriver(DriverFactory.createInstanceWebDriver(getTestParameters()));
		}
		log.debug("Getting instance of remote driver" + webDriver.get().getClass());
		WebDriver driver= webDriver.get();
		   driver.manage().deleteAllCookies();
		   driver.manage().window().maximize();
		    SessionId session =  ((RemoteWebDriver) driver).getSessionId();
		    sessionSet.add(session);
		        return driver;
	}

	// AppiumDriver Object Creation

	@SuppressWarnings("rawtypes")
	public static AppiumDriver getAppiumDriver() {
		if (appiumDriver.get() == null) {
			// this is need when running tests from IDE
			log.info("Thread has no Appium driver, creating new one");
			setAppiumDriver(DriverFactory.createInstance(null));
		}
		log.debug("Getting instance of remote driver" + appiumDriver.get().getClass());
		return appiumDriver.get();
	}
	
	// SeetestDriver Object Creation
	public static MobileWebDriver getSeetestDriver() {
		if (seetestDriver.get() == null) {
			// this is need when running tests from IDE
			log.info("Thread has no Seetest driver, creating new one");
			setSeetestDriver(DriverFactory.createInstanceSeetestDriver(null));
		}
		log.debug("Getting instance of remote driver" + seetestDriver.get().getClass());
		return seetestDriver.get();
	}

	
	public static void setAppiumDriver(@SuppressWarnings("rawtypes") AppiumDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		DriverManager.appiumDriver.set(driver);
	}

	public static void setWebDriver(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		DriverManager.webDriver.set(driver);
	}

	public static void setSeetestDriver(MobileWebDriver driver) {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		DriverManager.seetestDriver.set(driver);
	}
	
	public static void setTestParameters(SeleniumTestParameters testParameters) {
		DriverManager.testParameters.set(testParameters);

	}

	public static SeleniumTestParameters getTestParameters() {
		return testParameters.get();
	}
}