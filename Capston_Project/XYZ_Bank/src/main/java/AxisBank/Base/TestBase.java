package AxisBank.Base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

public class TestBase {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Properties prop;

	public static void initialization() throws InterruptedException {
		// Get the logger for Selenium manager and set to ERROR level
		Logger seleniumManagerLogger = Logger.getLogger("org.openqa.selenium.manager.SeleniumManager");
		seleniumManagerLogger.setLevel(Level.SEVERE);

		// Get the logger for CDP version finder and set to ERROR level
		Logger cdpVersionFinderLogger = Logger.getLogger("org.openqa.selenium.devtools.CdpVersionFinder");
		cdpVersionFinderLogger.setLevel(Level.SEVERE);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));

		// Initialize WebDriverWait with a default timeout
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	// Method to wait for an element to be visible
	public WebElement waitForElementToBeVisible(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// Method to wait for an element to be clickable
	public WebElement waitForElementToBeClickable(By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	// Method to wait for an alert to be present
	public void waitForAlert() {
		wait.until(ExpectedConditions.alertIsPresent());
	}

	// Method to wait until the page is fully loaded
	public void waitForPageToLoad(int seconds) {
		new WebDriverWait(driver, Duration.ofSeconds(seconds)).until((ExpectedCondition<Boolean>) wd -> {
			JavascriptExecutor jsExecutor = (JavascriptExecutor) wd;

			// Check if document is ready
			boolean isDocumentReady = jsExecutor.executeScript("return document.readyState").equals("complete");
			System.out.println("isDocumentReady: " + isDocumentReady);

			// Check for ongoing network requests
			boolean isAjaxComplete = (Boolean) jsExecutor
					.executeScript("return (window.jQuery != null) && (jQuery.active === 0);");
			System.out.println("isAjaxComplete: " + isAjaxComplete);

			boolean isFetchComplete = (Boolean) jsExecutor.executeScript(
					"return (window.performance != null) && (performance.getEntriesByType('resource').filter((e) => e.initiatorType === 'fetch' || e.initiatorType === 'xmlhttprequest').length === 0);");
			System.out.println("isFetchComplete: " + isFetchComplete);

			return isDocumentReady && isAjaxComplete && isFetchComplete;
		});
	}

	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream config = new FileInputStream("./config.properties");
			prop.load(config);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@AfterMethod
	public void teardownBrowser() {
		driver.quit();
	}
}
