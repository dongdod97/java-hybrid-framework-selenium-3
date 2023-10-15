package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.DynamicMethodsNopCommerce;
import commons.PageGeneratorNopCommerce;
import io.qameta.allure.Step;
import pageUIs.nopCommerce.RegisterPageUI;

public class RegisterPageObject extends DynamicMethodsNopCommerce {
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@Step("Enter '{0}' in 'First name' text box")
	public void sendKeysToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, RegisterPageUI.FIRSTNAME_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.FIRSTNAME_TEXTBOX, firstName);
	}

	@Step("Enter '{0}' in 'Last name' text box")
	public void sendKeysToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, RegisterPageUI.LASTNAME_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.LASTNAME_TEXTBOX, lastName);
	}

	@Step("Enter '{0}' in 'Email' text box")
	public void sendKeysToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, RegisterPageUI.EMAIL_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, emailAddress);
	}

	@Step("Enter '{0}' in 'Password' text box")
	public void sendKeysToPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.PASSWORD_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.PASSWORD_TEXTBOX, password);
	}

	@Step("Enter '{0}' in 'Confirm Password' text box")
	public void sendKeysToConfirmPasswordTextbox(String password) {
		waitForElementVisible(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX);
		sendKeysToElement(driver, RegisterPageUI.CONFIRM_PASSWORD_TEXTBOX, password);
	}

	@Step("Click to 'Register' button")
	public void clickToRegisterButton() {
		waitForElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	@Step("Verify registration completed message")
	public String getRegistrationSuccessMessage() {
		waitForElementVisible(driver, RegisterPageUI.REGISTRATION_SUCCESS_MESSAGE);
		return getElementText(driver, RegisterPageUI.REGISTRATION_SUCCESS_MESSAGE);
	}

	@Step("Click to 'Continue' button")
	public HomePageObject clickToContinueButton() {
		waitForElementClickable(driver, RegisterPageUI.CONTINUE_BUTTON);
		clickToElement(driver, RegisterPageUI.CONTINUE_BUTTON);
		return PageGeneratorNopCommerce.getHomePage(driver);
	}

}
