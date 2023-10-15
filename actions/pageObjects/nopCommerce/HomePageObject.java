package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.DynamicMethodsNopCommerce;
import commons.PageGeneratorNopCommerce;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.HomePageUI;

public class HomePageObject extends DynamicMethodsNopCommerce {
	private WebDriver driver;

	public HomePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@Step("Click to 'Register' header link")
	public RegisterPageObject clickToRegisterHeaderLink() {
		waitForElementClickable(driver, HomePageUI.REGISTER_HEADER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_HEADER_LINK);
		return PageGeneratorNopCommerce.getRegisterPage(driver);
	}

	@Step("Click to 'Log in' header link")
	public LoginPageObject clickToLoginHeaderLink() {
		waitForElementClickable(driver, HomePageUI.LOGIN_HEADER_LINK);
		clickToElement(driver, HomePageUI.LOGIN_HEADER_LINK);
		return PageGeneratorNopCommerce.getLoginPage(driver);
	}

	@Step("Verify 'My account' header link is displayed")
	public boolean isMyAccountHeaderLinkDisplayed() {
		waitForElementVisible(driver, HomePageUI.MY_ACCOUNT_HEADER_LINK);
		return isElementDisplayed(driver, HomePageUI.MY_ACCOUNT_HEADER_LINK);
	}

	@Step("Click to 'Log out' header link")
	public void clickToLogoutHeaderLink() {
		waitForElementClickable(driver, HomePageUI.LOGOUT_HEADER_LINK);
		clickToElement(driver, HomePageUI.LOGOUT_HEADER_LINK);
	}

}
