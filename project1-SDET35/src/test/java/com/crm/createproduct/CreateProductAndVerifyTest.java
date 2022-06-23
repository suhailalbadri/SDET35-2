package com.crm.createproduct;

import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.genericUtilities.BaseClass;
import com.crm.objectRepository.CreateNewProductPage;
import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.ProductInformationPage;
import com.crm.objectRepository.ProductsPage;
//@Listeners(com.crm.comcast.genericUtilities.ItestListenerImplementation.class)
public class CreateProductAndVerifyTest extends BaseClass{
	@Test(groups={"smokeTest"})
	public void createProductAndVerifyTest() throws Throwable {

		//generate random number
		int randnum = jUtil.getRandomNumber();

		//fetching data from excel
		String product_name = eUtil.getTestDataFromExcel("CreateProduct", 2, 2)+randnum;
		String product_manufacturer=eUtil.getTestDataFromExcel("CreateProduct", 7, 1);
		String product_category=eUtil.getTestDataFromExcel("CreateProduct", 6, 2);
		String product_handler=eUtil.getTestDataFromExcel("CreateProduct", 7, 3);
		String product_imagepath=eUtil.getTestDataFromExcel("CreateProduct", 2, 4);

		//click on product tab
		HomePage hPage=new HomePage(driver);
		hPage.clickOnProductLnk();
		//click on create product look up image
		ProductsPage pPage=new ProductsPage(driver);
		pPage.clickOnCreateProductLkUpImg();
		//enter product name
		CreateNewProductPage createNewProductPage=new CreateNewProductPage(driver);
		createNewProductPage.productName(product_name);
		//select product manufacturer
		createNewProductPage.selectPManufacturer(product_manufacturer);
		//select product category
		//createNewProductPage.selectPCategory(product_category);
		//Select type of product handler
		//createNewProductPage.selectPStockHandler();
		//select product handler
		createNewProductPage.selectPStockHandlerOption(product_handler);
		//upload product image
		createNewProductPage.UploadPImage(product_imagepath);
		//click on save button
		createNewProductPage.clickSaveButton();
		//get the title of the product
		ProductInformationPage pInfoPage=new ProductInformationPage(driver);
		String pageTitle = pInfoPage.productTitle();
		//verification
		Assert.assertTrue(pageTitle.contains(product_name));
		System.out.println("createProductAndVerifyTEST is pass");
	}
}