package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationPage {
	//Declaration
	@FindBy(xpath = "//img[@title='Create Organization...']") private WebElement createOrgLkUpImg;
	
	@FindBy(xpath = "//a[@title='Organizations']") private WebElement createdOrgList;
	
	//initialization
	public OrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getCreateOrgLkUpImg() {
		return createOrgLkUpImg;
	}
	
	public WebElement getCreatedOrgList() {
		return createdOrgList;
	}

	public void clickOnCreateOrgLkUpImg() {
		createOrgLkUpImg.click();
	}
	public String createdOrgNames() {
		String createdOrganizations = createdOrgList.getText();
		return createdOrganizations;
	}
	
}