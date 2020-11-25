package com.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	/* In this Helper Class you can cover following steps
	 * ScreenShot Capturing
	 * Alerts Handling
	 * Frames Handling
	 * Windows Handling
	 * Sync Issue
	 * JavaScript executer handling
	 * */

	public static String getScreenShot(WebDriver driver, String screenshotName)  {
		TakesScreenshot ts = (TakesScreenshot) driver;
		
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots" under src folder
		
		String destination = System.getProperty("user.dir") + "./Screenshots/" + screenshotName +"_"+ getCurrentDataTime() + ".png";
		
		File finalDestination = new File(destination);
		
		try {
			FileUtils.copyFile(source, finalDestination);
			System.out.println("Screenshot Captured");
		} catch (IOException e) {
			System.out.println("Unable to Handle Screenshot"+ e.getMessage());
		}
		return destination;
	}
	
	public static String getCurrentDataTime() {
		String dateName = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss").format(new Date());
		return dateName;
	}
}

