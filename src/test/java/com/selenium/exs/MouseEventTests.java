package com.selenium.exs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MouseEventTests {

	public static void main(String[] args) {

		String baseUrl = "http://newtours.demoaut.com/";
		// System.setProperty("webdriver.firefox.marionette",System.getenv(arg0)
		// + "geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\drivers\\geckodriver.exe");
		// System.setProperty("webdriver.chrome.driver",
		// System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");
		WebDriver driver = new FirefoxDriver();

		try {
			driver.get(baseUrl);
			WebElement link_Home = driver.findElement(By.linkText("Home"));
			WebElement td_Home = driver.findElement(By.xpath("//html/body/div" + "/table/tbody/tr/td"
					+ "/table/tbody/tr/td" + "/table/tbody/tr/td" + "/table/tbody/tr"));

			Actions builder = new Actions(driver);
			Action mouseOverHome = builder.moveToElement(link_Home).build();

			String bgColor = td_Home.getCssValue("background-color");
			System.out.println("Before hover: " + bgColor);
			mouseOverHome.perform();
			bgColor = td_Home.getCssValue("background-color");
			System.out.println("After hover: " + bgColor);
			Thread.sleep(5000);
		} catch (Exception ex) {
			System.out.println("Exception occured : " + ex.getMessage());
		}
		finally {
			driver.quit();
		}

	}

}
