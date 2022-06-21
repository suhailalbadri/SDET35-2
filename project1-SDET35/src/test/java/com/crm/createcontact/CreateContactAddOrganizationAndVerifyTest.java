package com.crm.createcontact;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.genericUtilities.BaseClass;
import com.crm.objectRepository.ContactInformationPage;
import com.crm.objectRepository.ContactsPage;
import com.crm.objectRepository.CreateNewContactPage;
import com.crm.objectRepository.HomePage;
//@Listeners(com.crm.comcast.genericUtilities.ItestListenerImplementation.class)
public class CreateContactAddOrganizationAndVerifyTest extends BaseClass{
	@Test(groups={"regressionTest"})
	public void createContactAddOrganizationAndVerifyTest() throws Throwable {
				
		//generate random number
		int randnum = jUtil.getRandomNumber();

		//fetching data from excel
		String SalutType = eUtil.getTestDataFromExcel("CreateContact", 2, 2);
		String FirstName = eUtil.getTestDataFromExcel("CreateContact", 2, 3)+randnum;
		String LastName = eUtil.getTestDataFromExcel("CreateContact", 2, 4)+randnum;
		String OrgName = eUtil.getTestDataFromExcel("CreateContact", 2, 5);
		String mob_num = eUtil.getTestDataFromExcel("CreateContact", 2, 6);
		String email_id = eUtil.getTestDataFromExcel("CreateContact", 2, 7);
		String img_path = eUtil.getTestDataFromExcel("CreateContact", 2, 10);
		String cWindowUrl = eUtil.getTestDataFromExcel("CreateContact", 2, 11);
		String pWindowUrl = eUtil.getTestDataFromExcel("CreateContact", 2, 12);

		//click on Contacts major tab
		HomePage hPage=new HomePage(driver);
		hPage.clickOnContactsLnk();
		//click on create contact button
		ContactsPage cPage=new ContactsPage(driver);
		cPage.clickOnCreateNewContactBtn();
		//enter all details to create contact
		CreateNewContactPage cNewPage=new CreateNewContactPage(driver);
		cNewPage.enterCompleteContactDetails(SalutType, FirstName, LastName, mob_num, email_id, img_path);
		//select organization
		cNewPage.selectOrganization(driver,cWindowUrl, pWindowUrl, OrgName);
		//click on save
		cNewPage.clickSaveBtn();
		//get the text of contact name created
		ContactInformationPage cInfoPage=new ContactInformationPage(driver);
		String cTitlename=cInfoPage.contactTitle();
		//verification
		Assert.assertTrue(cTitlename.contains(LastName+" "+FirstName));
		System.out.println("CreateContactAddOrganizationAndVerifyTEST is pass");   
	}
}