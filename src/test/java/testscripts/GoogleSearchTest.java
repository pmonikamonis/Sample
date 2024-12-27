package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleSearchTest {
	WebDriver driver;
	@BeforeTest
	//@BeforeMethod
	public void setup()
	{
		driver= new ChromeDriver();
	}
	
	@AfterTest
	//@AfterMethod
	public void teardown()
	{
		driver.close();	
	}
	
	@Test(priority=2)	
	public void seleniumsearch() throws InterruptedException
	{
		
		driver.get("https://www.google.com");
		WebElement search = driver.findElement(By.tagName("textarea"));
		search.sendKeys("Selenium Tutorial");
		search.submit();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(), "Selenium Tutorial - Google Search");
	
		
	}
	
	@Test(enabled = false)
	public void javasearch() throws InterruptedException
	{
		
		driver.get("https://www.google.com");
		WebElement search = driver.findElement(By.tagName("textarea"));
		search.sendKeys("Java Tutorial");
		search.submit();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(), "Java Tutorial - Google Search");
	}
	
	@Test(priority=1)
	public void cucumbersearch() throws InterruptedException
	{
		
		driver.get("https://www.google.com");
		WebElement search = driver.findElement(By.tagName("textarea"));
		search.sendKeys("Cucumber Tutorial");
		search.submit();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(), "Cucumber Tutorial - Google Search");
	}

	@Test(enabled = false)
	public void appiumsearch() throws InterruptedException
	{
		
		driver.get("https://www.google.com");
		WebElement search = driver.findElement(By.tagName("textarea"));
		search.sendKeys("Appium Tutorial");
		search.submit();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(), "Appium Tutorial - Google Search");
	}

}
