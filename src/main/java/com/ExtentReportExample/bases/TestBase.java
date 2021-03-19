package com.ExtentReportExample.bases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	
	
	/*
	 * public WebDriver getDriver() { return driver; }
	 */

	public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java"
					+ "/configuration/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static void initialization(){
		String browserName = prop.getProperty("browser");

		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", "D:/ChromeDriver/chromedriver.exe");	
			driver = new ChromeDriver(); 
		}
		else if(browserName.equals("firefox")){
			System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+ "/src/main/java/com/qa/drivers/geckodriver.exe");	
			driver = new FirefoxDriver(); 
		}
		
		else if(browserName.equals("InternetExplorer")){
			System.setProperty("webdriver.ie.driver", System.getProperty("user.dir")+ "/src/main/java/com/qa/drivers/IEDriverServer.exe");	
			driver = new InternetExplorerDriver(); 
			System.out.println("IE browser is Initializing");
		}

		driver.get(prop.getProperty("url"));

	}
	
}
