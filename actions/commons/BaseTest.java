package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private WebDriver driver;

	protected WebDriver getBrowserDriver(String browserName, String appUrl) {
		switch (browserName) {
		case "firefox":
			driver = WebDriverManager.firefoxdriver().create();
			break;
		case "chrome":
			driver = WebDriverManager.chromedriver().create();
			break;
		case "edge":
			driver = WebDriverManager.edgedriver().create();
			break;
		default:
			throw new RuntimeException(browserName.toUpperCase() + " Browser is invalid!");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(appUrl);
		return driver;
	}

	protected int getRandomNumber() {
		return new Random().nextInt(99999);
	}

}
