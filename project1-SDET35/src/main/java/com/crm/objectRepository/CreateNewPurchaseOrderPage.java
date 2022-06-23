package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericUtilities.WebdriverUtility;

public class CreateNewPurchaseOrderPage extends WebdriverUtility{
	//Declaration
	@FindBy(name = "subject") private WebElement PurchaseOrderTxtEdit;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/select.gif']") private WebElement vendorNameLkUpImg;
	
	@FindBy(name = "search_text") private WebElement vendorNameTxtEdit;
	
	@FindBy(name = "search") private WebElement vendorSearchBtn;
	
	@FindBy(xpath = "//a[@href='javascript:window.close();']") private WebElement vendorSelectionLnk;
	
	@FindBy(name = "bill_street") private WebElement billAddressTxtEdit;
	
	@FindBy(name = "ship_street") private WebElement shipAddressRadBtn;
	
	@FindBy(id = "searchIcon1") private WebElement productNameLkUpImg;
	
	@FindBy(name = "search_text") private WebElement productNameTxtedit;
	
	@FindBy(name = "search") private WebElement productNameSearchBtn;
	
	@FindBy(xpath = "//a[@href='javascript:window.close();']") private WebElement productNameSelect;
	
	@FindBy(name = "qty1") private WebElement productQtyTxtEdit;
	
	@FindBy(name = "listPrice1") private WebElement productLstPriceTxtEdit;
	
	@FindBy(xpath = "//input[@value='  Save  ']") private WebElement saveBtn;
	//Initialization
	public CreateNewPurchaseOrderPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Utilization
	public WebElement getPurchaseOrderTxtEdit() {
		return PurchaseOrderTxtEdit;
	}

	public WebElement getVendorNameLkUpImg() {
		return vendorNameLkUpImg;
	}

	public WebElement getVendorNameTxtEdit() {
		return vendorNameTxtEdit;
	}

	public WebElement getVendorSearchBtn() {
		return vendorSearchBtn;
	}

	public WebElement getVendorSelectionLnk() {
		return vendorSelectionLnk;
	}

	public WebElement getBillAddressTxtEdit() {
		return billAddressTxtEdit;
	}

	public WebElement getShipAddressRadBtn() {
		return shipAddressRadBtn;
	}
	
	public WebElement getProductNameLkUpImg() {
		return productNameLkUpImg;
	}	
	
	public WebElement getProductNameTxtedit() {
		return productNameTxtedit;
	}
	
	public WebElement getProductNameSearchBtn() {
		return productNameSearchBtn;
	}
	
	public WebElement getProductNameSelect() {
		return productNameSelect;
	}
	
	public WebElement getProductQtyTxtEdit() {
		return productQtyTxtEdit;
	}

	public WebElement getProductLstPriceTxtEdit() {
		return productLstPriceTxtEdit;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
	public void selectDesiredVendor(WebDriver driver, String vendorName, String cWindow, String pWindow) {
		vendorNameLkUpImg.click();
		switchToWindow(driver, cWindow);
		vendorNameTxtEdit.sendKeys(vendorName);
		vendorSearchBtn.click();
		vendorSelectionLnk.click();
		switchToWindow(driver, pWindow);
	}
	
	public void enterItemNameQtyAndListPrice(WebDriver driver, String proName, String proQty, String proListPrice, String c1Window, String p1Window) {
		//productNameLkUpImg.click();
		//switchToWindow(driver, c1Window);
		//productNameTxtedit.sendKeys(proName);
		//productNameSearchBtn.click();
		//productNameSelect.click();
		//switchToWindow(driver, p1Window);
		productQtyTxtEdit.sendKeys(proQty);
		productLstPriceTxtEdit.clear();
		productLstPriceTxtEdit.sendKeys(proListPrice);
	}
	
	public void enterPurchaseOrderNameAndAddresses(String poName, String billAddress) throws Throwable {
		PurchaseOrderTxtEdit.sendKeys(poName);
		billAddressTxtEdit.sendKeys(billAddress);
		shipAddressRadBtn.sendKeys(billAddress);
	}
	
	public void clickOnSaveButton() {
		saveBtn.click();
	}
}