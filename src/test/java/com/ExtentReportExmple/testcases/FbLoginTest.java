package com.ExtentReportExmple.testcases;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.ExtentReportExmple.pages.FbHomePage;
import com.ExtentReportExmple.pages.FbLoginPage;
import com.aventstack.extentreports.Status;
import com.ExtentReportExample.bases.ExtentTestManager;
import com.ExtentReportExample.bases.TestBase;

public class FbLoginTest extends TestBase {
	
	
	 static Properties prop = new Properties();
	 FbLoginPage basePage;

	 
	 public FbLoginTest() {
		 super();
	 }
	
	    @BeforeSuite
	    public void setUp() throws IOException
	    {
	    	initialization();
	    	//basePage = new FbLoginPage();
			
	    	
	    }
	    
	    
    @Test(priority = 0)
	public void verifyHomePage() {
		System.out.println("Home page test...");
		
		Assert.assertTrue(basePage.verifyBasePageTitle(), "Home page title doesn't match");
	}  
    
    @Test(priority = 1)
	public void baseTest1() {
		ExtentTestManager.getTest().log(Status.INFO, "Hellooo started base test1");
		System.out.println("Hey im in test1 test");
		ExtentTestManager.getTest().log(Status.INFO, "Hey im in base test1 1");
		ExtentTestManager.getTest().log(Status.INFO, "Hey im in base test1 2");
		ExtentTestManager.getTest().log(Status.INFO, "Hey im in base test1 3");
		ExtentTestManager.getTest().log(Status.INFO, "Hey im in base test1 4");
	}
	
	@Test(priority = 2)
	public void LoginIntoFB() throws Exception{
		System.out.println("==============INSIDE INIT");
		ExtentTestManager.getTest().log(Status.INFO, "Hellooo started base test");
		InputStream input = new FileInputStream("/Users/namita_pm_pursuitsof/eclipse-workspace/ExtentReportExmple/src/main/java/configuration/config.properties");
		prop.load(input);
		FbLoginPage loginpage = PageFactory.initElements(driver, FbLoginPage.class);
		
		loginpage.setEmail(prop.getProperty("email"));
		ExtentTestManager.getTest().log(Status.INFO, "emailId entered");
		loginpage.setPassword(prop.getProperty("password")); 
		ExtentTestManager.getTest().log(Status.INFO, "passowrd entered");
		loginpage.ClickOnLoginButton();
		ExtentTestManager.getTest().log(Status.INFO, "click on Login");
		
		 FbHomePage homepage = PageFactory.initElements(driver, FbHomePage.class);
		 Thread.sleep(40000); homepage.clickOnProfileDropDown(); Thread.sleep(40000);
		 homepage.clickOnLogoutLink();
		 
		
	}
	
	
	@AfterSuite
    public void TearDownTest() {
		ExtentTestManager.getTest().log(Status.INFO, "Test execution completed");
    	//TestBase.driver.quit();
    	
    }
	
	
}
