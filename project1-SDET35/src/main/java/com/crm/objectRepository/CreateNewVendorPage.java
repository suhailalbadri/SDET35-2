package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewVendorPage {
	//Declaration
	@FindBy(name = "vendorname")
	private WebElement vName;
	
	@FindBy(name = "phone")
	private WebElement vPhoneNumber;
	
	@FindBy(xpath = "//input[@value='  Save  ']")
	private WebElement saveBtn;
	
	//initialization
	public CreateNewVendorPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getvName() {
		return vName;
	}

	public WebElement getvPhoneNumber() {
		return vPhoneNumber;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void enterVendorName(String vendorName) {
		vName.sendKeys(vendorName);
	}
	public void enterVendorPhone(String vendorPhone) {
		vPhoneNumber.sendKeys(vendorPhone);
	}
	public void clickOnSaveBtn() {
		saveBtn.click();
	}
}
