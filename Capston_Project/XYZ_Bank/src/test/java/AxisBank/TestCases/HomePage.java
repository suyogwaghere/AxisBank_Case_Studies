package AxisBank.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AxisBank.Base.TestBase;
import AxisBank.Pages.Homepage;

public class HomePage extends TestBase {
	Homepage homepage;

	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		initialization();
		homepage = new Homepage();
	}

	@Test(priority = 1)
	public void homePageTest() {
		// Wait for the logo to be visible before verifying the logo text
		waitForElementToBeVisible(By.xpath("//strong[contains(.,'XYZ Bank')]")); // Replace with actual logo element ID
		String explogo = homepage.verifyLogoText();
		System.out.println("Logo: " + explogo);
		Assert.assertEquals(explogo, "XYZ Bank", "Expected logo text is not present");

		// Wait for the page title to be "XYZ Bank" and verify
		wait.until(ExpectedConditions.titleIs("XYZ Bank"));
		String expTitle = homepage.getPageTitle();
		System.out.println("Title: " + expTitle);
		Assert.assertEquals(expTitle, "XYZ Bank", "Expected title is not present");

		// Verify the page URL
		String actUrl = homepage.getPageURL();
		Assert.assertEquals(actUrl, "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login",
				"Expected URL is not present");
		System.out.println("URL: " + actUrl);
	}

}
