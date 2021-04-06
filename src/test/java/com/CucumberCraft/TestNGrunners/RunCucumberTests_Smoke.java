package com.CucumberCraft.TestNGrunners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

import com.CucumberCraft.Screenshot.ImageToPdf;


import com.CucumberCraft.supportLibraries.TimeStamp;
import com.CucumberCraft.supportLibraries.Util;
import com.github.mkolisnyk.cucumber.reporting.CucumberDetailedResults;
import com.github.mkolisnyk.cucumber.reporting.CucumberResultsOverview;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.testng.AbstractTestNGCucumberTests;



@ExtendedCucumberOptions(jsonReport = "target/cucumber-report/Smoke/cucumber.json", 
jsonUsageReport = "target/cucumber-report/Smoke/cucumber-usage.json", 
outputFolder = "target/cucumber-report/Smoke", 
detailedReport = true, 
detailedAggregatedReport = true, 
overviewReport = true, 
usageReport = true)

/**
* Please notice that com.CucumberCraft.stepDefinations.CukeHooks class
* is in the same package as the steps definitions.
* It has two methods that are executed before or after scenario.
* I'm using to take a screenshot if scenario fails.
*/
@CucumberOptions(features = "src/test/resources/features", 
glue = { "com.CucumberCraft.stepDefinitions" }, 
tags = { "@TestId_APS_45"},
monochrome = true,
plugin = {
    
	"pretty", 
	"pretty:target/cucumber-report/Smoke/pretty.txt",
	"html:target/cucumber-report/Smoke",
	"json:target/cucumber-report/Smoke/cucumber.json",
	"junit:target/cucumber-report/Smoke/cucumber-junitreport.xml",
	"com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:target/cucumber-report/Smoke/report.html"})



public class RunCucumberTests_Smoke extends AbstractTestNGCucumberTests {
	
	
final static String timeStampResultPath = TimeStamp.getInstance();
final static File destCucumber = new File(timeStampResultPath);
Scenario scenario;
static Logger log;


static {
	
	log = Logger.getLogger(RunCucumberTests_Smoke.class);
}


	
@AfterTest
private void test() throws IOException {
        Reporter.loadXMLConfig(new File("src/test/resources/extent-config.xml"));
        /*Properties p = System.getProperties();
        p.list(System.out);*/
        
        Reporter.setSystemInfo("User Name",System.getProperty("user.name"));
        Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
        Reporter.setSystemInfo("64 Bit", "Windows 10");
        Reporter.setSystemInfo("3.7.1", "Selenium");
        Reporter.setSystemInfo("3.3.9", "Maven");
        Reporter.setSystemInfo("1.8.0_141", "Java Version");
        Reporter.setTestRunnerOutput("Cucumber JUnit Test Runner");
	log.info("generating aggregate report for the scenario please check the \"Results Folder\"");
	generateCustomReports();
	log.info("generating aggregate report for the scenario please check the \"Results Folder\"");
	copyReportsAggregateReportFolder();
	copyReportsAndPdfFolder();
	log.info("generating aggregate report for the scenario please check the \"Results Folder\"");
	ImageToPdf.freeScreenshotFolder();
	ImageToPdf.freeSmokePng();
    
	
	}

private void generateCustomReports() {
	
	CucumberResultsOverview results1 = new CucumberResultsOverview();
	results1.setOutputDirectory("target");
	results1.setOutputName("cucumber-results");
	results1.setSourceFile("target/cucumber-report/Smoke/cucumber.json");
	try {
		results1.executeFeaturesOverviewReport();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	CucumberDetailedResults detailedResults = new CucumberDetailedResults();
    detailedResults.setOutputDirectory("target");
    detailedResults.setOutputName("cucumber-results");
    detailedResults
                 .setSourceFile("target/cucumber-report/Smoke/cucumber.json");
    detailedResults.setScreenShotLocation("./screenshot");
    try {
           detailedResults.executeDetailedResultsReport(false, true);
    } catch (Exception e) {

           e.printStackTrace();
    }
}	



public static void copyReportsAndPdfFolder() {

	
	File sourceCucumber = new File(Util.getTargetPath());
	File cucumberReportscreenShot = new File(Util.getTargetPath()+"\\screenshot\\");
	File cucumberReportSmoke= new File(Util.getTargetPath()+"\\Smoke\\");
	try {
		File[] listofAllFile = cucumberReportscreenShot.listFiles();
		 for(File file : listofAllFile) {
	     if(file.getName().endsWith(".pdf")) 
		     {
		      file.delete();
		     }
	      }
		 }
		 catch(Exception e) {
			    e.getMessage();
			 }
	
	try{
		 File[] listofAllFile = cucumberReportSmoke.listFiles();
		 for(File file : listofAllFile) {
	     if(file.getName().endsWith(".png")) 
		     {
		      file.delete();
		     }
	      }
		 }
		 catch(Exception e) {
			    e.getMessage();
			 }
	 
	 try {
			FileUtils.copyDirectory(sourceCucumber, destCucumber);
		} catch (IOException e) {
			e.printStackTrace();
		}
	 
		 
}
public static void copyReportsAggregateReportFolder() throws IOException {

	File SourceAggregateReport= new File(Util.getTargetPath().replace("\\cucumber-report",""));
	
	 File[] listofFiles =SourceAggregateReport.listFiles();
	 for(File file : listofFiles) {
	     if(file.getName().endsWith(".html")) {
	    	 try {
				FileUtils.copyFileToDirectory(file, destCucumber);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	 }
	     }
	 
	 
	 try{
		 File[] listofAllFile = SourceAggregateReport.listFiles();
		 for(File file : listofAllFile) {
	     if(file.getName().endsWith(".png")) 
		     {
		      file.delete();
		     }
	      }
		 }
		 catch(Exception e) {
			    e.getMessage();
			 }
	
	 ImageToPdf.Addtxtfile();
}



@AfterSuite
private void copyStoredReports() throws IOException {
	
}

}
