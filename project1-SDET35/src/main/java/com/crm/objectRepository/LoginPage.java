package com.crm.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	//Declaration
	@FindBy(name = "user_name")
	private WebElement usernameTextEdit;
	
	@FindBy(name = "user_password")
	private WebElement passwordTextEdit;
	
	@FindBy(id = "submitButton")
	private WebElement submitButton;
	
	//initialization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public WebElement getUsernameTextEdit()
	{
		return usernameTextEdit;
	}
	public WebElement getPasswordTextEdit()
	{
		return passwordTextEdit;
	}
	public WebElement getSubmitButton()
	{
		return submitButton;
	}
	
	public void loginToApplication(String username, String password)
	{
		usernameTextEdit.sendKeys(username);
		passwordTextEdit.sendKeys(password);
		submitButton.click();
	}
}