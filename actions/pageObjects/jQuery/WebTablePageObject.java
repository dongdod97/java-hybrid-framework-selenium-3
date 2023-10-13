package pageObjects.jQuery;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUIs.jQuery.WebTablePageUI;

public class WebTablePageObject extends BasePage {
	private WebDriver driver;

	public WebTablePageObject(WebDriver driver) {
		this.driver = driver;
	}

	// WebTable Pagination

	public void clickToPaginationPageLinkByNumber(String pageNumber) {
		waitForElementClickable(driver, WebTablePageUI.PAGINATION_PAGE_LINK_BY_NUMBER, pageNumber);
		clickToElement(driver, WebTablePageUI.PAGINATION_PAGE_LINK_BY_NUMBER, pageNumber);
	}

	public boolean isPaginationPageLinkActiveByNumber(String pageNumber) {
		waitForElementVisible(driver, WebTablePageUI.PAGINATION_PAGE_LINK_ACTIVE_BY_NUMBER, pageNumber);
		return isElementDisplayed(driver, WebTablePageUI.PAGINATION_PAGE_LINK_ACTIVE_BY_NUMBER, pageNumber);
	}

	public void sendKeysToTextboxByLabel(String textboxLabel, String keysToSend) {
		waitForElementVisible(driver, WebTablePageUI.TEXTBOX_BY_LABEL, textboxLabel);
		sendKeysToElement(driver, WebTablePageUI.TEXTBOX_BY_LABEL, keysToSend, textboxLabel);
		sendKeyboardToElement(driver, WebTablePageUI.TEXTBOX_BY_LABEL, Keys.ENTER, textboxLabel);
	}

	public boolean isRowDisplayedByValues(String females, String country, String males, String total) {
		waitForElementVisible(driver, WebTablePageUI.ROW_BY_VALUES, females, country, males, total);
		return isElementDisplayed(driver, WebTablePageUI.ROW_BY_VALUES, females, country, males, total);
	}

	public List<String> getAllValuesAllPaginationPages() {
		List<String> allValues = new ArrayList<String>();
		List<WebElement> allPageLinks = getListWebElement(driver, WebTablePageUI.ALL_PAGINATION_PAGE_LINKS);
		for (WebElement pageLink : allPageLinks) {
			pageLink.click();
			List<WebElement> allRows = getListWebElement(driver, WebTablePageUI.ALL_ROWS_EACH_PAGE);
			for (WebElement row : allRows) {
				allValues.add(row.getText());
			}
		}
		for (String value : allValues) {
			System.out.println(value);
		}
		return allValues;
	}

	public List<String> getAllColumnValuesAllPaginationPagesByLabel(String columnLabel) {
		List<String> allColumnValues = new ArrayList<String>();
		List<WebElement> allPageLinks = getListWebElement(driver, WebTablePageUI.ALL_PAGINATION_PAGE_LINKS);
		int columnIndex = getNumberOfElements(driver, WebTablePageUI.COLUMN_INDEX_BY_LABEL, columnLabel) + 1;
		for (WebElement pageLink : allPageLinks) {
			pageLink.click();
			List<WebElement> allRowsValuesOfColumn = getListWebElement(driver, WebTablePageUI.ALL_ROWS_VALUES_BY_COLUMN_INDEX, String.valueOf(columnIndex));
			for (WebElement rowValueOfColumn : allRowsValuesOfColumn) {
				allColumnValues.add(rowValueOfColumn.getText());
			}
		}
		for (String columnValue : allColumnValues) {
			System.out.println(columnValue);
		}
		return allColumnValues;
	}

	// WebTable Dynamic

	public void sendKeysToTextboxAtRowAndColumnLabel(String rowNumber, String columnLabel, String keysToSend) {
		int columnIndex = getNumberOfElements(driver, WebTablePageUI.COLUMN_INDEX_BY_COLUMN_LABEL, columnLabel) + 1;
		waitForElementVisible(driver, WebTablePageUI.TEXTBOX_AT_ROW_AND_COLUMN_INDEX, rowNumber, String.valueOf(columnIndex));
		sendKeysToElement(driver, WebTablePageUI.TEXTBOX_AT_ROW_AND_COLUMN_INDEX, keysToSend, rowNumber, String.valueOf(columnIndex));
	}

	public void selectCountryDropdownAtRowWithValue(String rowNumber, String optionValue) {
		waitForElementClickable(driver, WebTablePageUI.DROPDOWN_AT_ROW, rowNumber);
		selectOptionInDefaultDropdown(driver, WebTablePageUI.DROPDOWN_AT_ROW, optionValue, rowNumber);
	}

	public void checkToNPOCheckboxAtRow(String rowNumber) {
		waitForElementClickable(driver, WebTablePageUI.CHECKBOX_AT_ROW, rowNumber);
		checkToDefaultCheckboxOrRadioButton(driver, WebTablePageUI.CHECKBOX_AT_ROW, rowNumber);
	}

	public void uncheckToNPOCheckboxAtRow(String rowNumber) {
		waitForElementClickable(driver, WebTablePageUI.CHECKBOX_AT_ROW, rowNumber);
		uncheckToDefaultCheckbox(driver, WebTablePageUI.CHECKBOX_AT_ROW, rowNumber);
	}

	public void setDateToMemberSinceDatePickerAtRow(String rowNumber, String dateValue) {
		waitForElementVisible(driver, WebTablePageUI.DATE_PICKER_AT_ROW, rowNumber);
		removeElementAttributeInDOMByJS(driver, WebTablePageUI.DATE_PICKER_AT_ROW, "type", rowNumber);
		sendKeysToElement(driver, WebTablePageUI.DATE_PICKER_AT_ROW, dateValue, rowNumber);
	}

	public void clickToControlButtonAtRowByTitle(String rowNumber, String buttonTitle) {
		waitForElementClickable(driver, WebTablePageUI.CONTROL_BUTTON_AT_ROW_BY_TITLE, rowNumber, buttonTitle);
		clickToElement(driver, WebTablePageUI.CONTROL_BUTTON_AT_ROW_BY_TITLE, rowNumber, buttonTitle);
	}

	public void clickToLoadButton() {
		waitForElementClickable(driver, WebTablePageUI.LOAD_BUTTON);
		clickToElement(driver, WebTablePageUI.LOAD_BUTTON);
	}

	public void clickToAppendRowButton() {
		waitForElementClickable(driver, WebTablePageUI.APPEND_ROW_BUTTON);
		clickToElement(driver, WebTablePageUI.APPEND_ROW_BUTTON);
	}

	public void clickToRemoveLastRowButton() {
		waitForElementClickable(driver, WebTablePageUI.REMOVE_LAST_ROW_BUTTON);
		clickToElement(driver, WebTablePageUI.REMOVE_LAST_ROW_BUTTON);
	}

}
