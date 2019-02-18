package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class Homepage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'User: sangam bharadia')]")
	WebElement usernamelabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactslink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newcontactlink;
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement Dealslink;
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement Taskslink;
	
	
	public  Homepage() {
		PageFactory.initElements(driver, this);
	}
	public String verifyhomepagetitle() {
		return driver.getTitle();
	}
	public boolean verifyusername() {
	return	usernamelabel.isDisplayed();
	}
	
	public ContactsPage clickoncontactslink() {
		contactslink.click();
		return new ContactsPage();
	}
	public Deals clickondealslink() {
		Dealslink.click();
		return new Deals();
	}
	public TaskPage clickontaskslink() {
		Taskslink.click();
		return new TaskPage();
	}
	public void clickonnewcontactlink() {
		Actions action=new Actions(driver);
		action.moveToElement(contactslink).build().perform();
		newcontactlink.click();
	}

}
