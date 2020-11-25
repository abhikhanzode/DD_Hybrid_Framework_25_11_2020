package com.Pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.Utilities.BrowserFactory;
import com.Utilities.ConfigDataProvider;
import com.Utilities.ExcelDataProvider;
import com.Utilities.Helper;
import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentEmailReporter;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BaseClass {
	public WebDriver driver;
	public ExcelDataProvider excelData;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentHtmlReporter extent;
	public ExtentTest logger;
	
	
	
	@BeforeSuite
	public void setupExcelSuit() {
		// To report a log it optional
		Reporter.log("Setting up report and test is getting ready",true);
		
		excelData = new ExcelDataProvider();
		config = new ConfigDataProvider();
		extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/LIReport_"+Helper.getCurrentDataTime()+".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		
		Reporter.log("Setting Done- Test can be started",true);


	}
	
	@BeforeClass
	public void setup() {
		Reporter.log("Trying to start browser and getting application ready",true);
		driver = BrowserFactory.startApplication(driver,config.getBrowser(), config.getStagingURL());
		Reporter.log("Browser and application is up and running",true);

	}
	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);

	}
	@AfterMethod
	public void getResultWithSS(ITestResult result) throws Exception {
		Reporter.log("Test is about to end",true);

		
		if (result.getStatus() == ITestResult.FAILURE) {
		//	Helper.getScreenShot(driver, result.getName());
			logger.fail("Test Failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.getScreenShot(driver, result.getName())).build());
		}
		else if (result.getStatus()==ITestResult.SUCCESS) {
			logger.pass("Test Passed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.getScreenShot(driver, result.getName())).build());

		}
//		else if(result.getStatus()==ITestResult.SKIP) {
//			logger.skip("Test Skipped",MediaEntityBuilder.createScreenCaptureFromPath(Helper.getScreenShot(driver, result.getName())).build());
//
//		}
		report.flush();
		Reporter.log("Testing completed >>>> Reports Generated",true);

	}
}
