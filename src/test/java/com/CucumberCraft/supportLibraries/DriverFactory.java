package com.CucumberCraft.supportLibraries;

import io.appium.java_client.AppiumDriver;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;

import com.experitest.selenium.MobileWebDriver;


/**
 * DriverFactory which will create respective driver Object
 * 
 * @author Cognizant
 */
public class DriverFactory {
	static Logger log = Logger.getLogger(DriverFactory.class);
	private static Properties mobileProperties = Settings.getInstance();

	@SuppressWarnings("rawtypes")
	public static AppiumDriver createInstance(
			SeleniumTestParameters testParameters) {

		AppiumDriver driver = null;
		try {
			switch (testParameters.getExecutionMode()) {

			case MOBILE:

				driver = AppiumDriverFactory.getAppiumDriver(testParameters);
				break;

			case PERFECTO:

				driver = PerfectoDriverFactory
						.getPerfectoAppiumDriver(testParameters);

				break;

			case SAUCELABS:

				driver = SauceLabsDriverFactory.getSauceAppiumDriver(
						testParameters.getMobileExecutionPlatform(),
						testParameters.getDeviceName(),
						mobileProperties.getProperty("SauceHost"),
						testParameters);
				break;

			case MINT:

				driver = MintDriverFactory.getmintAppiumDriver(
						testParameters.getMobileExecutionPlatform(),
						testParameters.getDeviceName(),
						mobileProperties.getProperty("mintHost"),
						testParameters.getMobileOSVersion());
				break;

			default:
				throw new Exception("Unhandled Execution Mode!");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			log.error(ex.getMessage());
		}
		return driver;
	}

	@SuppressWarnings("static-access")
	public static WebDriver createInstanceWebDriver(SeleniumTestParameters testParameters) {
	
		String execution=testParameters.getExecutionMode().getValue();
		System.out.println(execution);
		WebDriver driver = null;
		try {
		
			switch (testParameters.getExecutionMode()) {

			case LOCAL:
				driver = WebDriverFactory.getWebDriver(testParameters.getBrowser());
				break;
				
			case REMOTE:
				driver = WebDriverFactory.getRemoteWebDriver(
						testParameters.getBrowser(),
						testParameters.getBrowserVersion(),
						testParameters.getPlatform(),
						mobileProperties.getProperty("RemoteUrl"));
			
				break;


			case PERFECTO:
				driver = PerfectoDriverFactory.getPerfectoRemoteDriver(testParameters);
				System.out.println(execution);
				break;

			case SAUCELABS:
				driver = SauceLabsDriverFactory.getSauceRemoteWebDriver(mobileProperties.getProperty("SauceHost"),
						testParameters.getBrowser(), testParameters.getBrowserVersion(), testParameters.getPlatform(),
						testParameters);
				break;

			default:
				throw new Exception("Unhandled Execution Mode!");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			log.error(ex.getMessage());
		}
		return driver;
	}


	/**
	 * Seetest Driver initialization
	 *
	 */
	public static MobileWebDriver createInstanceSeetestDriver(
			SeleniumTestParameters testParameters) {
		MobileWebDriver driver = null;
		try {
			switch (testParameters.getExecutionMode()) {

			case SEETEST:
				driver = SeeTestDriverFactory
						.getSeeTestDriver(
								mobileProperties.getProperty("SeeTestHost",
										"localhost"),
								Integer.parseInt(testParameters
										.getSeeTestPort()),
								mobileProperties
										.getProperty("SeeTestProjectBaseDirectory"),
								mobileProperties.getProperty(
										"SeeTestReportType", "xml"),
								"report",
								"Test Name from Driver Init",
								testParameters.getMobileExecutionPlatform(),
								mobileProperties
										.getProperty("SeeTestAndroidApplicationName"),
								mobileProperties
										.getProperty("SeeTestiOSApplicationName"),
								mobileProperties
										.getProperty("SeeTestAndroidWebApplicationName"),
								mobileProperties
										.getProperty("SeeTestiOSWebApplicationName"),
								testParameters.getDeviceName());
				break;

			default:
				throw new Exception("Unhandled Execution Mode!");
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			log.error(ex.getMessage());
		}
		return driver;
	}

}