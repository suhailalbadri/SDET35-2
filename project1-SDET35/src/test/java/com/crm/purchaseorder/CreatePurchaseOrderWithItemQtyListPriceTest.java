package com.crm.purchaseorder;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.genericUtilities.BaseClass;
import com.crm.objectRepository.CreateNewPurchaseOrderPage;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.PurchaseOrderInformationPage;
import com.crm.objectRepository.PurchaseOrderPage;
//@Listeners(com.crm.comcast.genericUtilities.ItestListenerImplementation.class)
public class CreatePurchaseOrderWithItemQtyListPriceTest extends BaseClass{
	@Test
	public void createPurchaseOrderWithItemQtyListPriceTest() throws Throwable {

		//generate random number
		int randnum = jUtil.getRandomNumber();

		//fetching data from Excel sheet
		String PO_Name = eUtil.getTestDataFromExcel("PurchaseOrder", 1, 1)+randnum;
		String vendor_name = eUtil.getTestDataFromExcel("PurchaseOrder", 1, 2);
		String bill_addr = eUtil.getTestDataFromExcel("PurchaseOrder", 1, 3);
		String child_window = eUtil.getTestDataFromExcel("PurchaseOrder", 1, 8);
		String child_window1 = eUtil.getTestDataFromExcel("PurchaseOrder", 2, 8);
		String parent_window = eUtil.getTestDataFromExcel("PurchaseOrder", 1, 9);
		String pro_name = eUtil.getTestDataFromExcel("PurchaseOrder", 1, 5);
		String pro_qty = eUtil.getTestDataFromExcel("PurchaseOrder", 1, 6);
		String pro_listPrice = eUtil.getTestDataFromExcel("PurchaseOrder", 1, 7);

		//mouse hover action on more major tab and click on purchase order link
		HomePage hPage=new HomePage(driver);
		hPage.mouseOverMoreLnkAndClickOnPurOrderLnk(driver);
		//click on create Purchase Order button
		PurchaseOrderPage pOrderPage=new PurchaseOrderPage(driver);
		pOrderPage.clickOnCreatePOLkUpImg();
		CreateNewPurchaseOrderPage cNewPOPage=new CreateNewPurchaseOrderPage(driver);
		//Select desired Vendor
		cNewPOPage.selectDesiredVendor(driver, vendor_name, child_window, parent_window);
		//Enter purchase order name and address
		cNewPOPage.enterPurchaseOrderNameAndAddresses(PO_Name, bill_addr);
		//enter item name, Qty and list price
		cNewPOPage.enterItemNameQtyAndListPrice(driver, pro_name, pro_qty, pro_listPrice, child_window1, parent_window);
		//click on save
		cNewPOPage.clickOnSaveButton();
		//get the text of PO created
		PurchaseOrderInformationPage poInfoPage=new PurchaseOrderInformationPage(driver);
		String poTitle = poInfoPage.purchaseOrderTitle();
		//verification
		Assert.assertTrue(poTitle.contains(PO_Name));
		System.out.println("CreatePurchaseOrderWithItemQtyListPriceTEST is pass");
	}
}