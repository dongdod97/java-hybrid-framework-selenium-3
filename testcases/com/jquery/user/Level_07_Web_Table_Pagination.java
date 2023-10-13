package com.jquery.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorJQuery;
import pageObjects.jQuery.WebTablePageObject;

public class Level_07_Web_Table_Pagination extends BaseTest {
	private WebDriver driver;
	private WebTablePageObject webTablePage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, GlobalConstants.WEB_TABLE_PAGINATION_URL);
		webTablePage = PageGeneratorJQuery.getWebTablePage(driver);
	}

	@Test
	public void TC_01() {
		webTablePage.clickToPaginationPageLinkByNumber("13");

		Assert.assertTrue(webTablePage.isPaginationPageLinkActiveByNumber("13"));

		webTablePage.sendKeysToTextboxByLabel("Country", "Malaysia");

		Assert.assertTrue(webTablePage.isRowDisplayedByValues("284790", "Malaysia", "266685", "551471"));

		webTablePage.clickToPaginationPageLinkByNumber("10");

		Assert.assertTrue(webTablePage.isPaginationPageLinkActiveByNumber("10"));

		webTablePage.sendKeysToTextboxByLabel("Country", "India");

		Assert.assertTrue(webTablePage.isRowDisplayedByValues("11727960", "India", "13060130", "24788090"));
	}

	@Test
	public void TC_02() {
		webTablePage.getAllValuesAllPaginationPages();

		webTablePage.getAllColumnValuesAllPaginationPagesByLabel("Country");
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
