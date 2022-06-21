package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformationPage {
	//Declaration
	@FindBy(xpath = "//span[@class='lvtHeaderText']")
	private WebElement pTitle;
	
	//initialization
	public ProductInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getpTitle() {
		return pTitle;
	}
	
	public String productTitle() {
		String proTitle=pTitle.getText();
		return proTitle;
	}
}
