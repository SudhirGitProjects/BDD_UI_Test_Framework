package com.CucumberCraft.TestNGrunners;

import java.io.File;
import java.io.IOException;


import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

import com.CucumberCraft.ExcelReadWrite.ExcelReadWrite;
import com.CucumberCraft.Screenshot.ImageToPdf;
import com.CucumberCraft.supportLibraries.TimeStamp;
import com.CucumberCraft.supportLibraries.Util;
import com.github.mkolisnyk.cucumber.reporting.CucumberDetailedResults;
import com.github.mkolisnyk.cucumber.reporting.CucumberResultsOverview;
import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@ExtendedCucumberOptions(jsonReport = "target/cucumber-report/Regresssion/cucumber.json", 
	jsonUsageReport = "target/cucumber-report/Regresssion/cucumber-usage.json", 
	outputFolder = "target/cucumber-report/Regresssion", 
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
	tags = { "@TestId_APS_35" }, 
	monochrome = true,
	plugin = { 
		"pretty", 
		"pretty:target/cucumber-report/Regresssion/pretty.txt",
		"html:target/cucumber-report/Regresssion",
		"json:target/cucumber-report/Regresssion/cucumber.json",
		"junit:target/cucumber-report/Regresssion/cucumber-junitreport.xml"})



public class RunCucumberTests_Regression extends AbstractTestNGCucumberTests {
	
	final static String timeStampResultPath = TimeStamp.getInstance();
	final static File destCucumber = new File(timeStampResultPath);
	Scenario scenario;
static Logger log;
	

	static {
		log = Logger.getLogger(RunCucumberTests_Regression.class);
	}
	
	@AfterTest
	private void test() {
		log.info("generating aggregate report for the scenario please check the \"Results Folder\"");
		generateCustomReports();
		log.info("generating aggregate report for the scenario please check the \"Results Folder\"");
		copyReportsAggregateReportFolder();
		ImageToPdf.freeSmokePng();
		copyReportsAndPdfFolder(scenario);
		log.info("generating aggregate report for the scenario please check the \"Results Folder\"");
		ImageToPdf.freeScreenshotFolder();
		
	}

	private void generateCustomReports() {

		CucumberResultsOverview results1 = new CucumberResultsOverview();
		results1.setOutputDirectory("target");
		results1.setOutputName("cucumber-results");
		results1.setSourceFile("target/cucumber-report/Regresssion/cucumber.json");
		try {
			results1.executeFeaturesOverviewReport();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		CucumberDetailedResults detailedResults = new CucumberDetailedResults();
        detailedResults.setOutputDirectory("target");
        detailedResults.setOutputName("cucumber-results");
        detailedResults
                     .setSourceFile("target/cucumber-report/Regresssion/cucumber.json");
        detailedResults.setScreenShotLocation("./screenshot");
        try {
               detailedResults.executeDetailedResultsReport(false, true);
        } catch (Exception e) {

               e.printStackTrace();
        }
		
	}


	public static void copyReportsAndPdfFolder(Scenario scenario) {

		
		File sourceCucumber = new File(Util.getTargetPath());
		File cumberReportSmoke= new File(Util.getTargetPath()+"\\Smoke\\");
		File destCucumberSmoke= new File(destCucumber.getAbsoluteFile().toString()+"\\Smoke\\");
		
		 try{
			 File[] listofAllFile = cumberReportSmoke.listFiles();
			 for(File file : listofAllFile) {
				   if(file.getName().endsWith(".html")) {
				    	
						FileUtils.copyFileToDirectory(file, destCucumberSmoke);
				   }
			 }
				   File[] listofAllFileInSmoke = destCucumberSmoke.listFiles();
				 
				   for(File files : listofAllFileInSmoke) {
		     if(files.getName().endsWith(".html")) 
			     {
		    	  File dest=new File(files.getName().replace("index",ExcelReadWrite.testIdNumber.get(0)+"_"+scenario.getStatus())+".html");
			      files.renameTo(dest);
			  
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
		 ImageToPdf.freeSmokePng();
			 
}
	public static void copyReportsAggregateReportFolder() {

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
		 ImageToPdf.freeSmokePng();
		
}
	
	

	@AfterSuite
	private void copyStoredReports() {
		// Any customizations after execution can be added here
	}

}