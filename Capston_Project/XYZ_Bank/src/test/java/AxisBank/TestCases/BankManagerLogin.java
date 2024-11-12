package AxisBank.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AxisBank.Base.TestBase;
import AxisBank.Pages.AddCustomerPage;
import AxisBank.Pages.BankManagerLoginPage;
import AxisBank.Pages.CustomersListPage;
import AxisBank.Pages.Homepage;
import AxisBank.Pages.OpenAccountPage;

public class BankManagerLogin extends TestBase {

	Homepage homepage;
	AddCustomerPage addCustomerPage;
	BankManagerLoginPage bankManagerLoginPage;
	OpenAccountPage openAccountPage;
	CustomersListPage customerslistPage;

	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		initialization();
		homepage = new Homepage();
		addCustomerPage = new AddCustomerPage();
		bankManagerLoginPage = new BankManagerLoginPage();
		openAccountPage = new OpenAccountPage();
		customerslistPage = new CustomersListPage();
	}


	@Test(priority = 2)
	public void addCustomer() throws Exception {
		// Wait for the Manager Login button and click it
		waitForElementToBeVisible(By.xpath("//button[contains(.,'Bank Manager Login')]")).click();

		// Wait for add customer tab and click it
		waitForElementToBeVisible(By.xpath("//button[contains(text(),'Add Customer')]")).click();
		waitForElementToBeVisible(By.xpath("/html/body/div/div/div[2]/div/div[2]/div"));

		System.out.println("Entering details started");
		// Enter details and submit
		addCustomerPage.enterFName(prop.getProperty("fname"));
		addCustomerPage.enterLName(prop.getProperty("lname"));
		addCustomerPage.enterPCode(prop.getProperty("zip"));
		addCustomerPage.clickaddCustBtn();

		// Wait for alert and accept
		waitForAlert();
		String alertMsg = addCustomerPage.acceptAlert();
		System.out.println(alertMsg);
	}

	@Test(priority = 2)
	public void addInvalidCustomer() throws Exception {
		// Wait for the Manager Login button and click it
		waitForElementToBeVisible(By.xpath("//button[contains(.,'Bank Manager Login')]")).click();

		// Wait for add customer tab and click it
		waitForElementToBeVisible(By.xpath("//button[contains(text(),'Add Customer')]")).click();
		waitForElementToBeVisible(By.xpath("/html/body/div/div/div[2]/div/div[2]/div"));

		System.out.println("Entering details started");
		// Enter details and submit
		addCustomerPage.enterFName(prop.getProperty("ifname"));
		addCustomerPage.enterLName(prop.getProperty("ilname"));
		addCustomerPage.enterPCode(prop.getProperty("zip"));
		addCustomerPage.clickaddCustBtn();

		// Wait for alert and accept
		waitForAlert();
		String alertMsg = addCustomerPage.acceptAlert();
		Assert.assertEquals(alertMsg, "Invalid First Name and Last Name", "Invalid First Name and Last Name");
		System.out.println(alertMsg);
	}

	@Test(priority = 3)
	public void openAccount() throws Exception {
		waitForElementToBeVisible(By.xpath("//button[contains(.,'Bank Manager Login')]")).click();

		// Open account tab
		waitForElementToBeVisible(By.xpath("//button[contains(text(),'Open Account')]")).click();
		waitForElementToBeVisible(By.xpath("/html/body/div/div/div[2]/div/div[2]/div"));
		// Select customer, currency, and process
		openAccountPage.selectCustomer();
		openAccountPage.selectCurrency();
		openAccountPage.clickProcessBtn();

		// Wait for alert and accept
		waitForAlert();
		String alertMsg = openAccountPage.acceptAlert();
		System.out.println(alertMsg);
	}

	@Test(priority = 4)
	public void searchCustomer() throws Exception {
		String searchingName = "Harry";

		// Manager Login button and click
		waitForElementToBeVisible(By.xpath("//button[contains(.,'Bank Manager Login')]")).click();

		// Click Customers tab and search for the name
		waitForElementToBeVisible(By.xpath("//button[contains(normalize-space(), 'Customers')]")).click();

		waitForElementToBeVisible(By.xpath("//input[contains(@placeholder, 'Search Customer')]"));

		customerslistPage.search(searchingName);

		// Verify searched name
		String name = customerslistPage.getSearchedName();
		Assert.assertEquals(searchingName, name, "searched name not found....");
		System.out.println("Expected Name: " + searchingName);
		System.out.println("Searched Name: " + name);
	}
}
