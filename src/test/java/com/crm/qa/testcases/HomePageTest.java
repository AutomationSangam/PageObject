package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	Homepage homepage;
	LoginPage loginpage;
	TestUtil testutil;
	ContactsPage contactspage;
	
	public HomePageTest() {
			super();//to call base class constructor
		}
		
	@BeforeMethod
	public void setup() {
		initialization();
		 loginpage=new LoginPage();//to call non static method
		testutil=new TestUtil();
		contactspage=new ContactsPage();
		homepage=new Homepage();
		homepage= loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));
	}
	//Test cases should be independent to each other
	//before each test case launch the browser and login 
	//@Test-Execute the test case
	//after each test case close the browser
	@Test(priority=1)
	public void verifyhomepagetitletest() {
		String title=homepage.verifyhomepagetitle();
		Assert.assertEquals(title, "CRMPRO","Homepage title is not matched");
		
	}
	
	@Test(priority=2)
	public void verifyusernametest() {
		testutil.switchToFrame();
	boolean flag=homepage.verifyusername();
	Assert.assertTrue(flag);
	}
	

	
	@Test(priority=3)
	public void verifycontactslinktest1(){
		testutil.switchToFrame();
		contactspage=homepage.clickoncontactslink();
	}
	
	@AfterMethod
	public void Teardown() {
		driver.quit();
	}
	
	

}
