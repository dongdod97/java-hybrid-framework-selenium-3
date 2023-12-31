package commons;

import java.io.File;

public class GlobalConstants {

	// Env
	public static final String JAVA_VERSION = System.getProperty("java.version");

	// Url
	public static final String WEB_TABLE_PAGINATION_URL = "https://www.jqueryscript.net/demo/CRUD-Data-Grid-Plugin-jQuery-Quickgrid/";
	public static final String WEB_TABLE_DYNAMIC_URL = "https://www.jqueryscript.net/demo/jQuery-Dynamic-Data-Grid-Plugin-appendGrid/";
	public static final String UPLOAD_FILE_URL = "https://blueimp.github.io/jQuery-File-Upload/";

	// Time
	public static final long ONE_SECOND = 1;
	public static final long LONG_TIMEOUT = 30;

	// Path
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String UPLOAD_FILE_FOLDER_PATH = PROJECT_PATH + File.separator + "uploadFile" + File.separator;
	public static final String EXTENT_REPORTS_OUTPUT_FOLDER_PATH = PROJECT_PATH + File.separator + "extentReports-output" + File.separator;
	public static final String ALLURE_REPORTS_OUTPUT_FOLDER_PATH = PROJECT_PATH + File.separator + "allure-results";

}
