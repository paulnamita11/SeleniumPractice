package ToolsQA.DemoSampleProject.test;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.support.PageFactory;

import ToolsQA.DemoSampleProject.test.TestBase;
import ToolsQA.DemoSampleProject.pages.FbHomePage;
import ToolsQA.DemoSampleProject.pages.FbLoginPage;

public class FbLoginTest extends TestBase {
	
	static Properties prop = new Properties();
	
	@Test
	public void init() throws Exception{
		
		InputStream input = new FileInputStream("/Users/namita_pm_pursuitsof/eclipse-workspace/DemoSampleProject/src/main/java/Config/config.properties");
		prop.load(input);
		FbLoginPage loginpage = PageFactory.initElements(driver, FbLoginPage.class);
		
		loginpage.setEmail(prop.getProperty("email"));
		loginpage.setPassword(prop.getProperty("password")); 
		loginpage.ClickOnLoginButton();
		
		 FbHomePage homepage = PageFactory.initElements(driver, FbHomePage.class);
		 Thread.sleep(40000); homepage.clickOnProfileDropDown(); Thread.sleep(40000);
		 homepage.clickOnLogoutLink();
		 
		
	}

}
