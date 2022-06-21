package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentsPage {
	//Declaration
	@FindBy(xpath = "//img[@title='Create Document...']") private WebElement createDocLkUpImg;
	
	//initialization
	public DocumentsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getCreateDocLkUpImg() {
		return createDocLkUpImg;
	}
	
	public void clickOnCreateDocLkUpImg() {
		createDocLkUpImg.click();
	}
}
