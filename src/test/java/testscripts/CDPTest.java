package testscripts;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CDPTest {
	ChromeDriver driver;
	DevTools devTools;
	
	@BeforeMethod
	public void setup()
	{
		driver= new ChromeDriver();
		devTools = driver.getDevTools();
		devTools.createSession(driver.getWindowHandle());
	}
	
	//@Test
	public void deviceModeTest() {
		Map deviceMetrics = new HashMap() {{
			put("width",1000);
			put("height",1600);
			put("deviceScaleFactor",80);
			put("mobile",true);
		}};
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);
		driver.get("https://www.selenium.dev/");
				
	}
	
	@Test
	public void geoLocationTest()
	{
		Map geoMetrics = new HashMap() {{
			put("latitude",35.759575);
			put("longitude",-79.019302);
			put("accuracy",100);
		}};
		driver.executeCdpCommand("Emulation.setGeolocationOverride", geoMetrics);
		driver.get("https://oldnavy.gap.com/stores");
		}
	}


