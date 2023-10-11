package com.nopcommerce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_02_Selenium_Wrapper extends BasePage {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	String emailAddress;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://demo.nopcommerce.com/");

		emailAddress = "dongafc" + getRandomNumber() + "@gmail.com";
	}

	@Test
	public void User_01_Register() {
		clickToElement(driver, "//a[@class='ico-register']");

		sendKeysToElement(driver, "//input[@id='FirstName']", "Dong");

		sendKeysToElement(driver, "//input[@id='LastName']", "Do");

		sendKeysToElement(driver, "//input[@id='Email']", emailAddress);

		sendKeysToElement(driver, "//input[@id='Password']", "@Selenium3");

		sendKeysToElement(driver, "//input[@id='ConfirmPassword']", "@Selenium3");

		clickToElement(driver, "//button[@id='register-button']");

		Assert.assertEquals(getElementText(driver, "//div[@class='result']"), "Your registration completed");

		clickToElement(driver, "//div[@class='buttons']/a[text()='Continue']");
	}

	@Test
	public void User_02_Login() {
		clickToElement(driver, "//a[@class='ico-login']");

		sendKeysToElement(driver, "//input[@id='Email']", emailAddress);

		sendKeysToElement(driver, "//input[@id='Password']", "@Selenium3");

		clickToElement(driver, "//div[@class='buttons']/button[text()='Log in']");

		Assert.assertTrue(isElementDisplayed(driver, "//a[@class='ico-account']"));

		clickToElement(driver, "//a[@class='ico-logout']");

		Assert.assertTrue(isElementDisplayed(driver, "//a[@class='ico-register']"));

		Assert.assertTrue(isElementDisplayed(driver, "//a[@class='ico-login']"));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	public int getRandomNumber() {
		return new Random().nextInt(99999);
	}

}
