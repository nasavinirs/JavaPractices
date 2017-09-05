package com.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Demo1 {

	public static void main(String args[]) {
		// System.setProperty("webdriver.chrome.driver",
		// System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		// WebDriver driver = new ChromeDriver();

		//System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/drivers/IEDriverServer.exe");
		//WebDriver driver = new InternetExplorerDriver();
		
		System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
		DesiredCapabilities desiredCapabilities = DesiredCapabilities.firefox();
		//desiredCapabilities.setCapability("marionette", true); 
		WebDriver driver =  new FirefoxDriver(desiredCapabilities);
		
		driver.get("http://www.google.com");
		
		driver.quit();
	}
}
