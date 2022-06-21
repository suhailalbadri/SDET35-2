package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignInformationPage {
	@FindBy(xpath = "//span[@class='dvHeaderText']") private WebElement camTitle;
	
	public CampaignInformationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getCamTitle() {
		return camTitle;
	}
	
	public String campaignTitle() {
		String campaignTitle = camTitle.getText();
		return campaignTitle;
	}
}
