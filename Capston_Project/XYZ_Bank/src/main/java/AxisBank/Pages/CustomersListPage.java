package AxisBank.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AxisBank.Base.TestBase;

public class CustomersListPage extends TestBase {

	// elements
	@FindBy(xpath = "//input[@placeholder='Search Customer']")
	WebElement searchField;

	@FindBy(xpath = "(//table/tbody/tr/td)[1]")
	WebElement firstlistedName;

	public CustomersListPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public String getSearchedName() {
		return firstlistedName.getText();
	}

	// Actions
	public void search(String name) {
		searchField.sendKeys(name);
	}

}
