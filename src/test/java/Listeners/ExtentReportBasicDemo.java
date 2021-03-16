package Listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportBasicDemo {
	private static WebDriver driver = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		// start reporters
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
    
        // create ExtentReports and attach reporter(s)
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        // creates a toggle for the given test, adds all log events under it    
        ExtentTest test1 = extent.createTest("MyFirstTest", "Sample description");
        String projectPath = System.getProperty("user.dir");
     // System Property for Chrome Driver   
        System.setProperty("webdriver.chrome.driver", "D:/ChromeDriver/chromedriver.exe");  
          
             // Instantiate a ChromeDriver class.     
        driver=new ChromeDriver();
        // log(Status, details)
        test1.log(Status.INFO, "This step shows usage of log(status, details)");
        driver.get("https://google.com");
        test1.pass("Test started");
        driver.findElement(By.name("q")).sendKeys("automation");
        test1.pass("Text entered");
        System.out.println("############");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
        test1.pass("Button clicked");
        System.out.println("@@@@@@@@@@@");
        driver.close();
        driver.quit();
        test1.pass("Browser closed");
        test1.info("Test completed");
        
     // calling flush writes everything to the log file
        extent.flush();

	}

}
