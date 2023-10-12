package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.DynamicMethodsNopCommerce;

public class RewardPointsPageObject extends DynamicMethodsNopCommerce {
	WebDriver driver;

	public RewardPointsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
