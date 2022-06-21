package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericUtilities.WebdriverUtility;

public class CreateNewContactPage extends WebdriverUtility{
	//Declaration
	@FindBy(name = "salutationtype") private WebElement salutationDropD;
	
	@FindBy(name = "firstname") private WebElement firstNameTxtEdit;
	
	@FindBy(name = "lastname") private WebElement lastNameTxtEdit;
	
	@FindBy(name = "mobile") private WebElement mobileNumTxtEdit;
	
	@FindBy(name = "email") private WebElement emailIdTxtEdit;
	
	@FindBy(name = "imagename") private WebElement uploadImgBtn;
	
	@FindBy(xpath = "//img[@alt='Select']/../../../tr[5]/td[2]/img[1]") private WebElement addOrgLkUpImg;
	
	@FindBy(name = "search_text") private WebElement searchForOrgName;
	
	@FindBy(name = "search") private WebElement searchOrgBtn;
	
	@FindBy(xpath = "//a[@href='javascript:window.close();']") private WebElement clickOnOrgName;
	
	@FindBy(xpath = "//input[@value='  Save  ']") private WebElement saveBtn;
	
	//initialization
	public CreateNewContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getSalutationDropD() {
		return salutationDropD;
	}

	public WebElement getFirstNameTxtEdit() {
		return firstNameTxtEdit;
	}

	public WebElement getLastNameTxtEdit() {
		return lastNameTxtEdit;
	}

	public WebElement getMobileNumTxtEdit() {
		return mobileNumTxtEdit;
	}

	public WebElement getEmailIdTxtEdit() {
		return emailIdTxtEdit;
	}

	public WebElement getUploadImgBtn() {
		return uploadImgBtn;
	}
	public WebElement getAddOrgLkUpImg() {
		return addOrgLkUpImg;
	}

	public WebElement getSearchForOrgName() {
		return searchForOrgName;
	}

	public WebElement getSearchOrgBtn() {
		return searchOrgBtn;
	}

	public WebElement getClickOnOrgName() {
		return clickOnOrgName;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	public void enterCompleteContactDetails(String salutText, String firstN, String lastN, String mobNo, String email, String pathOfImg) {
		salutationDropD.sendKeys(salutText);
		firstNameTxtEdit.sendKeys(firstN);
		lastNameTxtEdit.sendKeys(lastN);
		mobileNumTxtEdit.sendKeys(mobNo);
		emailIdTxtEdit.sendKeys(email);
		uploadImgBtn.sendKeys(pathOfImg);
	}
	public void selectOrganization(WebDriver driver, String cWindow,String pWindow, String organizationName) {
		addOrgLkUpImg.click();
		switchToWindow(driver, cWindow);
		searchForOrgName.sendKeys(organizationName);
		searchOrgBtn.click();
		clickOnOrgName.click();
		switchToWindow(driver, pWindow);
	}
	public void clickSaveBtn() {
		saveBtn.click();
	}
}
