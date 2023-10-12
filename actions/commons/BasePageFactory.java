package commons;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageFactory {

	protected void clickToElement(WebDriver driver, WebElement element) {
		element.click();
	}

	protected void sendKeysToElement(WebDriver driver, WebElement element, String keysToSend) {
		element.clear();
		element.sendKeys(keysToSend);
	}

	protected String getElementText(WebDriver driver, WebElement element) {
		return element.getText();
	}

	protected boolean isElementDisplayed(WebDriver driver, WebElement element) {
		return element.isDisplayed();
	}

	protected void waitForElementVisible(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(element));
	}

	protected void waitForElementClickable(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(element));
	}

}
