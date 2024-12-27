package ParllellScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class SampleTestOne {
	WebDriver driver;
	@Test(groups="featureOne")
	public void testOne()
	{
		long id = Thread.currentThread().getId();
		System.out.println("Test1 in SampleOne"+id);
	}
	//@Test(groups="featureOne")
	@Test(invocationCount=6, threadPoolSize=2, timeOut=10000)
	public void testTwo()
	{
		long id = Thread.currentThread().getId();
		System.out.println("Test2 in SampleOne"+id);
		driver=new EdgeDriver();
	}
	@Test(groups="featureTwo")
	public void testthree()
	{
		long id = Thread.currentThread().getId();
		System.out.println("Test3 in SampleOne"+id);
	}
	@Test(groups="featureThree")
	public void testFour()
	{
		long id = Thread.currentThread().getId();
		System.out.println("Test4 in SampleOne"+id);
	}

}
