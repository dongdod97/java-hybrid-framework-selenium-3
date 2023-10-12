package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.DynamicMethodsNopCommerce;

public class BackInStockSubscriptionsPageObject extends DynamicMethodsNopCommerce {
	WebDriver driver;

	public BackInStockSubscriptionsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
