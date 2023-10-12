package pageObjects.nopCommerce;

public class DynamicElementsNopCommerce {

	public static final String HEADER_LINK_BY_TEXT = "//div[@class='header-links']//a[text()='%s']";
	public static final String RADIO_BUTTON_BY_LABEL = "//label[text()='%s']/preceding-sibling::input[@type='radio']";
	public static final String TEXTBOX_BY_ID = "//input[@id='%s']";
	public static final String DROPDOWN_BY_NAME = "//select[@name='%s']";
	public static final String CHECKBOX_BY_LABEL = "//label[text()='%s']/following-sibling::input[@type='checkbox']";
	public static final String BUTTON_BY_TEXT = "//button[text()='%s']";
	public static final String MY_ACCOUNT_SIDEBAR_PAGE_BY_PAGE_NAME = "//strong[text()='My account']/parent::div/following-sibling::div//a[text()='%s']";
	public static final String MY_ACCOUNT_PAGE_TITLE_BY_PAGE_NAME = "//div[@class='page-title']/h1[text()='My account - " + "%s']";

}
