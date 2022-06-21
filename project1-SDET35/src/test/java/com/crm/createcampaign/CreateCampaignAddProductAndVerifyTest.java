package com.crm.createcampaign;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.crm.comcast.genericUtilities.BaseClass;
import com.crm.objectRepository.CampaignInformationPage;
import com.crm.objectRepository.CampaignsPage;
import com.crm.objectRepository.CreateNewCampaignPage;
import com.crm.objectRepository.HomePage;
//@Listeners(com.crm.comcast.genericUtilities.ItestListenerImplementation.class)
public class CreateCampaignAddProductAndVerifyTest extends BaseClass{
	
	@Test
	public void createCampaignAddProductAndVerifyTest() throws Throwable {
		
		//generate random number
		int randnum = jUtil.getRandomNumber();

		//fetching data from excel
		String product_name = eUtil.getTestDataFromExcel("CreateCampagin", 1, 2);
		String Campaign_Name = eUtil.getTestDataFromExcel("CreateCampagin", 1, 3)+randnum;
		String Campaign_Type = eUtil.getTestDataFromExcel("CreateCampagin", 5, 5);
		String cWindow = eUtil.getTestDataFromExcel("CreateCampagin", 1, 6);
		String pWindow = eUtil.getTestDataFromExcel("CreateCampagin", 1, 7);

		//mouse hover action on more major tab and click on campaigns
		HomePage hPage=new HomePage(driver);
		hPage.mouseOverMoreLnkAndClickOnCampaignLnk(driver);
		//click on create Campaigns button
		CampaignsPage camPage=new CampaignsPage(driver);
		camPage.clickOnCreateCampaignLkUpImg();
		//enter campaign details and click on save
		CreateNewCampaignPage cNewCamPage=new CreateNewCampaignPage(driver);
		cNewCamPage.enterCampaignDetails(driver, Campaign_Name, Campaign_Type, cWindow, product_name, pWindow);
		//get the text of Campaign created
		CampaignInformationPage camInfoPage=new CampaignInformationPage(driver);
		String campaignName=camInfoPage.campaignTitle();
		//verification
		//Assert.assertTrue(campaignName.contains(Campaign_Name));
		//System.out.println("createCampaignAddProductAndVerifyTEST is pass");	
		Assert.assertEquals(campaignName.contains(Campaign_Name),true);
		System.out.println("CreateCampaignAddProductAndVerifyTEST is pass");
	}
}