package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	
	WebDriver driver; 

	public LoginPage(WebDriver ldriver) {
		this.driver = ldriver;
	}
	@FindBy(name = "username") WebElement uname;
	@FindBy(name = "password") WebElement upass;
	@FindBy(xpath = "//button[contains(text(),'Login')]") WebElement loginBtn;

	public void loginToApp(String unameArgu, String upassArgu) throws Exception {
		Thread.sleep(2000);
		uname.clear();
		Thread.sleep(2000);
		uname.sendKeys(unameArgu);
		upass.clear();
		Thread.sleep(2000);
		upass.sendKeys(upassArgu);
		Thread.sleep(1000);
		loginBtn.click();
	}
	
}
