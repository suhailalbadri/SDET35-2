package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VendorsPage {
	//Declaration
	@FindBy(xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement addVendorLkUpImg;
	
	//initialization
	public VendorsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getAddVendorLkUpImg() {
		return addVendorLkUpImg;
	}
	public void clickOnVendorLkUpImg() {
		addVendorLkUpImg.click();
	}
}
