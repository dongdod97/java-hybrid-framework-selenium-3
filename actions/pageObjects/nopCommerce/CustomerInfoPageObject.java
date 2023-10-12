package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.DynamicMethodsNopCommerce;

public class CustomerInfoPageObject extends DynamicMethodsNopCommerce {
	WebDriver driver;

	public CustomerInfoPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
