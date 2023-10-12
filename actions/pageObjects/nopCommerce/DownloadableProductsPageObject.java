package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.DynamicMethodsNopCommerce;

public class DownloadableProductsPageObject extends DynamicMethodsNopCommerce {
	WebDriver driver;

	public DownloadableProductsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
