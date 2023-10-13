package pageUIs.jQuery;

public class UploadFilePageUI {

	public static final String FILE_LOADED_BY_NAME = "//tbody[@class='files']/tr/td/p[text()='%s']";
	public static final String ALL_START_BUTTONS = "//tbody[@class='files']/tr/td/button[contains(@class,'start')]";
	public static final String START_BUTTON_BY_NAME = FILE_LOADED_BY_NAME + "/parent::td/following-sibling::td/button[contains(@class,'start')]";
	public static final String FILE_UPLOADED_LINK_BY_NAME = "//tbody[@class='files']/tr/td//a[text()='%s']";
	public static final String FILE_UPLOADED_IMG_BY_NAME = "//tbody[@class='files']/tr/td//a[@title='%s']/img";
	public static final String ALL_DELETE_BUTTONS = "//tbody[@class='files']/tr/td/button[contains(@class,'delete')]";
	public static final String DELETE_BUTTON_BY_NAME = FILE_UPLOADED_LINK_BY_NAME + "//ancestor::td/following-sibling::td/button[contains(@class,'delete')]";

}
