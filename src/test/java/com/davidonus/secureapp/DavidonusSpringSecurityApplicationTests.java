package com.davidonus.secureapp;
import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.SystemUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;



public class DavidonusSpringSecurityApplicationTests {
	private static WebDriver driver;
	// gather the webdriver location. Selenium won't work unless pointed to the bin
	// folder (in this case).
	static String projectLocation = System.getProperty("user.dir");

	// if Windows, use this line
	// static String mozillaGecko = projectLocation + "\\bin\\geckodriver.exe";
	// if Linux, use this line
	static String chromeGecko = projectLocation + "\\bin\\chromedriver.exe";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {

		// GeckoDriver is required. Check to use correct variant; windows or linux.
		if (SystemUtils.IS_OS_LINUX) {
			chromeGecko = projectLocation + "//bin//chromedriver";
		} else if (SystemUtils.IS_OS_WINDOWS) {
			chromeGecko = projectLocation + "\\bin\\chromedriver.exe";
		}

		Proxy proxy = new Proxy(); 
		//proxy.setHttpProxy("localhost:7070"); 
	//	proxy.setSslProxy("yoururl:portno"); 

		DesiredCapabilities capabilities = DesiredCapabilities.chrome(); 
		capabilities.setCapability("proxy", proxy); 

		System.setProperty("webdriver.chrome.driver", chromeGecko);
		System.out.println(chromeGecko);
		driver = new ChromeDriver();
		//String baseUrl = "http://localhost:7070/login";
		String baseUrl = "google.com";
		driver.get(baseUrl);
		System.out.println(driver.getTitle());
	}
	

	@AfterClass
	public static void tearDownAfterClass() throws Exception {


		Thread.sleep(10000);
		driver.close();

	}

	@Test
	public void contextLoads() {
		System.out.println(driver.getTitle());
	
	}
	
	@Test
	public void testTitle() {
		String expected = "Please sign in";
		String actual = driver.getTitle();

		
		assertEquals(expected, actual);
	}
}
