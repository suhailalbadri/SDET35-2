package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	//Declaration
	@FindBy(xpath = "//span[@class='dvHeaderText']") private WebElement oTitle;
	
	//initialization
	public OrganizationInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getoTitle() {
		return oTitle;
	}
	
	public String organizationTitle() {
		String orgName = oTitle.getText();
		return orgName;
	}
}
