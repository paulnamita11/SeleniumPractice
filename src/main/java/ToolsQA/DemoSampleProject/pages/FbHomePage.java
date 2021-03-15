package ToolsQA.DemoSampleProject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class FbHomePage {
WebDriver driver;
	
	
	public FbHomePage(WebDriver driver) {
		
		this.driver = driver;
	}
	
	@FindBy(how=How.XPATH, using="//div[text()='Account Settings']']") WebElement profileDropdown;
	@FindBy(how=How.LINK_TEXT, using="Log Out") WebElement logoutLink;

	public void clickOnProfileDropDown () {
		profileDropdown.click();
	}
	
	
	public void clickOnLogoutLink() {
		logoutLink.click();
	}
	
	
}
