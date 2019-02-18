package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	
	//page factory
		@FindBy(name="username")
		WebElement username;
		
		@FindBy(name="password")
		WebElement password;
		
		@FindBy(xpath="//input[@value='Login']")
		WebElement submit;
		
		@FindBy(xpath="//button[contains(text(),'Sign Up')]")
		WebElement signup;
		
		@FindBy(xpath="//img[@class='img-responsive']")
		WebElement logo;
		//initializing the page object
		public LoginPage() {
			PageFactory.initElements(driver, this);
		}
		
		public String ValidateLoginPageTitle() {
		return	driver.getTitle();
		}
		
		public boolean ValidateCrmImage() {
		return logo.isDisplayed();
		}
		public Homepage Login(String un,String pw) {
			username.sendKeys(un);
			password.sendKeys(pw);
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click()", submit);
			return new Homepage();
		}
	
}
