package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.Homepage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	
	Homepage homepage;
	LoginPage loginpage;
	TestUtil testutil;
	ContactsPage contactspage;
	String sheetname="contacts";
	

	@BeforeMethod
	public void setup() {
		initialization();
		 loginpage=new LoginPage();//to call non static method
		testutil=new TestUtil();
		contactspage=new ContactsPage();
		homepage=new Homepage();
		homepage= loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));
		testutil.switchToFrame();
		contactspage=homepage.clickoncontactslink();
		
	}
	
	@Test(priority=1)
	public void verifycontactslabeltest() {
		
		Assert.assertTrue(contactspage.verifycontactslabel());
	}
	@Test(priority=2)
	public void selectsinglecontactstest() {
		
		contactspage.selectcontactsbyname("xyz abc");
	}
	@Test(priority=3)
	public void selectmultiplecontactstest() {
		
		contactspage.selectcontactsbyname("xyz abc");
		contactspage.selectcontactsbyname("abc xyz");
	}
	
	@Test(priority=4, dataProvider="getcrmtestdata")
	public void validatecreatnewcontact(String title,String firstname,String lastname,String company) {
		homepage.clickonnewcontactlink();
		contactspage.creatnewcontact(title, firstname, lastname, company);
	}
	@DataProvider
	public Object[][] getcrmtestdata() {
	Object[][] data=testutil.getTestData(sheetname);
	return data;
	}
	
	@AfterMethod
	public void Teardown() {
		driver.quit();
	}
	
}
