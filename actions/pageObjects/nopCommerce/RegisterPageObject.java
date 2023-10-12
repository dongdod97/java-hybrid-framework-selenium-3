package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.DynamicMethodsNopCommerce;
import commons.PageGeneratorNopCommerce;
import pageUIs.nopCommerce.RegisterPageUI;

public class RegisterPageObject extends DynamicMethodsNopCommerce {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void sendKeysToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
	}

	public void sendKeysToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastName);
	}

	public void sendKeysToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	public void sendKeysToPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	public void sendKeysToConfirmPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	public String getRegistrationSuccessMessage() {
		waitForElementVisible(driver, RegisterPageUI.REGISTRATION_SUCCESS_MESSAGE);
		return getElementText(driver, RegisterPageUI.REGISTRATION_SUCCESS_MESSAGE);
	}

	public HomePageObject clickToContinueButton() {
		waitForElementClickable(driver, RegisterPageUI.CONTINUE_BUTTON);
		clickToElement(driver, RegisterPageUI.CONTINUE_BUTTON);
		return PageGeneratorNopCommerce.getHomePage(driver);
	}

}
