package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.DynamicMethodsNopCommerce;

public class OrdersPageObject extends DynamicMethodsNopCommerce {
	WebDriver driver;

	public OrdersPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
