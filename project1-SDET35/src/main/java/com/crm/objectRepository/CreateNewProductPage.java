package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericUtilities.WebdriverUtility;

public class CreateNewProductPage extends WebdriverUtility{
	//Declaration
	@FindBy(name = "productname")
	private WebElement pName;
	
	@FindBy(name = "productcategory")
	private WebElement pCategoryDropDown;
	
	@FindBy(name="manufacturer")
	private WebElement pManufacturerDropDown;
	
	@FindBy(xpath = "//img[@title='Select']")
	private WebElement vNameLkUpImg;
	
	@FindBy(name = "search_text")
	private WebElement searchVName;
	
	@FindBy(name = "search")
	private WebElement searchBtn;
	
	@FindBy(xpath = "//a[@href='javascript:window.close();']")
	private WebElement selectDesiredVendor;
	
	@FindBy(xpath = "//input[@name='assigntype']/../input[2]")
	private WebElement pStockHandler;
	
	@FindBy(name = "assigned_group_id")
	private WebElement pStockHandlerDropDown;
	
	@FindBy(id = "my_file_element")
	private WebElement pImageUpload;
	
	@FindBy(xpath = "//input[@value='  Save  ']")
	private WebElement saveBtn;
	
	//initialization
	public CreateNewProductPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization123
	public WebElement getpName() {
		return pName;
	}

	public WebElement getpCategoryDropDown() {
		return pCategoryDropDown;
	}

	public WebElement getpManufacturerDropDown() {
		return pManufacturerDropDown;
	}

	public WebElement getSearchVName() {
		return searchVName;
	}

	public WebElement getSearchBtn() {
		return searchBtn;
	}

	public WebElement getSelectDesiredVendor() {
		return selectDesiredVendor;
	}

	public WebElement getpStockHandler() {
		return pStockHandler;
	}

	public WebElement getpStockHandlerDropDown() {
		return pStockHandlerDropDown;
	}

	public WebElement getpImageUpload() {
		return pImageUpload;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebElement getvNameSelection() {
		return vNameLkUpImg;
	}

	public void productName(String proName) {
		pName.sendKeys(proName);
	}
	public void selectPCategory(String proCategory) {
		selectDropdown(pCategoryDropDown, proCategory);
	}
	public void selectPManufacturer(String proManufacturer) {
		selectDropdown(pManufacturerDropDown, proManufacturer);
	}
	
	public void clickVendorLookUpImg(WebDriver driver) {
		vNameLkUpImg.click();
		switchToWindow(driver, "Vendors&action");
	}
	public void searchAndSelectDesiredVendor(WebDriver driver)
	{
		searchVName.sendKeys("vendor");
		searchBtn.click();
		selectDesiredVendor.click();
		switchToWindow(driver, "Products");
	}
	public void selectPStockHandler() {
		pStockHandler.click();
	}
	public void selectPStockHandlerOption(String proStockHandlerOption) {
		selectDropdownByVText(pStockHandlerDropDown, proStockHandlerOption);
	}
	public void UploadPImage(String path) {
		pImageUpload.sendKeys(path);
	}
	public void clickSaveButton() {
		saveBtn.click();
	}
}