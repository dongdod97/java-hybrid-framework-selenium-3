package pageObjects.jQuery;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import commons.GlobalConstants;
import pageUIs.jQuery.UploadFilePageUI;

public class UploadFilePageObject extends BasePage {
	private WebDriver driver;

	public UploadFilePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void uploadFileToPage(String... fileNames) {
		uploadFile(driver, fileNames);
	}

	public boolean isFileLoadedByName(String fileName) {
		waitForElementVisible(driver, UploadFilePageUI.FILE_LOADED_BY_NAME, fileName);
		return isElementDisplayed(driver, UploadFilePageUI.FILE_LOADED_BY_NAME, fileName);
	}

	public void clickToStartButtonByName(String fileName) {
		waitForElementClickable(driver, UploadFilePageUI.START_BUTTON_BY_NAME, fileName);
		clickToElement(driver, UploadFilePageUI.START_BUTTON_BY_NAME, fileName);
		sleepInSecond(GlobalConstants.ONE_SECOND);
	}

	public void clickToAllStartButtons() {
		List<WebElement> allStartButtons = getListWebElement(driver, UploadFilePageUI.ALL_START_BUTTONS);
		for (WebElement startButton : allStartButtons) {
			startButton.click();
			sleepInSecond(GlobalConstants.ONE_SECOND);
		}
	}

	public boolean isFileUploadedLinkDisplayedByName(String fileName) {
		waitForElementVisible(driver, UploadFilePageUI.FILE_UPLOADED_LINK_BY_NAME, fileName);
		return isElementDisplayed(driver, UploadFilePageUI.FILE_UPLOADED_LINK_BY_NAME, fileName);
	}

	public boolean isFileUploadedImageDisplayedByName(String fileName) {
		waitForElementVisible(driver, UploadFilePageUI.FILE_UPLOADED_IMG_BY_NAME, fileName);
		return isImagePresentByJS(driver, UploadFilePageUI.FILE_UPLOADED_IMG_BY_NAME, fileName);
	}

	public void deleteFileUploadedByName(String fileName) {
		waitForElementClickable(driver, UploadFilePageUI.DELETE_BUTTON_BY_NAME, fileName);
		clickToElement(driver, UploadFilePageUI.DELETE_BUTTON_BY_NAME, fileName);
		sleepInSecond(GlobalConstants.ONE_SECOND);
	}

	public void clickToAllDeleteButtons() {
		List<WebElement> allDeleteButtons = getListWebElement(driver, UploadFilePageUI.ALL_DELETE_BUTTONS);
		for (WebElement deleteButton : allDeleteButtons) {
			deleteButton.click();
			sleepInSecond(GlobalConstants.ONE_SECOND);
		}
	}

}
