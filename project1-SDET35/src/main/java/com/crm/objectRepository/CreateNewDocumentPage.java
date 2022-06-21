package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.comcast.genericUtilities.WebdriverUtility;

public class CreateNewDocumentPage extends WebdriverUtility{
	//Declaration
	@FindBy(name = "notes_title") private WebElement documentNameTxtEdit;
	
	@FindBy(xpath = "//input[@value='T']") private WebElement documentAssignedToRadioBtn;
	
	@FindBy(name = "assigned_group_id") private WebElement documentAssignedToDrpDwn;
	
	@FindBy(xpath = "//iframe[@title='Rich text editor, notecontent, press ALT 0 for help.']") private WebElement notesTextAreaField;
	
	@FindBy(name = "filename") private WebElement pathOfTheFile;
	
	@FindBy(xpath = "//input[@type='submit']") private WebElement submitBtn;
	
	//initialization
	public CreateNewDocumentPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//utilization
	public WebElement getDocumentNameTxtEdit() {
		return documentNameTxtEdit;
	}

	public WebElement getDocumentAssignedToRadioBtn() {
		return documentAssignedToRadioBtn;
	}

	public WebElement getDocumentAssignedToDrpDwn() {
		return documentAssignedToDrpDwn;
	}

	public WebElement getNotesTextAreaField() {
		return notesTextAreaField;
	}

	public WebElement getPathOfTheFile() {
		return pathOfTheFile;
	}

	public WebElement getSubmitBtn() {
		return submitBtn;
	}
	
	public void enterCompleteDocDetails(String docName, String dropDownOption, String notesDescription, String uploadFilePath) {
		documentNameTxtEdit.sendKeys(docName);
		documentAssignedToRadioBtn.click();
		selectDropdownByVText(documentAssignedToDrpDwn, dropDownOption);
		notesTextAreaField.sendKeys(notesDescription);
		pathOfTheFile.sendKeys(uploadFilePath);
		submitBtn.click();
	}
}
