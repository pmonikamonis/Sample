package testscripts;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.net.MalformedURLException;
import java.net.URL;


import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

@Test
public class RemoteWebDriverTest {
	WebDriver driver;
	
	@Test
	public void test() throws MalformedURLException, InterruptedException
	{
		ChromeOptions options = new ChromeOptions();
		//options.setCapability("platformName", Platform.WINDOWS);
		options.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
		
		String strHub= "http://10.0.12.19:5555";
		driver = new RemoteWebDriver(new URL(strHub), options);
		
		driver.get("https://www.google.com");
		WebElement search = driver.findElement(By.tagName("textarea"));
		search.sendKeys("Java Tutorial");
		search.submit();
		Thread.sleep(2000);
		System.out.println("page Title is ..."+driver.getTitle());
		AssertJUnit.assertEquals(driver.getTitle(), "Java Tutorial - Google Search");
	}

}
