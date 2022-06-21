package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocumentInformationPage {
	//Declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']") private WebElement dTitle;
	
	//initialization
	public DocumentInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getdTitle() {
		return dTitle;
	}
	
	public String documentTitle() {
		String docTitle = dTitle.getText();
		return docTitle;
	}
}
