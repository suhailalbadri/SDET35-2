package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericUtilities.WebdriverUtility;

public class CreateNewCampaignPage extends WebdriverUtility{
	@FindBy(name = "campaignname") private WebElement campaignNameTxtEdit;
	
	@FindBy(name = "campaigntype") private WebElement campaignTypeDropDown;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']") private WebElement selProLkUpImg;
	
	@FindBy(name = "search_text") private WebElement searchProTxtEdit;
	
	@FindBy(name = "search") private WebElement searchBtn;
	
	@FindBy(xpath = "//a[@href='javascript:window.close();']") private WebElement selDesiredPro;
	
	@FindBy(xpath = "//input[@value='  Save  ']") private WebElement saveBtn;
	
	public CreateNewCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCampaignNameTxtEdit() {
		return campaignNameTxtEdit;
	}

	public WebElement getCampaignTypeDropDown() {
		return campaignTypeDropDown;
	}

	public WebElement getSelProLkUpImg() {
		return selProLkUpImg;
	}

	public WebElement getSearchProTxtEdit() {
		return searchProTxtEdit;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSelDesiredPro() {
		return selDesiredPro;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void enterCampaignDetails(WebDriver driver, String camName, String camType, String cWindow, String proName, String pWindow) {
		campaignNameTxtEdit.sendKeys(camName);
		selectDropdown(campaignTypeDropDown, camType);
		selProLkUpImg.click();
		switchToWindow(driver, cWindow);
		searchProTxtEdit.sendKeys(proName);
		searchBtn.click();
		selDesiredPro.click();
		switchToWindow(driver, pWindow);
		saveBtn.click();
	}
}
