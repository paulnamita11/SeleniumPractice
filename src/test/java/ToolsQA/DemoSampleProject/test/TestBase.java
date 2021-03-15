package ToolsQA.DemoSampleProject.test;

import java.io.FileInputStream;
//import static org.testng.AssertJUnit.assertTrue;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;



public class TestBase {

	 protected static WebDriver driver = null;
	 static Properties prop = new Properties();
	 

		/**
	     * Rigorous Test :-)
	     */
	    @BeforeSuite
	    public void initialize() throws IOException
	    {
	    	
	    	InputStream input = new FileInputStream("/Users/namita_pm_pursuitsof/eclipse-workspace/DemoSampleProject/src/main/java/Config/config.properties");
			prop.load(input);
	    	
	    	// System Property for Chrome Driver   
	        System.setProperty("webdriver.chrome.driver", "D:\\ChromeDriver\\chromedriver.exe");  
	          
	             // Instantiate a ChromeDriver class.     
	        driver=new ChromeDriver();  
	          
	         //Maximize the browser  
	          driver.manage().window().maximize();
	       
	          driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	          
	          driver.get(prop.getProperty("url"));
	    	
	    	
	    	//assertTrue( true );
	    }
	    
	    @AfterSuite
	    public void TearDownTest() {
	    	
	    	//TestBase.driver.quit();
	    	
	    }
	
	
}
