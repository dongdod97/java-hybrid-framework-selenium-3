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
import pageObjects.jQuery.UploadFilePageObject;

public class Level_08_Upload_File extends BaseTest {
	private WebDriver driver;
	private UploadFilePageObject uploadFilePage;
	private String javaFile = "java.jpg";
	private String cSharpFile = "cSharp.jpg";
	private String javaScriptFile = "javaScript.jpg";
	private String rubyFile = "ruby.jpg";
	private String pythonFile = "python.jpg";
	private String[] multipleFiles = { javaFile, cSharpFile, javaScriptFile, rubyFile, pythonFile };

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName, GlobalConstants.UPLOAD_FILE_URL);
		uploadFilePage = PageGeneratorJQuery.getUploadFilePage(driver);
	}

	@Test
	public void TC_01_Upload_Single_File_Per_Time() {
		uploadFilePage.uploadFileToPage(javaFile);

		Assert.assertTrue(uploadFilePage.isFileLoadedByName(javaFile));

		uploadFilePage.clickToStartButtonByName(javaFile);

		Assert.assertTrue(uploadFilePage.isFileUploadedLinkDisplayedByName(javaFile));

		Assert.assertTrue(uploadFilePage.isFileUploadedImageDisplayedByName(javaFile));

		uploadFilePage.deleteFileUploadedByName(javaFile);
	}

	@Test
	public void TC_02_Upload_Multiple_Files_Per_Time() {
		uploadFilePage.uploadFileToPage(multipleFiles);

		Assert.assertTrue(uploadFilePage.isFileLoadedByName(javaFile));
		Assert.assertTrue(uploadFilePage.isFileLoadedByName(cSharpFile));
		Assert.assertTrue(uploadFilePage.isFileLoadedByName(javaScriptFile));
		Assert.assertTrue(uploadFilePage.isFileLoadedByName(rubyFile));
		Assert.assertTrue(uploadFilePage.isFileLoadedByName(pythonFile));

		uploadFilePage.clickToAllStartButtons();

		Assert.assertTrue(uploadFilePage.isFileUploadedLinkDisplayedByName(javaFile));
		Assert.assertTrue(uploadFilePage.isFileUploadedLinkDisplayedByName(cSharpFile));
		Assert.assertTrue(uploadFilePage.isFileUploadedLinkDisplayedByName(javaScriptFile));
		Assert.assertTrue(uploadFilePage.isFileUploadedLinkDisplayedByName(rubyFile));
		Assert.assertTrue(uploadFilePage.isFileUploadedLinkDisplayedByName(pythonFile));

		Assert.assertTrue(uploadFilePage.isFileUploadedImageDisplayedByName(javaFile));
		Assert.assertTrue(uploadFilePage.isFileUploadedImageDisplayedByName(cSharpFile));
		Assert.assertTrue(uploadFilePage.isFileUploadedImageDisplayedByName(javaScriptFile));
		Assert.assertTrue(uploadFilePage.isFileUploadedImageDisplayedByName(rubyFile));
		Assert.assertTrue(uploadFilePage.isFileUploadedImageDisplayedByName(pythonFile));

		uploadFilePage.clickToAllDeleteButtons();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
