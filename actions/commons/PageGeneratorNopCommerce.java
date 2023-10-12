package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.nopCommerce.AddressesPageObject;
import pageObjects.nopCommerce.BackInStockSubscriptionsPageObject;
import pageObjects.nopCommerce.ChangePasswordPageObject;
import pageObjects.nopCommerce.CustomerInfoPageObject;
import pageObjects.nopCommerce.DownloadableProductsPageObject;
import pageObjects.nopCommerce.HomePageObject;
import pageObjects.nopCommerce.LoginPageObject;
import pageObjects.nopCommerce.MyProductReviewsPageObject;
import pageObjects.nopCommerce.OrdersPageObject;
import pageObjects.nopCommerce.RegisterPageObject;
import pageObjects.nopCommerce.RewardPointsPageObject;

public class PageGeneratorNopCommerce {

	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}

	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}

	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}

	public static CustomerInfoPageObject getCustomerInfoPage(WebDriver driver) {
		return new CustomerInfoPageObject(driver);
	}

	public static AddressesPageObject getAddressesPage(WebDriver driver) {
		return new AddressesPageObject(driver);
	}

	public static OrdersPageObject getOrdersPage(WebDriver driver) {
		return new OrdersPageObject(driver);
	}

	public static DownloadableProductsPageObject getDownloadableProductsPage(WebDriver driver) {
		return new DownloadableProductsPageObject(driver);
	}

	public static BackInStockSubscriptionsPageObject getBackInStockSubscriptionsPage(WebDriver driver) {
		return new BackInStockSubscriptionsPageObject(driver);
	}

	public static RewardPointsPageObject getRewardPointsPage(WebDriver driver) {
		return new RewardPointsPageObject(driver);
	}

	public static ChangePasswordPageObject getChangePasswordPage(WebDriver driver) {
		return new ChangePasswordPageObject(driver);
	}

	public static MyProductReviewsPageObject getMyProductReviewsPage(WebDriver driver) {
		return new MyProductReviewsPageObject(driver);
	}

}
