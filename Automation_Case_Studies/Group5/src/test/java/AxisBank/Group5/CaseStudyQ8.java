package AxisBank.Group5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CaseStudyQ8 {
	public static void main(String[] args) throws InterruptedException {

		// Initialize WebDriver with ChromeDriver
		WebDriver driver = new ChromeDriver();
		System.out.println("Browser Instance is created");

		// 1. Launch the Web site
		driver.get("https://testautomationpractice.blogspot.com/");
		System.out.println("Navigated to the website");

		// Maximize the window
		driver.manage().window().maximize();

		// 2. Input the name.
		driver.findElement(By.id("name")).sendKeys("Test Titans 5.1");

		Thread.sleep(1000);

		// 3. Input the phone number and print the input value
		driver.findElement(By.id("phone")).sendKeys("9234567890");

		// 4. Retrieve and print the entered phone number.
		String phoneNumber = driver.findElement(By.id("phone")).getAttribute("value");
		System.out.println("Phone Number: " + phoneNumber);

		Thread.sleep(1000);

		// 5. Clear the existing phone number
		driver.findElement(By.id("phone")).clear();

		Thread.sleep(1000);

		// 6. Input the email
		driver.findElement(By.id("email")).sendKeys("TestTitans5@gmail.com");

		Thread.sleep(1000);

		// Initialize Actions class to perform complex actions
		Actions action = new Actions(driver);

		// 7. Identify elements for drag-and-drop
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));

		// 8. Perform Drag and Drop action
		action.dragAndDrop(drag, drop).build().perform();
		System.out.println("Performed drag and drop function");

		Thread.sleep(1000);

		// Identify element for copy text
		WebElement copytext = driver.findElement(By.xpath("//*[@id=\"HTML10\"]/div[1]/button"));

		// 9. Perform double click operation
		action.doubleClick(copytext).build().perform();
		System.out.println("Performed double click function");

		// Wait for 2 seconds to observe the final state of actions performed.
		Thread.sleep(2000);

		// 10. Close the Web Browser
		driver.close();
		System.out.println("Closed the Browser");

	}

}
