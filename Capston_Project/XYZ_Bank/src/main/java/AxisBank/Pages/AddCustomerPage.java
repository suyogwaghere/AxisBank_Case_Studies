package AxisBank.Pages;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AxisBank.Base.TestBase;

public class AddCustomerPage extends TestBase {

	// elements
	@FindBy(xpath = "//input[@placeholder='First Name']")
	WebElement firstNameField;

	@FindBy(xpath = "//input[@placeholder='Last Name']")
	WebElement lastnameField;

	@FindBy(xpath = "//input[@placeholder='Post Code']")
	WebElement postCodeField;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement addCustomerBtn;

	public AddCustomerPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public String acceptAlert() {
		Alert alert = driver.switchTo().alert();
		String alertText = alert.getText();
		alert.accept();

		return alertText;
	}

	public void clickaddCustBtn() {
		addCustomerBtn.click();
	}

	// Actions
	public void enterFName(String fName) {
		firstNameField.sendKeys(fName);
	}

	public void enterLName(String lName) {
		lastnameField.sendKeys(lName);
	}

	public void enterPCode(String code) {
		postCodeField.sendKeys(code);
	}
}
