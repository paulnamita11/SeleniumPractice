package ToolsQA.DemoSampleProject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FbLoginPage {

	WebDriver driver;
	
	
	public FbLoginPage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	@FindBy(how=How.XPATH, using="//input[@id='email']")
	WebElement emailTextBox;
	@FindBy(how=How.XPATH, using="//input[@id='pass']") 
	WebElement passwordTextBox;
	@FindBy(how=How.XPATH, using="//button[@type='submit'][@name='login']")
	WebElement signinButton;
	
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
