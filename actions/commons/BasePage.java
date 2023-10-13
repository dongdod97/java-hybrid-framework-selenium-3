package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	// WebBrowser methods

	protected void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}

	protected String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	protected String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	protected String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	protected String getWindowID(WebDriver driver) {
		return driver.getWindowHandle();
	}

	protected Set<String> getAllWindowIDs(WebDriver driver) {
		return driver.getWindowHandles();
	}

	protected void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	protected void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	protected void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	protected Alert waitForAlertPresence(WebDriver driver) {
		return new WebDriverWait(driver, longTimeout).until(ExpectedConditions.alertIsPresent());
	}

	protected void acceptAlert(WebDriver driver) {
		waitForAlertPresence(driver).accept();
	}

	protected void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}

	protected String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}

	protected void sendKeysToAlert(WebDriver driver, String keysToSend) {
		waitForAlertPresence(driver).sendKeys(keysToSend);
	}

	protected void switchToWindowWithDifferentID(WebDriver driver, String currentID) {
		Set<String> allWindowIDs = getAllWindowIDs(driver);
		for (String id : allWindowIDs) {
			if (!id.equals(currentID)) {
				driver.switchTo().window(id);
				break;
			}
		}
	}

	protected void switchToWindowByExpectedTitle(WebDriver driver, String expectedTitle) {
		Set<String> allWindowIDs = getAllWindowIDs(driver);
		for (String id : allWindowIDs) {
			driver.switchTo().window(id);
			String actualTitle = getPageTitle(driver);
			if (actualTitle.equals(expectedTitle)) {
				break;
			}
		}
	}

	protected void closeAllWindowsExceptWindowByID(WebDriver driver, String expectedID) {
		Set<String> allWindowIDs = getAllWindowIDs(driver);
		for (String id : allWindowIDs) {
			if (!id.equals(expectedID)) {
				driver.switchTo().window(id);
				driver.close();
			}
		}
		driver.switchTo().window(expectedID);
	}

	// WebElement methods

	private By getByXPath(String xpathLocator) {
		return By.xpath(xpathLocator);
	}

	private String getDynamicXPath(String xpathLocator, String... dynamicValues) {
		return String.format(xpathLocator, (Object[]) dynamicValues);
	}

	protected WebElement getWebElement(WebDriver driver, String xpathLocator) {
		return driver.findElement(getByXPath(xpathLocator));
	}

	protected WebElement getWebElement(WebDriver driver, String xpathLocator, String... dynamicValues) {
		return driver.findElement(getByXPath(getDynamicXPath(xpathLocator, dynamicValues)));
	}

	protected List<WebElement> getListWebElement(WebDriver driver, String xpathLocator) {
		return driver.findElements(getByXPath(xpathLocator));
	}

	protected List<WebElement> getListWebElement(WebDriver driver, String xpathLocator, String... dynamicValues) {
		return driver.findElements(getByXPath(getDynamicXPath(xpathLocator, dynamicValues)));
	}

	protected void clickToElement(WebDriver driver, String xpathLocator) {
		getWebElement(driver, xpathLocator).click();
	}

	protected void clickToElement(WebDriver driver, String xpathLocator, String... dynamicValues) {
		getWebElement(driver, getDynamicXPath(xpathLocator, dynamicValues)).click();
	}

	protected void sendKeysToElement(WebDriver driver, String xpathLocator, String keysToSend) {
		WebElement element = getWebElement(driver, xpathLocator);
		element.clear();
		element.sendKeys(keysToSend);
	}

	protected void sendKeysToElement(WebDriver driver, String xpathLocator, String keysToSend, String... dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicXPath(xpathLocator, dynamicValues));
		element.clear();
		element.sendKeys(keysToSend);
	}

	protected String getElementText(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).getText();
	}

	protected String getElementText(WebDriver driver, String xpathLocator, String... dynamicValues) {
		return getWebElement(driver, getDynamicXPath(xpathLocator, dynamicValues)).getText();
	}

	protected String getElementAttributeValue(WebDriver driver, String xpathLocator, String attributeName) {
		return getWebElement(driver, xpathLocator).getAttribute(attributeName);
	}

	protected String getElementAttributeValue(WebDriver driver, String xpathLocator, String attributeName, String... dynamicValues) {
		return getWebElement(driver, getDynamicXPath(xpathLocator, dynamicValues)).getAttribute(attributeName);
	}

	protected String getElementCssValue(WebDriver driver, String xpathLocator, String propertyName) {
		return getWebElement(driver, xpathLocator).getCssValue(propertyName);
	}

	protected String getElementCssValue(WebDriver driver, String xpathLocator, String propertyName, String... dynamicValues) {
		return getWebElement(driver, getDynamicXPath(xpathLocator, dynamicValues)).getCssValue(propertyName);
	}

	protected String getHexColorFromRGBAColor(WebDriver driver, String xpathLocator, String propertyName) {
		return Color.fromString(getElementCssValue(driver, xpathLocator, propertyName)).asHex().toUpperCase();
	}

	protected String getHexColorFromRGBAColor(WebDriver driver, String xpathLocator, String propertyName, String... dynamicValues) {
		return Color.fromString(getElementCssValue(driver, getDynamicXPath(xpathLocator, dynamicValues), propertyName)).asHex().toUpperCase();
	}

	protected int getNumberOfElements(WebDriver driver, String xpathLocator) {
		return getListWebElement(driver, xpathLocator).size();
	}

	protected int getNumberOfElements(WebDriver driver, String xpathLocator, String... dynamicValues) {
		return getListWebElement(driver, getDynamicXPath(xpathLocator, dynamicValues)).size();
	}

	protected boolean isElementDisplayed(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).isDisplayed();
	}

	protected boolean isElementDisplayed(WebDriver driver, String xpathLocator, String... dynamicValues) {
		return getWebElement(driver, getDynamicXPath(xpathLocator, dynamicValues)).isDisplayed();
	}

	protected boolean isElementEnabled(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).isEnabled();
	}

	protected boolean isElementEnabled(WebDriver driver, String xpathLocator, String... dynamicValues) {
		return getWebElement(driver, getDynamicXPath(xpathLocator, dynamicValues)).isEnabled();
	}

	protected boolean isElementSelected(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).isSelected();
	}

	protected boolean isElementSelected(WebDriver driver, String xpathLocator, String... dynamicValues) {
		return getWebElement(driver, getDynamicXPath(xpathLocator, dynamicValues)).isSelected();
	}

	protected void selectOptionInDefaultDropdown(WebDriver driver, String xpathLocator, String optionValue) {
		new Select(getWebElement(driver, xpathLocator)).selectByVisibleText(optionValue);
	}

	protected void selectOptionInDefaultDropdown(WebDriver driver, String xpathLocator, String optionValue, String... dynamicValues) {
		new Select(getWebElement(driver, getDynamicXPath(xpathLocator, dynamicValues))).selectByVisibleText(optionValue);
	}

	protected String getSelectedOptionTextInDefaultDropdown(WebDriver driver, String xpathLocator) {
		return new Select(getWebElement(driver, xpathLocator)).getFirstSelectedOption().getText();
	}

	protected String getSelectedOptionTextInDefaultDropdown(WebDriver driver, String xpathLocator, String... dynamicValues) {
		return new Select(getWebElement(driver, getDynamicXPath(xpathLocator, dynamicValues))).getFirstSelectedOption().getText();
	}

	protected boolean isDefaultDropdownMultiple(WebDriver driver, String xpathLocator) {
		return new Select(getWebElement(driver, xpathLocator)).isMultiple();
	}

	protected boolean isDefaultDropdownMultiple(WebDriver driver, String xpathLocator, String... dynamicValues) {
		return new Select(getWebElement(driver, getDynamicXPath(xpathLocator, dynamicValues))).isMultiple();
	}

	protected void selectOptionInCustomDropdown(WebDriver driver, String dropdownXPath, String optionsXPath, String expectedOption) {
		clickToElement(driver, dropdownXPath);
		sleepInSecond(oneSecond);
		List<WebElement> allOptions = new WebDriverWait(driver, longTimeout).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(optionsXPath)));
		for (WebElement option : allOptions) {
			if (option.getText().trim().equals(expectedOption)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
				sleepInSecond(oneSecond);
				option.click();
				sleepInSecond(oneSecond);
				break;
			}
		}
	}

	protected void selectOptionInCustomDropdown(WebDriver driver, String dropdownXPath, String optionsXPath, String expectedOption, String... dynamicValues) {
		clickToElement(driver, getDynamicXPath(expectedOption, dynamicValues));
		sleepInSecond(oneSecond);
		List<WebElement> allOptions = new WebDriverWait(driver, longTimeout).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(optionsXPath)));
		for (WebElement option : allOptions) {
			if (option.getText().trim().equals(expectedOption)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
				sleepInSecond(oneSecond);
				option.click();
				sleepInSecond(oneSecond);
				break;
			}
		}
	}

	protected void checkToDefaultCheckboxOrRadioButton(WebDriver driver, String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		if (!element.isSelected()) {
			element.click();
		}
	}

	protected void checkToDefaultCheckboxOrRadioButton(WebDriver driver, String xpathLocator, String... dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicXPath(xpathLocator, dynamicValues));
		if (!element.isSelected()) {
			element.click();
		}
	}

	protected void uncheckToDefaultCheckbox(WebDriver driver, String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		if (element.isSelected()) {
			element.click();
		}
	}

	protected void uncheckToDefaultCheckbox(WebDriver driver, String xpathLocator, String... dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicXPath(xpathLocator, dynamicValues));
		if (element.isSelected()) {
			element.click();
		}
	}

	protected void switchToFrame(WebDriver driver, String xpathLocator) {
		new WebDriverWait(driver, longTimeout).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(getByXPath(xpathLocator)));
	}

	protected void switchToFrame(WebDriver driver, String xpathLocator, String... dynamicValues) {
		new WebDriverWait(driver, longTimeout).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(getByXPath(getDynamicXPath(xpathLocator, dynamicValues))));
	}

	protected void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	protected void uploadFile(WebDriver driver, String... fileNames) {
		String uploadFileFolderPath = GlobalConstants.UPLOAD_FILE_FOLDER_PATH;
		String filePath = "";
		for (String fileName : fileNames) {
			filePath = filePath + uploadFileFolderPath + fileName + "\n";
		}
		filePath = filePath.trim();
		getWebElement(driver, "//input[@type='file']").sendKeys(filePath);
	}

	// Actions methods

	protected void hoverMouseToElement(WebDriver driver, String xpathLocator) {
		new Actions(driver).moveToElement(getWebElement(driver, xpathLocator)).perform();
	}

	protected void hoverMouseToElement(WebDriver driver, String xpathLocator, String... dynamicValues) {
		new Actions(driver).moveToElement(getWebElement(driver, getDynamicXPath(xpathLocator, dynamicValues))).perform();
	}

	protected void doubleClickToElement(WebDriver driver, String xpathLocator) {
		new Actions(driver).doubleClick(getWebElement(driver, xpathLocator)).perform();
	}

	protected void doubleClickToElement(WebDriver driver, String xpathLocator, String... dynamicValues) {
		new Actions(driver).doubleClick(getWebElement(driver, getDynamicXPath(xpathLocator, dynamicValues))).perform();
	}

	protected void clickAndHoldOnElement(WebDriver driver, String xpathLocator) {
		new Actions(driver).clickAndHold(getWebElement(driver, xpathLocator)).perform();
	}

	protected void clickAndHoldOnElement(WebDriver driver, String xpathLocator, String... dynamicValues) {
		new Actions(driver).clickAndHold(getWebElement(driver, getDynamicXPath(xpathLocator, dynamicValues))).perform();
	}

	protected void releaseLeftMouseButtonOnElement(WebDriver driver, String xpathLocator) {
		new Actions(driver).release(getWebElement(driver, xpathLocator)).perform();
	}

	protected void releaseLeftMouseButtonOnElement(WebDriver driver, String xpathLocator, String... dynamicValues) {
		new Actions(driver).release(getWebElement(driver, getDynamicXPath(xpathLocator, dynamicValues))).perform();
	}

	protected void rightClickToElement(WebDriver driver, String xpathLocator) {
		new Actions(driver).contextClick(getWebElement(driver, xpathLocator)).perform();
	}

	protected void rightClickToElement(WebDriver driver, String xpathLocator, String... dynamicValues) {
		new Actions(driver).contextClick(getWebElement(driver, getDynamicXPath(xpathLocator, dynamicValues))).perform();
	}

	protected void dragAndDropElement(WebDriver driver, String sourceXPath, String targetXPath) {
		new Actions(driver).dragAndDrop(getWebElement(driver, sourceXPath), getWebElement(driver, targetXPath)).perform();
	}

	protected void sendKeyboardToElement(WebDriver driver, String xpathLocator, Keys key) {
		new Actions(driver).sendKeys(getWebElement(driver, xpathLocator), key).perform();
	}

	protected void sendKeyboardToElement(WebDriver driver, String xpathLocator, Keys key, String... dynamicValues) {
		new Actions(driver).sendKeys(getWebElement(driver, getDynamicXPath(xpathLocator, dynamicValues)), key).perform();
	}

	// JavascriptExecutor methods

	protected void clickToElementByJS(WebDriver driver, String xpathLocator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver, xpathLocator));
	}

	protected void clickToElementByJS(WebDriver driver, String xpathLocator, String... dynamicValues) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver, getDynamicXPath(xpathLocator, dynamicValues)));
	}

	protected void sendKeysToElementByJS(WebDriver driver, String xpathLocator, String keysToSend) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + keysToSend + "')", getWebElement(driver, xpathLocator));
	}

	protected void sendKeysToElementByJS(WebDriver driver, String xpathLocator, String keysToSend, String... dynamicValues) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + keysToSend + "')", getWebElement(driver, getDynamicXPath(xpathLocator, dynamicValues)));
	}

	protected String getInnerTextByJS(WebDriver driver) {
		return (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText;");
	}

	protected boolean isExpectedTextInInnerTextByJS(WebDriver driver, String expectedText) {
		String textActual = (String) ((JavascriptExecutor) driver).executeScript("return document.documentElement.innerText.match('" + expectedText + "')[0];");
		return textActual.equals(expectedText);
	}

	protected String getElementValidationMessageByJS(WebDriver driver, String xpathLocator) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getWebElement(driver, xpathLocator));
	}

	protected String getElementValidationMessageByJS(WebDriver driver, String xpathLocator, String... dynamicValues) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getWebElement(driver, getDynamicXPath(xpathLocator, dynamicValues)));
	}

	protected String getElementAttributeValueByJS(WebDriver driver, String xpathLocator, String attributeName) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].getAttribute('" + attributeName + "');", getWebElement(driver, xpathLocator));
	}

	protected String getElementAttributeValueByJS(WebDriver driver, String xpathLocator, String attributeName, String... dynamicValues) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].getAttribute('" + attributeName + "');", getWebElement(driver, getDynamicXPath(xpathLocator, dynamicValues)));
	}

	protected void setElementAttributeValueByJS(WebDriver driver, String xpathLocator, String attributeName, String attributeValue) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "');", getWebElement(driver, xpathLocator));
	}

	protected void setElementAttributeValueByJS(WebDriver driver, String xpathLocator, String attributeName, String attributeValue, String... dynamicValues) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('" + attributeName + "', '" + attributeValue + "');", getWebElement(driver, getDynamicXPath(xpathLocator, dynamicValues)));
	}

	protected void removeElementAttributeInDOMByJS(WebDriver driver, String xpathLocator, String attributeName) {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeName + "');", getWebElement(driver, xpathLocator));
	}

	protected void removeElementAttributeInDOMByJS(WebDriver driver, String xpathLocator, String attributeName, String... dynamicValues) {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeName + "');", getWebElement(driver, getDynamicXPath(xpathLocator, dynamicValues)));
	}

	protected void hightlightElementByJS(WebDriver driver, String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		String originalStyle = element.getAttribute("style");
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
		sleepInSecond(oneSecond);
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}

	protected void hightlightElementByJS(WebDriver driver, String xpathLocator, String... dynamicValues) {
		WebElement element = getWebElement(driver, getDynamicXPath(xpathLocator, dynamicValues));
		String originalStyle = element.getAttribute("style");
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
		sleepInSecond(oneSecond);
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}

	protected void scrollToBottomPageByJS(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	protected void scrollToElementOnTopByJS(WebDriver driver, String xpathLocator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, xpathLocator));
	}

	protected void scrollToElementOnTopByJS(WebDriver driver, String xpathLocator, String... dynamicValues) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, getDynamicXPath(xpathLocator, dynamicValues)));
	}

	protected void scrollToElementOnDownByJS(WebDriver driver, String xpathLocator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getWebElement(driver, xpathLocator));
	}

	protected void scrollToElementOnDownByJS(WebDriver driver, String xpathLocator, String... dynamicValues) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getWebElement(driver, getDynamicXPath(xpathLocator, dynamicValues)));
	}

	protected boolean isImagePresentByJS(WebDriver driver, String xpathLocator) {
		return (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getWebElement(driver, xpathLocator));
	}

	protected boolean isImagePresentByJS(WebDriver driver, String xpathLocator, String... dynamicValues) {
		return (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
				getWebElement(driver, getDynamicXPath(xpathLocator, dynamicValues)));
	}

	protected boolean isPageLoaded(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return (Boolean) ((JavascriptExecutor) driver).executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	// Wait methods

	protected void waitForElementVisible(WebDriver driver, String xpathLocator) {
		new WebDriverWait(driver, longTimeout).until(ExpectedConditions.visibilityOfElementLocated(getByXPath(xpathLocator)));
	}

	protected void waitForElementVisible(WebDriver driver, String xpathLocator, String... dynamicValues) {
		new WebDriverWait(driver, longTimeout).until(ExpectedConditions.visibilityOfElementLocated(getByXPath(getDynamicXPath(xpathLocator, dynamicValues))));
	}

	protected void waitForAllElementsVisible(WebDriver driver, String xpathLocator) {
		new WebDriverWait(driver, longTimeout).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXPath(xpathLocator)));
	}

	protected void waitForAllElementsVisible(WebDriver driver, String xpathLocator, String... dynamicValues) {
		new WebDriverWait(driver, longTimeout).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXPath(getDynamicXPath(xpathLocator, dynamicValues))));
	}

	protected void waitForElementClickable(WebDriver driver, String xpathLocator) {
		new WebDriverWait(driver, longTimeout).until(ExpectedConditions.elementToBeClickable(getByXPath(xpathLocator)));
	}

	protected void waitForElementClickable(WebDriver driver, String xpathLocator, String... dynamicValues) {
		new WebDriverWait(driver, longTimeout).until(ExpectedConditions.elementToBeClickable(getByXPath(getDynamicXPath(xpathLocator, dynamicValues))));
	}

	protected void sleepInSecond(long time) {
		try {
			Thread.sleep(time * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private long oneSecond = GlobalConstants.ONE_SECOND;
	private long longTimeout = GlobalConstants.LONG_TIMEOUT;

}
