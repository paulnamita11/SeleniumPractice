package com.ExtentReportExmple.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.ExtentReportExample.bases.TestBase;

public class FbLoginPage extends TestBase {


	
	@FindBy(how=How.XPATH, using="//input[@id='email']")
	WebElement emailTextBox;
	@FindBy(how=How.XPATH, using="//input[@id='pass']") 
	WebElement passwordTextBox;
	@FindBy(how=How.XPATH, using="//button[@type='submit'][@name='login']")
	WebElement signinButton;
	
	
	public String getPageTitle() {
		String title = driver.getTitle();
		return title;
	}
	
	public boolean verifyBasePageTitle() {
		String expectedPageTitle = "Google";
		return getPageTitle().contains(expectedPageTitle);
	}
	
	public void setEmail (String strEmail) {
		emailTextBox.sendKeys(strEmail);
		
	}
	
	
	public void setPassword (String strPassword) {
		passwordTextBox.sendKeys(strPassword);
	}
	
	
	public void ClickOnLoginButton() {
		signinButton.click();
	}
	
}
