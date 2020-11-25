package com.testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Pages.BaseClass;
import com.Pages.LoginPage;
import com.Utilities.BrowserFactory;
import com.Utilities.ExcelDataProvider;

public class LoginTest extends BaseClass {
	public static LoginPage loginPage;

	@Test(priority = 1)
	public void loginApp() throws Exception {
		logger = report.createTest("Login To LogicInvoice");
		loginPage= PageFactory.initElements(driver, LoginPage.class);
		logger.info("Starting Application");
		
		loginPage.loginToApp(excelData.getStringData("Login", 0, 0), excelData.getStringData("Login", 0, 1));
		
		logger.pass("Login Success");
	}

}
