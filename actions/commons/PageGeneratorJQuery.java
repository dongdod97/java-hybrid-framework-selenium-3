package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.jQuery.WebTablePageObject;

public class PageGeneratorJQuery {

	public static final WebTablePageObject getWebTablePage(WebDriver driver) {
		return new WebTablePageObject(driver);
	}

}
