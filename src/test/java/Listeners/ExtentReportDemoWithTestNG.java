package Listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportDemoWithTestNG {
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	WebDriver driver;
	
	@BeforeSuite
	public void setup() {
		// start reporters
        htmlReporter = new ExtentHtmlReporter("extent1.html");
    
        // create ExtentReports and attach reporter(s)
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        
	}
	
	
	@BeforeTest
	public void setupTest() {
		// System Property for Chrome Driver   
        System.setProperty("webdriver.chrome.driver", "D:/ChromeDriver/chromedriver.exe");  
          
             // Instantiate a ChromeDriver class.     
        driver=new ChromeDriver();
		
	}
	
	@Test
	public void test1() throws Exception {
		// creates a toggle for the given test, adds all log events under it    
        ExtentTest test2 = extent.createTest("MyFirstTest", "Sample description");
        driver.get("https://google.com");
        test2.pass("Test started");
        
     // log(Status, details)
        test2.log(Status.INFO, "This step shows usage of log(status, details)");

        // info(details)
        test2.info("This step shows usage of info(details)");
        
        // log with snapshot
        test2.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
        
        // test with snapshot
        test2.addScreenCaptureFromPath("screenshot.png");
		
	}
	
	@AfterTest
	public void tearDownTest() {
		driver.close();
        driver.quit();
        System.out.println("Test completed");
	}
	
	@AfterSuite
	public void tearDown() {
		// calling flush writes everything to the log file
        extent.flush();
		
	}

}
