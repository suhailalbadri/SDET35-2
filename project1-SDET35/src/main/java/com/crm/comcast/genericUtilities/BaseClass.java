package com.crm.comcast.genericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
/**
 * 
 * @author FARHAN SD
 *
 */
import org.testng.annotations.BeforeSuite;

import com.crm.objectRepository.HomePage;
import com.crm.objectRepository.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;
public class BaseClass {
	public static WebDriver sdriver;
	public WebDriver driver;
	public DataBaseUtility dUtil=new DataBaseUtility();
	public ExcelUtility eUtil=new ExcelUtility();
	public FileUtility fUtil=new FileUtility();
	public JavaUtilities jUtil=new JavaUtilities();
	public WebdriverUtility wUtil=new WebdriverUtility();

	/**
	 * Connect to DB
	 */
	@BeforeSuite(groups={"smokeTest", "regressionTest"})
	public void dbConfig()
	{
		dUtil.connectToDB();
	}
	/**
	 * Launch the Browser and enter the URL
	 * @throws Throwable
	 */
	//@Parameters("BROWSER")
	@BeforeClass(groups={"smokeTest", "regressionTest"})
	public void launchTheBrowser() throws Throwable
	{
		String BROW=System.getProperty("browser");
		//String URL=System.getProperty("url");
		//String BROW = fUtil.getPropertyKeyValue("browser");
		String URL = fUtil.getPropertyKeyValue("url");

		if (BROW.equalsIgnoreCase("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if (BROW.equalsIgnoreCase("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		} 
		else 
		{
			driver=new ChromeDriver();
		}
		//Implicit wait
		sdriver=driver;
		wUtil.waitForPageToLoad(driver);
		//maximize the browser
		driver.manage().window().maximize();
		//launch the URL
		sdriver.get(URL);
	}
	/**
	 * Login to the application
	 * @throws Throwable
	 */
	@BeforeMethod(groups={"smokeTest", "regressionTest"})
	public void loginToApplication() throws Throwable
	{
		String UN = fUtil.getPropertyKeyValue("username");
		String PWD = fUtil.getPropertyKeyValue("password");

		LoginPage lPage=new LoginPage(driver);
		lPage.loginToApplication(UN, PWD);
	}
	/**
	 * signout from the application
	 */
	@AfterMethod(groups={"smokeTest", "regressionTest"})
	public void signoutFromApplication()
	{
		HomePage hPage=new HomePage(driver);
		hPage.signoutFromAppli();
	}
	/**
	 * close the browser
	 */
	@AfterClass(groups={"smokeTest", "regressionTest"})
	public void closeTheBrowser()
	{
		driver.close();
	}
	/**
	 * close the DB
	 */
	@AfterSuite(groups={"smokeTest", "regressionTest"})
	public void closeTheDB()
	{
		dUtil.closeDB();
	}
}