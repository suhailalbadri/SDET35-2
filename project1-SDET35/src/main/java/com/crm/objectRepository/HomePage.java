package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericUtilities.WebdriverUtility;

public class HomePage extends WebdriverUtility{
	//Declaration
	@FindBy(linkText = "Organizations")
	private WebElement orgLnk;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactsLnk;
	
	@FindBy(linkText = "Products")
	private WebElement productLnk;
	
	@FindBy(linkText = "Documents")
	private WebElement docLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/menuDnArrow.gif']")
	private WebElement moreDropDown;
	
	@FindBy(name = "Vendors")
	private WebElement vendorLnk;
	
	@FindBy(name = "Campaigns")
	private WebElement campaignLnk;
	
	@FindBy(name = "Purchase Order")
	private WebElement purchaseOrderLnk;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement userImgDropDown;
	
	@FindBy(xpath = "//a[.='Sign Out']")
	private WebElement signOutLnk;
	
	//initialization
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getOrgLnk() {
		return orgLnk;
	}

	public WebElement getContactsLnk() {
		return contactsLnk;
	}

	public WebElement getProductLnk() {
		return productLnk;
	}

	public WebElement getDocLnk() {
		return docLnk;
	}

	public WebElement getMoreDropDown() {
		return moreDropDown;
	}

	public WebElement getVendorLnk() {
		return vendorLnk;
	}

	public WebElement getCampaignLnk() {
		return campaignLnk;
	}

	public WebElement getPurchaseOrderLnk() {
		return purchaseOrderLnk;
	}
	
	public WebElement getUserImgDropDown() {
		return userImgDropDown;
	}

	public WebElement getSignOutLnk() {
		return signOutLnk;
	}
	
	public void clickOnOrgLnk() {
		orgLnk.click();
	}
	public void clickOnContactsLnk() {
		contactsLnk.click();
	}
	public void clickOnProductLnk() {
		productLnk.click();
	}
	public void clickOnDocLnk() {
		docLnk.click();
	}
	public void mouseOverMoreLnk(WebDriver driver) {
		mouseOverAnElement(driver, moreDropDown);
	}
	public void mouseOverMoreLnkAndClickOnVendorLnk(WebDriver driver) {
		mouseOverAnElement(driver, moreDropDown);
		vendorLnk.click();
	}
	public void mouseOverMoreLnkAndClickOnCampaignLnk(WebDriver driver) {
		mouseOverAnElement(driver, moreDropDown);
		campaignLnk.click();
	}
	public void mouseOverMoreLnkAndClickOnPurOrderLnk(WebDriver driver) {
		mouseOverAnElement(driver, moreDropDown);
		purchaseOrderLnk.click();
	}
	public void signoutFromAppli() {
		userImgDropDown.click();
		signOutLnk.click();
	}
}
