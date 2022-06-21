package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PurchaseOrderInformationPage {
	//Declaration
	@FindBy(xpath = "//span[@class='lvtHeaderText']") private WebElement poTitle;
	//Initialization
	public PurchaseOrderInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public WebElement getPoTitle() {
	return poTitle;
	}

	public String purchaseOrderTitle() {
		String purOrdTit = poTitle.getText();
		return purOrdTit;
	}
}