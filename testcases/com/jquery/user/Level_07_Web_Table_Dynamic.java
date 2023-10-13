package com.jquery.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorJQuery;
import pageObjects.jQuery.WebTablePageObject;

public class Level_07_Web_Table_Dynamic extends BaseTest {
	private WebDriver driver;
	private WebTablePageObject webTablePage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, GlobalConstants.WEB_TABLE_DYNAMIC_URL);
		webTablePage = PageGeneratorJQuery.getWebTablePage(driver);
	}

	@Test
	public void TC_01() {
		webTablePage.sendKeysToTextboxAtRowAndColumnLabel("1", "Company", "AFC");

		webTablePage.sendKeysToTextboxAtRowAndColumnLabel("2", "Contact Person", "Dong");

		webTablePage.selectCountryDropdownAtRowWithValue("3", "Japan");

		webTablePage.checkToNPOCheckboxAtRow("1");

		webTablePage.sendKeysToTextboxAtRowAndColumnLabel("2", "Order Placed", "123456789");

		webTablePage.setDateToMemberSinceDatePickerAtRow("3", "10/13/2023");

		webTablePage.clickToControlButtonAtRowByTitle("3", "Insert Row Above");

		webTablePage.clickToControlButtonAtRowByTitle("3", "Remove Current Row");

		webTablePage.clickToControlButtonAtRowByTitle("2", "Move Up");

		webTablePage.clickToControlButtonAtRowByTitle("2", "Remove Current Row");

		webTablePage.clickToControlButtonAtRowByTitle("1", "Move Down");

		webTablePage.clickToControlButtonAtRowByTitle("1", "Remove Current Row");
	}

	@Test
	public void TC_02() {
		webTablePage.clickToLoadButton();

		webTablePage.clickToAppendRowButton();

		webTablePage.sendKeysToTextboxAtRowAndColumnLabel("9", "Company", "AFC");

		webTablePage.sendKeysToTextboxAtRowAndColumnLabel("9", "Contact Person", "Dong");

		webTablePage.selectCountryDropdownAtRowWithValue("9", "Japan");

		webTablePage.checkToNPOCheckboxAtRow("9");

		webTablePage.sendKeysToTextboxAtRowAndColumnLabel("9", "Order Placed", "9876543210");

		webTablePage.setDateToMemberSinceDatePickerAtRow("9", "10/13/2023");

		webTablePage.uncheckToNPOCheckboxAtRow("9");

		webTablePage.clickToRemoveLastRowButton();

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
