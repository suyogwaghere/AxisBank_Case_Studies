package AxisBank.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AxisBank.Base.TestBase;

public class BankManagerLoginPage extends TestBase {

	// elements
	@FindBy(xpath = "//button[contains(text(),'Add Customer')]")
	WebElement addCustomerTab;

	@FindBy(xpath = "//button[contains(text(),'Open Account')]")
	WebElement openAccountTab;

	@FindBy(xpath = "//button[contains(normalize-space(), \"Customers\")]")
	WebElement customersTab;

	public BankManagerLoginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	// Actions

	public AddCustomerPage clickaddCustomerTab() throws IOException {
		addCustomerTab.click();
		return new AddCustomerPage();
	}

	public CustomersListPage clickCustomersTab() throws IOException {
		customersTab.click();
		return new CustomersListPage();
	}

	public OpenAccountPage clickopenAccountTab() throws Exception {
		openAccountTab.click();
		return new OpenAccountPage();
	}

}
