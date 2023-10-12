package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.DynamicMethodsNopCommerce;
import commons.PageGeneratorNopCommerce;
import pageUIs.nopCommerce.HomePageUI;

public class HomePageObject extends DynamicMethodsNopCommerce {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public RegisterPageObject clickToRegisterHeaderLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_HEADER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_HEADER_LINK);
		return PageGeneratorNopCommerce.getRegisterPage(driver);
	}

	public LoginPageObject clickToLoginHeaderLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_HEADER_LINK);
		clickToElement(driver, HomePageUI.LOGIN_HEADER_LINK);
		return PageGeneratorNopCommerce.getLoginPage(driver);
	}

	public boolean isMyAccountHeaderLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_HEADER_LINK);
		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_HEADER_LINK);
	}

	public void clickToLogoutHeaderLink() {
		waitForElementClickable(driver, HomePageUI.LOGOUT_HEADER_LINK);
		clickToElement(driver, HomePageUI.LOGOUT_HEADER_LINK);
	}

}
