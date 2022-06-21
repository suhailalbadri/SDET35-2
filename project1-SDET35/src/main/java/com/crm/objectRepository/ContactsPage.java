package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage {
	//Declaration
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement createContactLkUpImg;
	
	//initialization
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getCreateContactLkUpImg() {
		return createContactLkUpImg;
	}
	
	public void clickOnCreateNewContactBtn() {
		createContactLkUpImg.click();
	}
}
