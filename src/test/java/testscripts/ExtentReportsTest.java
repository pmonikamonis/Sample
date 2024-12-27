package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import commonUtils.Utility;

public class ExtentReportsTest {
	
	WebDriver driver;
	ExtentReports extentReports;
	ExtentSparkReporter spark;
	ExtentTest extentTest;
	
	@BeforeTest
	public void setupExtent()
	{
		extentReports = new ExtentReports();
		spark= new ExtentSparkReporter("test-output/SparkReport.html")
				.viewConfigurer()
				.viewOrder()
				.as(new ViewName[] {
						ViewName.DASHBOARD,
						ViewName.TEST,
						ViewName.AUTHOR,
						ViewName.DEVICE,
						ViewName.LOG
				}).apply();
		extentReports.attachReporter(spark);
	}
	//@BeforeTest
	@BeforeMethod
	public void setup()
	{
		driver= new ChromeDriver();
	}
	
	@AfterTest
	public void quitExtent()
	{
		extentReports.flush();
		
	}
	
	
	@AfterMethod
	public void teardown(ITestResult result)
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			extentTest.assignAuthor("AutomationTester1")
			.assignCategory("Regression")
			.assignDevice(System.getProperty("os.name"))
			.assignDevice(System.getProperty("os.version"));
			extentTest.log(Status.FAIL, result.getThrowable().getMessage());
			String strpath = Utility.getScreenshotPath(driver);
			extentTest.fail(MediaEntityBuilder.createScreenCaptureFromPath(strpath).build());
		}
		driver.close();	
	}
	
	@Test(retryAnalyzer = RetryAnalyzerSample.class)
	//@Test(priority=2)	
	public void seleniumsearch() throws InterruptedException
	{
		extentTest= extentReports.createTest("Selenium Search Test");
		driver.get("https://www.google.com");
		WebElement search = driver.findElement(By.tagName("textarea"));
		search.sendKeys("Selenium Tutorial");
		search.submit();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(), "java Tutorial - Google Search");
	
		
	}
	@Test
	//@Test(enabled = false)
	public void javasearch() throws InterruptedException
	{
		extentTest= extentReports.createTest("Selenium Search Test");
		driver.get("https://www.google.com");
		WebElement search = driver.findElement(By.tagName("textarea"));
		search.sendKeys("Java Tutorial");
		search.submit();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(), "Java Tutorial - Google Search");
	}
	
	//@Test(priority=1)
	public void cucumbersearch() throws InterruptedException
	{
		extentTest= extentReports.createTest("Selenium Search Test");
		driver.get("https://www.google.com");
		WebElement search = driver.findElement(By.tagName("textarea"));
		search.sendKeys("Cucumber Tutorial");
		search.submit();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(), "Cucumber Tutorial - Google Search");
	}

	
	//@Test(enabled = false)
	public void appiumsearch() throws InterruptedException
	{
		extentTest= extentReports.createTest("Selenium Search Test");
		driver.get("https://www.google.com");
		WebElement search = driver.findElement(By.tagName("textarea"));
		search.sendKeys("Appium Tutorial");
		search.submit();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(), "Appium Tutorial - Google Search");
	}


}
