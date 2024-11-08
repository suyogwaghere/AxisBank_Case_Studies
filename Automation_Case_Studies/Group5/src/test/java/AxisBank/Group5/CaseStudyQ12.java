package AxisBank.Group5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CaseStudyQ12 {
	public static void main(String[] args) throws InterruptedException {

		// Initialize WebDriver with ChromeDriver
		WebDriver driver = new ChromeDriver();
		System.out.println("Browser Instance is created");

		// 1. Launch the Yahoo account creation page.
		driver.get("https://login.yahoo.com/account/create");
		System.out.println("Navigated to the website");

		// 2. Maximize the browser window.
		driver.manage().window().maximize();

		// 3. Enter full name in First Name and Last Name fields.
		WebElement firstNameElement = driver.findElement(By.id("usernamereg-firstName"));
		WebElement lastNameElement = driver.findElement(By.id("usernamereg-lastName"));
		firstNameElement.sendKeys("Test");
		lastNameElement.sendKeys("Titans");

		// 4. Retrieve and print the entered full name.
		String firstName = firstNameElement.getAttribute("value");
		String lastName = lastNameElement.getAttribute("value");
		System.out.println("Full Name: " + firstName + " " + lastName);

		// 5. Enter a Yahoo email address.
		driver.findElement(By.id("usernamereg-userId")).sendKeys("test_titans_5.1");

		// 6. Enter a secure password in the Password field.
		WebElement passwordElement = driver.findElement(By.id("usernamereg-password"));
		passwordElement.sendKeys("Pass#word@123");

		// 7. Print the password to confirm entry.
		String password = passwordElement.getAttribute("value");
		System.out.println("Password: " + password);

		// 8. Select "September" from the "Birth Month" drop down menu.
		Select monthSelect = new Select(driver.findElement(By.id("usernamereg-month")));
		monthSelect.selectByVisibleText("September");

		// 9. Enter birth day.
		driver.findElement(By.id("usernamereg-day")).sendKeys("14");

		// 10. Enter birth year.
		driver.findElement(By.id("usernamereg-year")).sendKeys("1998");

		// 11. Wait for 3 seconds to observe the actions performed.
		Thread.sleep(3000);

		// 12. Click on the Next button to proceed.
		driver.findElement(By.id("reg-submit-button")).click();

		// 13. Wait for another 3 seconds to observe any results.
		Thread.sleep(3000);

		// 14. Close the browser.
		driver.quit();
		System.out.println("Closed the Browser");
	}
}
