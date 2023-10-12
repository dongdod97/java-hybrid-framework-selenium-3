package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.DynamicMethodsNopCommerce;

public class ChangePasswordPageObject extends DynamicMethodsNopCommerce {
	WebDriver driver;

	public ChangePasswordPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
