package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.DynamicMethodsNopCommerce;
import commons.PageGeneratorNopCommerce;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.LoginPageUI;

public class LoginPageObject extends DynamicMethodsNopCommerce {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@Step("Enter '{0}' in 'Email' text box")
	public void sendKeysToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, LoginPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	@Step("Enter '{0}' in 'Password' text box")
	public void sendKeysToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, LoginPageUI.PASSWORD_TEXTBOX, password);
	}

	@Step("Click to 'Log in' button")
	public HomePageObject clickToLoginButton() {
		waitForElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorNopCommerce.getHomePage(driver);
	}

}
