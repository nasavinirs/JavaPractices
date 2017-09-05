package com.selenium.exs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WebDriverWaitsEx1 {
	

	@Test
	public void alertTest() throws Exception {

		String baseUrl = "http://toolsqa.com/automation-practice-switch-windows/";

		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
				
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(baseUrl);
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		WebElement alertButton = driver.findElement(By.id("alert"));
				
		alertButton.click();
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
				
		Assert.assertEquals(alert.getText(), "Knowledge increases by sharing but not by saving. Please share this website with your friends and in your organization.");
		
		Thread.sleep(3000);
		
		alert.accept();
		
		driver.quit();
	}

}
