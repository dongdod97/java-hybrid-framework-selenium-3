package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.DynamicMethodsNopCommerce;

public class AddressesPageObject extends DynamicMethodsNopCommerce {
	WebDriver driver;

	public AddressesPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
