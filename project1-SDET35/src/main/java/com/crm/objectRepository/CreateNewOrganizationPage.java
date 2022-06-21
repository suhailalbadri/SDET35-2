package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericUtilities.WebdriverUtility;

public class CreateNewOrganizationPage extends WebdriverUtility{
	//Declaration
	@FindBy(name = "accountname") private WebElement orgNameTxtEdit;
	
	@FindBy(name = "industry") private WebElement industyDrpDwn;
	
	@FindBy(name = "accounttype") private WebElement orgTypeDrpDwn;
	
	@FindBy(xpath = "//input[@value='T']") private WebElement assignedToRadBtn;
	
	@FindBy(name = "phone") private WebElement phoneNumTxtEdit;
	
	@FindBy(xpath = "//input[@value='  Save  ']") private WebElement saveBtn;
	
	//initialization
	public CreateNewOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getOrgNameTxtEdit() {
		return orgNameTxtEdit;
	}

	public WebElement getIndustyDrpDwn() {
		return industyDrpDwn;
	}

	public WebElement getOrgTypeDrpDwn() {
		return orgTypeDrpDwn;
	}

	public WebElement getAssignedToRadBtn() {
		return assignedToRadBtn;
	}

	public WebElement getPhoneNumTxtEdit() {
		return phoneNumTxtEdit;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void enterOrgName(String organizationName) {
		orgNameTxtEdit.sendKeys(organizationName);
	}
	public void selectIndustryFromDD(String industryName) {
		selectDropdown(industyDrpDwn, industryName);
	}
	public void selectOrgTypeFromDD(String organizationType) {
		selectDropdown(orgTypeDrpDwn, organizationType);
	}
	public void selectOrgAssignedToRadioBtn() {
		assignedToRadBtn.click();
	}
	public void enterPhoneNum(String phoneNumber) {
		phoneNumTxtEdit.sendKeys(phoneNumber);
	}
	public void saveBtn() {
		saveBtn.click();
	}
}