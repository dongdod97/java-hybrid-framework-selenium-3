package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorNopCommerce;
import io.qameta.allure.Description;
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

public class Level_12_Allure_Patterns extends BaseTest {
	private WebDriver driver;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private CustomerInfoPageObject customerInfoPage;
	private AddressesPageObject addressesPage;
	private OrdersPageObject ordersPage;
	private DownloadableProductsPageObject downloadableProductsPage;
	private BackInStockSubscriptionsPageObject backInStockSubscriptionsPage;
	private RewardPointsPageObject rewardPointsPage;
	private ChangePasswordPageObject changePasswordPage;
	private MyProductReviewsPageObject myProductReviewsPage;
	private String firstName, lastName, emailAddress, password, day, month, year, company;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		homePage = PageGeneratorNopCommerce.getHomePage(driver);

		firstName = "Dong";
		lastName = "Do";
		emailAddress = "dongafc" + getRandomNumber() + "@gmail.com";
		password = "@Selenium3";
		day = "13";
		month = "October";
		year = "1997";
		company = "AFC";
	}

	@Description("Register")
	@Test
	public void User_01_Register() {
		homePage.clickToHeaderLinkByText("Register");
		registerPage = PageGeneratorNopCommerce.getRegisterPage(driver);

		registerPage.checkToRadioButtonByLabel("Male");

		registerPage.sendKeysToTextboxByID("FirstName", firstName);

		registerPage.sendKeysToTextboxByID("LastName", lastName);

		registerPage.selectOptionInDropdownByName("DateOfBirthDay", day);

		registerPage.selectOptionInDropdownByName("DateOfBirthMonth", month);

		registerPage.selectOptionInDropdownByName("DateOfBirthYear", year);

		registerPage.sendKeysToTextboxByID("Email", emailAddress);

		registerPage.sendKeysToTextboxByID("Company", company);

		registerPage.checkToCheckboxByLabel("Newsletter:");

		registerPage.sendKeysToTextboxByID("Password", password);

		registerPage.sendKeysToTextboxByID("ConfirmPassword", password);

		registerPage.clickToButtonByText("Register");

		Assert.assertEquals(registerPage.getRegistrationSuccessMessage(), "Your registration completed.");

		homePage = registerPage.clickToContinueButton();
	}

	@Description("Log in")
	@Test
	public void User_02_Login() {
		homePage.clickToHeaderLinkByText("Log in");
		loginPage = PageGeneratorNopCommerce.getLoginPage(driver);

		loginPage.sendKeysToTextboxByID("Email", emailAddress);

		loginPage.sendKeysToTextboxByID("Password", password);

		loginPage.clickToButtonByText("Log in");
		homePage = PageGeneratorNopCommerce.getHomePage(driver);

		Assert.assertTrue(homePage.isHeaderLinkDisplayedByText("My account"));

		homePage.clickToHeaderLinkByText("My account");
		customerInfoPage = PageGeneratorNopCommerce.getCustomerInfoPage(driver);

		Assert.assertTrue(customerInfoPage.isMyAccountPageTitleDisplayedByPageName("Customer info"));

		Assert.assertTrue(customerInfoPage.isRadioButtonCheckedByLabel("Male"));

		Assert.assertEquals(customerInfoPage.getTextboxValueByID("FirstName"), firstName);

		Assert.assertEquals(customerInfoPage.getTextboxValueByID("LastName"), lastName);

		Assert.assertEquals(customerInfoPage.getSelectedOptionTextInDropdownByName("DateOfBirthDay"), day);

		Assert.assertEquals(customerInfoPage.getSelectedOptionTextInDropdownByName("DateOfBirthMonth"), month);

		Assert.assertEquals(customerInfoPage.getSelectedOptionTextInDropdownByName("DateOfBirthYear"), year);

		Assert.assertEquals(customerInfoPage.getTextboxValueByID("Email"), emailAddress);

		Assert.assertEquals(customerInfoPage.getTextboxValueByID("Company"), company);

		Assert.assertFalse(customerInfoPage.isCheckboxCheckedByLabel("Newsletter:"));
	}

	@Description("My account sidebar")
	@Test
	public void User_03_My_Account_SideBar_Pages() {
		addressesPage = (AddressesPageObject) customerInfoPage.openMyAccountSideBarPageByPageName("Addresses");
		Assert.assertTrue(addressesPage.isMyAccountPageTitleDisplayedByPageName("Addresses"));

		ordersPage = (OrdersPageObject) addressesPage.openMyAccountSideBarPageByPageName("Orders");
		Assert.assertTrue(ordersPage.isMyAccountPageTitleDisplayedByPageName("Orders"));

		downloadableProductsPage = (DownloadableProductsPageObject) ordersPage.openMyAccountSideBarPageByPageName("Downloadable products");
		Assert.assertTrue(downloadableProductsPage.isMyAccountPageTitleDisplayedByPageName("Downloadable products"));

		backInStockSubscriptionsPage = (BackInStockSubscriptionsPageObject) downloadableProductsPage.openMyAccountSideBarPageByPageName("Back in stock subscriptions");
		Assert.assertTrue(backInStockSubscriptionsPage.isMyAccountPageTitleDisplayedByPageName("Back in stock subscriptions"));

		rewardPointsPage = (RewardPointsPageObject) backInStockSubscriptionsPage.openMyAccountSideBarPageByPageName("Reward points");
		Assert.assertTrue(rewardPointsPage.isMyAccountPageTitleDisplayedByPageName("Reward points"));

		changePasswordPage = (ChangePasswordPageObject) rewardPointsPage.openMyAccountSideBarPageByPageName("Change password");
		Assert.assertTrue(changePasswordPage.isMyAccountPageTitleDisplayedByPageName("Change password"));

		myProductReviewsPage = (MyProductReviewsPageObject) changePasswordPage.openMyAccountSideBarPageByPageName("My product reviews");
		Assert.assertTrue(myProductReviewsPage.isMyAccountPageTitleDisplayedByPageName("My product reviews"));

		customerInfoPage = (CustomerInfoPageObject) myProductReviewsPage.openMyAccountSideBarPageByPageName("Customer info");
		Assert.assertFalse(customerInfoPage.isMyAccountPageTitleDisplayedByPageName("Customer info"));
	}

	@Description("Log out")
	@Test
	public void User_04_Logout() {
		customerInfoPage.clickToHeaderLinkByText("Log out");
		homePage = PageGeneratorNopCommerce.getHomePage(driver);

		Assert.assertFalse(homePage.isHeaderLinkDisplayedByText("Register"));

		Assert.assertTrue(homePage.isHeaderLinkDisplayedByText("Log in"));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
