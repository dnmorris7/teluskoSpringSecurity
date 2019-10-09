package com.davidonus.secureapp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumBasic {

	public static void main(String[] args) {
		
		String driverLocation="C:\\Users\\David\\Desktop\\DevOps2019\\2019\\Spring\\davidonusSpringSecurity\\bin\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", driverLocation);
		WebDriver driver=new ChromeDriver();
		//WebDriver driver = new RemoteWebDriver("http://localhost:9515", DesiredCapabilities.chrome());
		driver.get("http://www.google.com");
	}

}
