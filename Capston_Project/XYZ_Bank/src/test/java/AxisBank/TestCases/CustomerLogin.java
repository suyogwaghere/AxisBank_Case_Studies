package AxisBank.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import AxisBank.Base.TestBase;
import AxisBank.Pages.AccountPage;
import AxisBank.Pages.CustomerLoginPage;
import AxisBank.Pages.CustomersListPage;
import AxisBank.Pages.Homepage;

public class CustomerLogin extends TestBase {

	Homepage homepage;
	CustomerLoginPage customerLoginPage;
	AccountPage accountPage;
	CustomersListPage customerslistPage;

	@BeforeMethod
	public void setup() throws IOException, InterruptedException {
		initialization();

		homepage = new Homepage();
		customerLoginPage = new CustomerLoginPage();
		accountPage = new AccountPage();
		customerslistPage = new CustomersListPage();
	}

	@Test(priority = 6)
	public void DepositMoney() throws Exception {
		// Login as a customer
		waitForElementToBeClickable(By.xpath("//button[contains(.,'Customer Login')]")).click();
		waitForElementToBeVisible(By.id("userSelect"));
		customerLoginPage.selectUser();
		waitForElementToBeClickable(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(1000);

		// Perform deposit operation
		waitForElementToBeClickable(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[2]")).click();
		Thread.sleep(500);
		waitForElementToBeVisible(By.xpath("//input[@placeholder='amount']")).sendKeys("900");
		waitForElementToBeClickable(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button")).click();
		Thread.sleep(500);

		// Validate deposit success message
		String alertMsg = accountPage.getDepositSuccessMSG();
		Thread.sleep(500);
		Assert.assertEquals(alertMsg, "Deposit Successful");
		Thread.sleep(500);
	}

	@Test(priority = 8)
	public void Transactions() throws Exception {
		// Login as a customer
		waitForElementToBeClickable(By.xpath("//button[contains(.,'Customer Login')]")).click();
		waitForElementToBeVisible(By.id("userSelect"));
		customerLoginPage.selectUser();
		waitForElementToBeClickable(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(500);
		// Go to Transactions tab and sort transactions
		waitForElementToBeClickable(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[1]")).click();
		Thread.sleep(100);
		waitForElementToBeClickable(By.xpath("(//a[contains(.,'Date-Time')])[1]")).click();

		// Print and validate recent transactions
		String responseString = accountPage.printLastSixTransactions();
		System.out.println("Response: " + responseString);
		String transactionType = accountPage.getLastTransactonType();
		System.out.println("Recent Transaction Type: " + transactionType);
	}

	@Test(priority = 5)
	public void verifyLogin() throws Exception {
		// Login and verify the correct user is logged in
		waitForElementToBeClickable(By.xpath("//button[contains(.,'Customer Login')]")).click();
		waitForElementToBeVisible(By.id("userSelect"));
		String expectedName = customerLoginPage.selectUser();
		waitForElementToBeClickable(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(500);
		String actualName = accountPage.getUserName();
		Assert.assertEquals(expectedName, actualName, "Selected user is not logged in...");
		System.out.println("Expected Name: " + expectedName);
		System.out.println("Logged in Name: " + actualName);
	}

	@Test(priority = 7)
	public void WithdrawMoney() throws Exception {
		// Login as a customer
		waitForElementToBeClickable(By.xpath("//button[contains(.,'Customer Login')]")).click();
		waitForElementToBeVisible(By.id("userSelect"));
		customerLoginPage.selectUser();
		waitForElementToBeClickable(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(500);
		// Perform withdrawal
		waitForElementToBeClickable(By.xpath("//button[contains(.,'Withdrawl')]")).click();
		Thread.sleep(500);
		waitForElementToBeVisible(By.xpath("//input[@placeholder='amount']")).sendKeys("500");
		waitForElementToBeClickable(By.xpath("(//button[contains(.,'Withdraw')])[2]")).click();
		Thread.sleep(500);

		// Validate withdrawal success message
		String alertMsg = accountPage.getWithdarwlSuccessMSG();
		Assert.assertEquals(alertMsg, "Transaction successful");
	}
}
