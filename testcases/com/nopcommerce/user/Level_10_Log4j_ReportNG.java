package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorNopCommerce;
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

public class Level_10_Log4j_ReportNG extends BaseTest {
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
	private String firstName, lastName, emailAddress, password, day, month, year, company, radioValue;

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
		radioValue = "Male";
	}

	@Test
	public void User_01_Register() {
		log.info("User_01_Register - Step 01: Click to 'Register' header link");
		homePage.clickToHeaderLinkByText("Register");
		registerPage = PageGeneratorNopCommerce.getRegisterPage(driver);

		log.info("User_01_Register - Step 02: Check to '" + radioValue + "' radio button");
		registerPage.checkToRadioButtonByLabel(radioValue);

		log.info("User_01_Register - Step 03: Enter '" + firstName + "' in 'First name' text box");
		registerPage.sendKeysToTextboxByID("FirstName", firstName);

		log.info("User_01_Register - Step 04: Enter '" + lastName + "' in 'Last name' text box");
		registerPage.sendKeysToTextboxByID("LastName", lastName);

		log.info("User_01_Register - Step 05: Select '" + day + "' at 'Day' dropdown");
		registerPage.selectOptionInDropdownByName("DateOfBirthDay", day);

		log.info("User_01_Register - Step 06: Select '" + month + "' at 'Month' dropdown");
		registerPage.selectOptionInDropdownByName("DateOfBirthMonth", month);

		log.info("User_01_Register - Step 07: Select '" + year + "' at 'Year' dropdown");
		registerPage.selectOptionInDropdownByName("DateOfBirthYear", year);

		log.info("User_01_Register - Step 08: Enter '" + emailAddress + "' in 'Email' text box");
		registerPage.sendKeysToTextboxByID("Email", emailAddress);

		log.info("User_01_Register - Step 09: Enter '" + company + "' in 'Company' text box");
		registerPage.sendKeysToTextboxByID("Company", company);

		log.info("User_01_Register - Step 10: Check to 'Newsletter' checkbox");
		registerPage.checkToCheckboxByLabel("Newsletter:");

		log.info("User_01_Register - Step 11: Enter '" + password + "' in 'Password' text box");
		registerPage.sendKeysToTextboxByID("Password", password);

		log.info("User_01_Register - Step 12: Enter '" + password + "' in 'Confirm Password' text box");
		registerPage.sendKeysToTextboxByID("ConfirmPassword", password);

		log.info("User_01_Register - Step 13: Click to 'Register' button");
		registerPage.clickToButtonByText("Register");

		log.info("User_01_Register - Step 14: Verify registration completed message");
		Assert.assertEquals(registerPage.getRegistrationSuccessMessage(), "Your registration completed.");

		log.info("User_01_Register - Step 15: Click to 'Continue' button");
		homePage = registerPage.clickToContinueButton();
	}

	@Test
	public void User_02_Login() {
		log.info("User_02_Login - Step 01: Click to 'Log in' header link");
		homePage.clickToHeaderLinkByText("Log in");
		loginPage = PageGeneratorNopCommerce.getLoginPage(driver);

		log.info("User_02_Login - Step 02: Enter '" + emailAddress + "' in 'Email' text box");
		loginPage.sendKeysToTextboxByID("Email", emailAddress);

		log.info("User_02_Login - Step 03: Enter '" + password + "' in 'Password' text box");
		loginPage.sendKeysToTextboxByID("Password", password);

		log.info("User_02_Login - Step 04: Click to 'Log in' button");
		loginPage.clickToButtonByText("Log in");
		homePage = PageGeneratorNopCommerce.getHomePage(driver);

		log.info("User_02_Login - Step 05: Verify 'My account' header link is displayed");
		Assert.assertTrue(homePage.isHeaderLinkDisplayedByText("My account"));

		log.info("User_02_Login - Step 06: Click to 'My account' header link");
		homePage.clickToHeaderLinkByText("My account");
		customerInfoPage = PageGeneratorNopCommerce.getCustomerInfoPage(driver);

		log.info("User_02_Login - Step 07: Verify 'My account - Customer info' page title is displayed");
		Assert.assertTrue(customerInfoPage.isMyAccountPageTitleDisplayedByPageName("Customer info"));

		log.info("User_02_Login - Step 08: Verify '" + radioValue + "' radio button is checked");
		Assert.assertTrue(customerInfoPage.isRadioButtonCheckedByLabel(radioValue));

		log.info("User_02_Login - Step 09: Verify 'First name' text box value is '" + firstName + "'");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID("FirstName"), firstName);

		log.info("User_02_Login - Step 10: Verify 'Last name' text box value is '" + lastName + "'");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID("LastName"), lastName);

		log.info("User_02_Login - Step 11: Verify 'Day' dropdown value is '" + day + "'");
		Assert.assertEquals(customerInfoPage.getSelectedOptionTextInDropdownByName("DateOfBirthDay"), day);

		log.info("User_02_Login - Step 12: Verify 'Month' dropdown value is '" + month + "'");
		Assert.assertEquals(customerInfoPage.getSelectedOptionTextInDropdownByName("DateOfBirthMonth"), month);

		log.info("User_02_Login - Step 13: Verify 'Year' dropdown value is '" + year + "'");
		Assert.assertEquals(customerInfoPage.getSelectedOptionTextInDropdownByName("DateOfBirthYear"), year);

		log.info("User_02_Login - Step 14: Verify 'Email' text box value is '" + emailAddress + "'");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID("Email"), emailAddress);

		log.info("User_02_Login - Step 15: Verify 'Company' text box value is '" + company + "'");
		Assert.assertEquals(customerInfoPage.getTextboxValueByID("Company"), company);

		log.info("User_02_Login - Step 16: Verify 'Newsletter' check box is checked");
		Assert.assertFalse(customerInfoPage.isCheckboxCheckedByLabel("Newsletter:"));
	}

	@Test
	public void User_03_My_Account_SideBar_Pages() {
		log.info("User_03_My_Account_SideBar_Pages - Step 01: Open 'Addresses' page in 'My account' sidebar");
		addressesPage = (AddressesPageObject) customerInfoPage.openMyAccountSideBarPageByPageName("Addresses");

		log.info("User_03_My_Account_SideBar_Pages - Step 02: Verify 'My account - Addresses' page title is displayed");
		Assert.assertTrue(addressesPage.isMyAccountPageTitleDisplayedByPageName("Addresses"));

		log.info("User_03_My_Account_SideBar_Pages - Step 03: Open 'Orders' page in 'My account' sidebar");
		ordersPage = (OrdersPageObject) addressesPage.openMyAccountSideBarPageByPageName("Orders");

		log.info("User_03_My_Account_SideBar_Pages - Step 04: Verify 'My account - Orders' page title is displayed");
		Assert.assertTrue(ordersPage.isMyAccountPageTitleDisplayedByPageName("Orders"));

		log.info("User_03_My_Account_SideBar_Pages - Step 05: Open 'Downloadable products' page in 'My account' sidebar");
		downloadableProductsPage = (DownloadableProductsPageObject) ordersPage.openMyAccountSideBarPageByPageName("Downloadable products");

		log.info("User_03_My_Account_SideBar_Pages - Step 06: Verify 'My account - Downloadable products' page title is displayed");
		Assert.assertTrue(downloadableProductsPage.isMyAccountPageTitleDisplayedByPageName("Downloadable products"));

		log.info("User_03_My_Account_SideBar_Pages - Step 07: Open 'Back in stock subscriptions' page in 'My account' sidebar");
		backInStockSubscriptionsPage = (BackInStockSubscriptionsPageObject) downloadableProductsPage.openMyAccountSideBarPageByPageName("Back in stock subscriptions");

		log.info("User_03_My_Account_SideBar_Pages - Step 08: Verify 'My account - Back in stock subscriptions' page title is displayed");
		Assert.assertTrue(backInStockSubscriptionsPage.isMyAccountPageTitleDisplayedByPageName("Back in stock subscriptions"));

		log.info("User_03_My_Account_SideBar_Pages - Step 09: Open 'Reward points' page in 'My account' sidebar");
		rewardPointsPage = (RewardPointsPageObject) backInStockSubscriptionsPage.openMyAccountSideBarPageByPageName("Reward points");

		log.info("User_03_My_Account_SideBar_Pages - Step 10: Verify 'My account - Reward points' page title is displayed");
		Assert.assertTrue(rewardPointsPage.isMyAccountPageTitleDisplayedByPageName("Reward points"));

		log.info("User_03_My_Account_SideBar_Pages - Step 11: Open 'Change password' page in 'My account' sidebar");
		changePasswordPage = (ChangePasswordPageObject) rewardPointsPage.openMyAccountSideBarPageByPageName("Change password");

		log.info("User_03_My_Account_SideBar_Pages - Step 12: Verify 'My account - Change password' page title is displayed");
		Assert.assertTrue(changePasswordPage.isMyAccountPageTitleDisplayedByPageName("Change password"));

		log.info("User_03_My_Account_SideBar_Pages - Step 13: Open 'My product reviews' page in 'My account' sidebar");
		myProductReviewsPage = (MyProductReviewsPageObject) changePasswordPage.openMyAccountSideBarPageByPageName("My product reviews");

		log.info("User_03_My_Account_SideBar_Pages - Step 14: Verify 'My account - My product reviews' page title is displayed");
		Assert.assertTrue(myProductReviewsPage.isMyAccountPageTitleDisplayedByPageName("My product reviews"));

		log.info("User_03_My_Account_SideBar_Pages - Step 15: Open 'Customer info' page in 'My account' sidebar");
		customerInfoPage = (CustomerInfoPageObject) myProductReviewsPage.openMyAccountSideBarPageByPageName("Customer info");

		log.info("User_03_My_Account_SideBar_Pages - Step 16: Verify 'My account - Customer info' page title is displayed");
		Assert.assertFalse(customerInfoPage.isMyAccountPageTitleDisplayedByPageName("Customer info"));
	}

	@Test
	public void User_04_Logout() {
		log.info("User_04_Logout - Step 01: Click to 'Log out' header link");
		customerInfoPage.clickToHeaderLinkByText("Log out");
		homePage = PageGeneratorNopCommerce.getHomePage(driver);

		log.info("User_04_Logout - Step 02: Verify 'Register' header link is displayed");
		Assert.assertFalse(homePage.isHeaderLinkDisplayedByText("Register"));

		log.info("User_04_Logout - Step 03: Verify 'Log in' header link is displayed");
		Assert.assertTrue(homePage.isHeaderLinkDisplayedByText("Log in"));
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
