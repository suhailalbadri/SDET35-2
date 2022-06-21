package com.crm.comcast.genericUtilities;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;
/**
 * contains all reusable actions of webDriver
 * @author FARHAN SD
 *
 */
public class WebdriverUtility 
{
	/**
	 * It will wait for 10 seconds till the page gets loaded
	 * @param driver
	 */
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	/**
	 * It will wait for JavaScript element
	 * @param driver
	 */
	public void waitForPageToLoadForJSElement(WebDriver driver) 
	{
		driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
	}
	/**
	 * It will wait for the element in the GUI for polling time of 500ms
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeClickable(WebDriver driver, WebElement element) 
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * It will check for the title in the GUI for polling time of 500ms
	 * @param driver
	 * @param title
	 */
	public void waitForTitleContains(WebDriver driver, String title) 
	{
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains(title));
	}
	/**
	 * Here we can change the polling time to desired value
	 * @param driver
	 * @param pollingTime
	 * @param element
	 */
	public void waitForElementToCustom(WebDriver driver, int pollingTime, WebElement element) 
	{
		FluentWait wait=new FluentWait(driver);
		wait.pollingEvery(pollingTime, TimeUnit.SECONDS);
		wait.ignoring(Exception.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	/**
	 * Here we are giving custom timeout
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitAndClick(WebElement element) throws InterruptedException 
	{
		int count=0;
		while (count<10) 
		{
			try 
			{
				element.click();
			} 
			catch (Exception e) 
			{
				Thread.sleep(1000);
				count++;
			}
		}
	}
	/**
	 * To switch from one window to another window
	 * @param driver
	 * @param partialWindow
	 */
	public void switchToWindow(WebDriver driver, String partialWindow) 
	{
		Set<String> set = driver.getWindowHandles();
		Iterator<String> it = set.iterator();
		while (it.hasNext()) 
		{
			String wTle =it.next();
			driver.switchTo().window(wTle);
			String currentWindow = driver.getTitle();
			if (currentWindow.contains(partialWindow)) 
			{
				break;
			}
		}
	}
	/**
	 * Switch from one frame to another frame using index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index) 
	{
		driver.switchTo().frame(index);
	}
	/**
	 * Switch from one frame to another frame using id
	 * @param driver
	 * @param id_attribute
	 */
	public void switchToFrame(WebDriver driver, String id_attribute) 
	{
		driver.switchTo().frame(id_attribute);
	}
	/**
	 * Switch from one frame to another frame using absolute_path
	 * @param driver
	 * @param element
	 */
	public void switchToFrame(WebDriver driver, WebElement element) 
	{
		driver.switchTo().frame(element);
	}
	/**
	 * Switch from any child frame to main frame
	 * @param driver
	 */
	public void switchBackToMainPage(WebDriver driver) 
	{
		driver.switchTo().defaultContent();
	}
	/**
	 * Switch from child to parent frame
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver) 
	{
		driver.switchTo().parentFrame();
	}
	/**
	 * It is used to switch to alert popup and accept
	 * @param driver
	 */
	public void switchToAlertPopUpAndAccept(WebDriver driver) 
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * It is used to switch to alert popup and dismiss 
	 * @param driver
	 */
	public void switchToAlertPopUpAndDismiss(WebDriver driver) 
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * It is used to select dropdown by using index
	 * @param element
	 * @param index
	 */
	public void selectDropdown(WebElement element, int index) 
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	/**
	 * It is used to select dropdown by using value
	 * @param element
	 * @param value
	 */
	public void selectDropdown(WebElement element, String value) 
	{
		Select select=new Select(element);
		select.selectByValue(value);
	}
	/**
	 * It is used to select dropdown by using visible text
	 * @param element
	 * @param vText
	 */
	public void selectDropdownByVText(WebElement element, String vText) 
	{
		Select select=new Select(element);
		select.selectByVisibleText(vText);
	}
	/**
	 * It is used to move the mouse over an element
	 * @param driver
	 * @param element
	 */
	public void mouseOverAnElement(WebDriver driver, WebElement element) 
	{
		Actions action=new Actions(driver);
		action.moveToElement(element).perform();
	}
	/**
	 * it is used to right click on an element
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver, WebElement element) 
	{
		Actions action=new Actions(driver);
		action.contextClick(element).perform();
	}
	/**
	 * It is used to click on Enter button using keyboard actions
	 * @param driver
	 */
	public void clickOnEnterButton(WebDriver driver) 
	{
		Actions action=new Actions(driver);
		action.sendKeys(Keys.ENTER).perform();
	}
	/**
	 * It is used to take a screenshot
	 * @param driver
	 * @param screenShotName
	 * @throws Throwable
	 */
	public void takeScreenShot(WebDriver driver, String screenShotName) throws Throwable 
	{
		TakesScreenshot tss=(TakesScreenshot)driver;
		File src = tss.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\Screenshots\\"+screenShotName+".png");
		Files.copy(src, dst);
	}
	/**
	 * It is used to perform scroll bar action
	 * @param driver
	 */
	public void scrollBarAction(WebDriver driver) 
	{
		JavascriptExecutor j=(JavascriptExecutor)driver;
		j.executeScript("window.scrollBy(0,500)");
	}
}