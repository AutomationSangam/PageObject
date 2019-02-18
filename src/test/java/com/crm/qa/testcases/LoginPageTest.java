package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginpage;
	Homepage homepage;

	public LoginPageTest() {
	//	super();//to call base class constructor
	}
	
	
	@BeforeMethod
	public void setup() {
		initialization();
		 loginpage=new LoginPage();//to call non static method
	}
	
	@Test(priority=1)
	public void loginpageTitleTest() {
	String title=loginpage.ValidateLoginPageTitle();
	Assert.assertEquals(title, "Free CRM software in the cloud for sales and service");
	}
	@Test(priority=2)
	public void loginpageCrmlogotest() {
		
		boolean crmlogo=loginpage.ValidateCrmImage();
		Assert.assertTrue(crmlogo);
		
	}
	
	@Test(priority=3)
	public void logintest() {
		loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
