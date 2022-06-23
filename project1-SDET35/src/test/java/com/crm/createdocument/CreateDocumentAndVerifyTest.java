package com.crm.createdocument;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.genericUtilities.BaseClass;
import com.crm.objectRepository.CreateNewDocumentPage;
import com.crm.objectRepository.DocumentInformationPage;
import com.crm.objectRepository.DocumentsPage;
import com.crm.objectRepository.HomePage;
//@Listeners(com.crm.comcast.genericUtilities.ItestListenerImplementation.class)
public class CreateDocumentAndVerifyTest extends BaseClass{
@Test
	public void createDocumentAndVerifyTest() throws Throwable {
		
		//generate random number
		int randnum = jUtil.getRandomNumber();
				
		//fetching data from excel
		String document_name = eUtil.getTestDataFromExcel("CreateDocument", 1, 2)+randnum;
		String docAssignedTo = eUtil.getTestDataFromExcel("CreateDocument", 1, 4);
		String notes_description = eUtil.getTestDataFromExcel("CreateDocument", 1, 5);
		String file_path=eUtil.getTestDataFromExcel("CreateDocument", 1, 6);

		//click on documents major tab
		HomePage hPage=new HomePage(driver);
		hPage.clickOnDocLnk();
		//click on create document
		DocumentsPage dPage=new DocumentsPage(driver);
		dPage.clickOnCreateDocLkUpImg();
		//enter all details of the document
		CreateNewDocumentPage createNewDocPage=new CreateNewDocumentPage(driver);
		createNewDocPage.enterCompleteDocDetails(document_name, docAssignedTo, notes_description , file_path);
		//get the title of document
		DocumentInformationPage dInfoPage=new DocumentInformationPage(driver);
		String docTitle = dInfoPage.documentTitle();
		//verification
		Assert.assertTrue(docTitle.contains(document_name));
		System.out.println("CreateDocumentAndVerifyTEST is pass");
		System.out.println("success success success");
	}
}
