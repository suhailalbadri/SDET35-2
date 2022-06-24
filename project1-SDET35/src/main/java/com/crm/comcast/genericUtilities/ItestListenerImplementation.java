package com.crm.comcast.genericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ItestListenerImplementation implements ITestListener{

	ExtentReports report;
	ExtentTest test;
	
	public void onTestStart(ITestResult result) {
		test=report.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		test.log(Status.PASS, result.getMethod().getMethodName());
		test.log(Status.PASS, result.getThrowable());
	}

	public void onTestFailure(ITestResult result) {
		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
		
		try {
			String screenShotName = WebdriverUtility.takeScreenShot(BaseClass.sdriver,result.getMethod().getMethodName());
			test.addScreenCaptureFromPath(screenShotName);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
//		String testName=result.getMethod().getMethodName();
//		System.out.println(testName+" =====Executing===== ");
//		
//		EventFiringWebDriver edriver=new EventFiringWebDriver(BaseClass.sdriver);
//		File src=edriver.getScreenshotAs(OutputType.FILE);
//		try {
//			FileUtils.copyFile(src, new File("./Screenshots/"+testName+".png"));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		ExtentSparkReporter spark=new ExtentSparkReporter("./ExtentReports/report.html");
		
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("FrameworkExtentReport");
		spark.config().setDocumentTitle("Suhail's document");
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Created By: ", "Suhail");
		report.setSystemInfo("Reviewed By: ", "Sanjay");
		report.setSystemInfo("Approved By: ", "Deepak");
		report.setSystemInfo("Platform: ", "Windows 11");
		report.setSystemInfo("Srever Name: ", "Apache TomCat");
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		report.flush();
	}
	
}