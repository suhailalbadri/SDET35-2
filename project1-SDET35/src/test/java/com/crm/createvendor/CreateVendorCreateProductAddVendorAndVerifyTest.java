package com.crm.createvendor;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.genericUtilities.BaseClass;
import com.crm.objectRepository.CreateNewProductPage;
import com.crm.objectRepository.CreateNewVendorPage;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.ProductInformationPage;
import com.crm.objectRepository.ProductsPage;
import com.crm.objectRepository.VendorInformationPage;
import com.crm.objectRepository.VendorsPage;
//@Listeners(com.crm.comcast.genericUtilities.ItestListenerImplementation.class)
public class CreateVendorCreateProductAddVendorAndVerifyTest extends BaseClass{
	@Test(groups={"regressionTest"})
	public void createVendorCreateProductAddVendorAndVerifyTest() throws Throwable {

		//generate random number
		int randnum = jUtil.getRandomNumber();
		
		//fetching data from excel
		String product_name = eUtil.getTestDataFromExcel("CreateProduct", 1, 2)+randnum;
		String vendor_name=eUtil.getTestDataFromExcel("CreateProduct", 1, 5)+randnum;

		//mouse over more menu dropdown
		HomePage hPage=new HomePage(driver);
		WebElement moreDropDown = hPage.getMoreDropDown();
		wUtil.mouseOverAnElement(driver, moreDropDown);
		//click on Vendors link
		hPage.mouseOverMoreLnkAndClickOnVendorLnk(driver);
		//CLick on create vendor 
		VendorsPage vPage=new VendorsPage(driver);
		vPage.clickOnVendorLkUpImg();
		//enter vendor name
		CreateNewVendorPage createNewVendor=new CreateNewVendorPage(driver);
		createNewVendor.enterVendorName(vendor_name);
		//click on save button
		createNewVendor.clickOnSaveBtn();
		//verify whether vendor is created
		VendorInformationPage venInfoPage=new VendorInformationPage(driver);
		String vendorname = venInfoPage.vendorTitle();
		if (vendorname.contains(vendor_name)) {
			System.out.println("Vendor is created");
		}
		else {
			System.out.println("Vendor is not created");
		}
		//click on product tab
		hPage.clickOnProductLnk();
		//click on create product look up image
		ProductsPage pPage=new ProductsPage(driver);
		pPage.clickOnCreateProductLkUpImg();
		//enter product name
		CreateNewProductPage createNewProductPage=new CreateNewProductPage(driver);
		createNewProductPage.productName(product_name);
		//click on vendor look up image and switch to vendor child window
		createNewProductPage.clickVendorLookUpImg(driver);
		//select the desired vendor and switch back to parent window
		createNewProductPage.searchAndSelectDesiredVendor(driver);
		//click on save button
		createNewProductPage.clickSaveButton();
		//verify whether product is created
		ProductInformationPage pInfoPage=new ProductInformationPage(driver);
		String pageTitle = pInfoPage.productTitle();
		Assert.assertTrue(pageTitle.contains(product_name));
		System.out.println("CreateVendorCreateProductAddVendorAndVerifyTEST is pass");
	}
}