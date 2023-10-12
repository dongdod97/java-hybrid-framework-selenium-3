package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.nopCommerce.DynamicElementsNopCommerce;

public class DynamicMethodsNopCommerce extends BasePage {
	private WebDriver driver;

	public DynamicMethodsNopCommerce(WebDriver driver) {
		this.driver = driver;
	}

	// Header link

	public void clickToHeaderLinkByText(String linkText) {
		waitForElementClickable(driver, DynamicElementsNopCommerce.HEADER_LINK_BY_TEXT, linkText);
		clickToElement(driver, DynamicElementsNopCommerce.HEADER_LINK_BY_TEXT, linkText);
	}

	public boolean isHeaderLinkDisplayedByText(String linkText) {
		waitForElementVisible(driver, DynamicElementsNopCommerce.HEADER_LINK_BY_TEXT, linkText);
		return isElementDisplayed(driver, DynamicElementsNopCommerce.HEADER_LINK_BY_TEXT, linkText);
	}

	// Radio button

	public void checkToRadioButtonByLabel(String radioLabel) {
		waitForElementClickable(driver, DynamicElementsNopCommerce.RADIO_BUTTON_BY_LABEL, radioLabel);
		checkToDefaultCheckboxOrRadioButton(driver, DynamicElementsNopCommerce.RADIO_BUTTON_BY_LABEL, radioLabel);
	}

	public boolean isRadioButtonCheckedByLabel(String radioLabel) {
		waitForElementVisible(driver, DynamicElementsNopCommerce.RADIO_BUTTON_BY_LABEL, radioLabel);
		return isElementSelected(driver, DynamicElementsNopCommerce.RADIO_BUTTON_BY_LABEL, radioLabel);
	}

	// Text-box

	public void sendKeysToTextboxByID(String textboxID, String keysToSend) {
		waitForElementVisible(driver, DynamicElementsNopCommerce.TEXTBOX_BY_ID, textboxID);
		sendKeysToElement(driver, DynamicElementsNopCommerce.TEXTBOX_BY_ID, keysToSend, textboxID);
	}

	public String getTextboxValueByID(String textboxID) {
		waitForElementVisible(driver, DynamicElementsNopCommerce.TEXTBOX_BY_ID, textboxID);
		return getElementAttributeValue(driver, DynamicElementsNopCommerce.TEXTBOX_BY_ID, "value", textboxID);
	}

	// Drop-down

	public void selectOptionInDropdownByName(String dropdownName, String optionValue) {
		waitForElementClickable(driver, DynamicElementsNopCommerce.DROPDOWN_BY_NAME, dropdownName);
		selectOptionInDefaultDropdown(driver, DynamicElementsNopCommerce.DROPDOWN_BY_NAME, optionValue, dropdownName);
	}

	public String getSelectedOptionTextInDropdownByName(String dropdownName) {
		waitForElementVisible(driver, DynamicElementsNopCommerce.DROPDOWN_BY_NAME, dropdownName);
		return getSelectedOptionTextInDefaultDropdown(driver, DynamicElementsNopCommerce.DROPDOWN_BY_NAME, dropdownName);
	}

	// Check-box

	public void checkToCheckboxByLabel(String checkboxLabel) {
		waitForElementClickable(driver, DynamicElementsNopCommerce.CHECKBOX_BY_LABEL, checkboxLabel);
		checkToDefaultCheckboxOrRadioButton(driver, DynamicElementsNopCommerce.CHECKBOX_BY_LABEL, checkboxLabel);
	}

	public boolean isCheckboxCheckedByLabel(String checkboxLabel) {
		waitForElementVisible(driver, DynamicElementsNopCommerce.CHECKBOX_BY_LABEL, checkboxLabel);
		return isElementSelected(driver, DynamicElementsNopCommerce.CHECKBOX_BY_LABEL, checkboxLabel);
	}

	// Button

	public void clickToButtonByText(String buttonText) {
		waitForElementClickable(driver, DynamicElementsNopCommerce.BUTTON_BY_TEXT, buttonText);
		clickToElement(driver, DynamicElementsNopCommerce.BUTTON_BY_TEXT, buttonText);
	}

	// My account side-bar pages

	public DynamicMethodsNopCommerce openMyAccountSideBarPageByPageName(String pageName) {
		waitForElementClickable(driver, DynamicElementsNopCommerce.MY_ACCOUNT_SIDEBAR_PAGE_BY_PAGE_NAME, pageName);
		clickToElement(driver, DynamicElementsNopCommerce.MY_ACCOUNT_SIDEBAR_PAGE_BY_PAGE_NAME, pageName);
		switch (pageName) {
		case "Customer info":
			return PageGeneratorNopCommerce.getCustomerInfoPage(driver);
		case "Addresses":
			return PageGeneratorNopCommerce.getAddressesPage(driver);
		case "Orders":
			return PageGeneratorNopCommerce.getOrdersPage(driver);
		case "Downloadable products":
			return PageGeneratorNopCommerce.getDownloadableProductsPage(driver);
		case "Back in stock subscriptions":
			return PageGeneratorNopCommerce.getBackInStockSubscriptionsPage(driver);
		case "Reward points":
			return PageGeneratorNopCommerce.getRewardPointsPage(driver);
		case "Change password":
			return PageGeneratorNopCommerce.getChangePasswordPage(driver);
		case "My product reviews":
			return PageGeneratorNopCommerce.getMyProductReviewsPage(driver);
		default:
			throw new RuntimeException("Invalid page name at My Account sidebar.");
		}
	}

	// My account page title

	public boolean isMyAccountPageTitleDisplayedByPageName(String pageName) {
		waitForElementVisible(driver, DynamicElementsNopCommerce.MY_ACCOUNT_PAGE_TITLE_BY_PAGE_NAME, pageName);
		return isElementDisplayed(driver, DynamicElementsNopCommerce.MY_ACCOUNT_PAGE_TITLE_BY_PAGE_NAME, pageName);
	}

}
