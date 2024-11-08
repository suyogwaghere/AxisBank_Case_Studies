package AxisBank.Pages;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AxisBank.Base.TestBase;

public class AccountPage extends TestBase {

	@FindBy(xpath = "//div[@class='borderM box padT20 ng-scope']//div//strong//span")
	WebElement userName;

	// Transaction elements
	@FindBy(xpath = "(//a[contains(.,'Date-Time')])[1]")
	private WebElement sortTransactions;

	@FindBy(xpath = "//*[@id=\"anchor0\"]/td[3]")
	public WebElement lastTransactionType;

	@FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/table")
	public WebElement transactionTable;

	@FindBy(xpath = "(//button[contains(.,'Transactions')])[1]")
	WebElement transactionsTab;

	@FindBy(xpath = "(//button[contains(.,'Reset')])[1]")
	WebElement resetButton;

	// Deposit elements
	@FindBy(xpath = "(//button[contains(.,'Deposit')])[1]")
	WebElement depositTab;

	@FindBy(xpath = "//input[@placeholder='amount']")
	WebElement depositamountField;

	@FindBy(xpath = "(//button[contains(.,'Deposit')])[2]")
	WebElement depositButton;

	@FindBy(xpath = "//span[contains(.,'Deposit Successful')]")
	WebElement depositSuccessMsg;

	// Withdrawal elements
	@FindBy(xpath = "//button[contains(.,'Withdrawl')]")
	WebElement withdrawlTab;

	@FindBy(xpath = "//input[@placeholder='amount']")
	WebElement withdrawlAmountField;

	@FindBy(xpath = "(//button[contains(.,'Withdraw')])[2]")
	WebElement withdrawlButton;

	@FindBy(xpath = "//span[contains(.,'Transaction successful')]")
	WebElement withdrawlSuccessMsg;

	public AccountPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public void clickDepositButton() {
		depositButton.click();
	}

	// Deposit Actions
	public void clickDepositTab() {
		depositTab.click();
	}

	public void clickResetTransactions() {
		resetButton.click();
	}

	public String clickSortTransactions() {
		List<WebElement> rows = transactionTable.findElements(By.tagName("tr"));
		if (rows.size() > 1) {
			sortTransactions.click();
		}
		return "No transactions found";
	}

	public void clickTransactionsTab() {
		transactionsTab.click();
	}

	public void clickWithdrawlButton() {
		withdrawlButton.click();
	}

	// Withdrawal Actions
	public void clickWithdrawlTab() {
		withdrawlTab.click();
	}

	public void enterDepositAmount(String amount) {
		depositamountField.sendKeys(amount);
	}

	public void enterWithdrawlAmount(String amount) {
		withdrawlAmountField.sendKeys(amount);
	}

	// Transactions Actions

	public String getDepositSuccessMSG() {
		return depositSuccessMsg.getText();
	}

	public String getLastTransactonType() {

		List<WebElement> rows = transactionTable.findElements(By.tagName("tr"));
		if (rows.size() > 1) {
			return lastTransactionType.getText();
		}
		return "No transactions found";
	}

	public String getUserName() {
		return userName.getText();
	}

	public String getWithdarwlSuccessMSG() {
		return withdrawlSuccessMsg.getText();
	}

	public String printLastSixTransactions() {

		List<WebElement> rows = transactionTable.findElements(By.tagName("tr"));

		if (rows.size() < 1) {
			return "No transactions found. Total rows: " + rows.size();
		}

		for (int i = 0; i < 7; i++) {
			WebElement row = rows.get(i);
			List<WebElement> columns = row.findElements(By.tagName("td"));

			for (WebElement column : columns) {
				System.out.print(column.getText() + "\t");
			}
			System.out.println();
		}

		return "Displayed last " + Math.min(6, rows.size()) + " transactions.";
	}

}
