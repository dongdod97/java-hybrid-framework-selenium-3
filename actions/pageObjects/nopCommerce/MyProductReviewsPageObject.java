package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.DynamicMethodsNopCommerce;

public class MyProductReviewsPageObject extends DynamicMethodsNopCommerce {
	WebDriver driver;

	public MyProductReviewsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
