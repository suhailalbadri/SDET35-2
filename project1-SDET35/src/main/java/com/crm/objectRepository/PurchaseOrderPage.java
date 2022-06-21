package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseOrderPage {
	//Declaration
	@FindBy(xpath = "//img[@title='Create Purchase Order...']") private WebElement createPurchaseOrderLkUpImg;
	//Initialization
	public PurchaseOrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public WebElement getCreatePurchaseOrderLkUpImg() {
		return createPurchaseOrderLkUpImg;
	}
	
	public void clickOnCreatePOLkUpImg() {
		createPurchaseOrderLkUpImg.click();
	}
}
