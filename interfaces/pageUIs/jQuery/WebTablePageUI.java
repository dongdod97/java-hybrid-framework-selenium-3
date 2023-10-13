package pageUIs.jQuery;

public class WebTablePageUI {

	// WebTable Pagination

	public static final String PAGINATION_PAGE_LINK_BY_NUMBER = "//li[@class='qgrd-pagination-page']/a[text()='%s']";
	public static final String PAGINATION_PAGE_LINK_ACTIVE_BY_NUMBER = "//a[@class='qgrd-pagination-page-link active' and text()='%s']";
	public static final String TEXTBOX_BY_LABEL = "//div[text()='%s']/parent::div/following-sibling::input";
	public static final String ROW_BY_VALUES = "//tr/td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']/following-sibling::td[text()='%s']";
	public static final String ALL_PAGINATION_PAGE_LINKS = "//li[@class='qgrd-pagination-page']/a";
	public static final String ALL_ROWS_EACH_PAGE = "//tbody//tr";
	public static final String COLUMN_INDEX_BY_LABEL = "//div[text()='%s']/ancestor::th/preceding-sibling::th";
	public static final String ALL_ROWS_VALUES_BY_COLUMN_INDEX = "//tbody/tr/td[%s]";

	// WebTable Dynamic

	public static final String COLUMN_INDEX_BY_COLUMN_LABEL = "//thead/tr/th[text()='%s']/preceding-sibling::th";
	public static final String TEXTBOX_AT_ROW_AND_COLUMN_INDEX = "//tbody/tr[%s]/td[%s]/input";
	public static final String DROPDOWN_AT_ROW = "//tbody/tr[%s]/td//select";
	public static final String CHECKBOX_AT_ROW = "//tbody/tr[%s]/td//input[@type='checkbox']";
	public static final String DATE_PICKER_AT_ROW = "//tbody/tr[%s]/td//input[contains(@id,'memberSince')]";
	public static final String CONTROL_BUTTON_AT_ROW_BY_TITLE = "//tr[%s]//p[@class='control']/button[@title='%s']";
	public static final String LOAD_BUTTON = "//button[@id='load']";
	public static final String APPEND_ROW_BUTTON = "//button[@title='Append Row']";
	public static final String REMOVE_LAST_ROW_BUTTON = "//button[@title='Remove Last Row']";

}
