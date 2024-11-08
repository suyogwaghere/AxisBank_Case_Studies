package AxisBank.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import AxisBank.Base.TestBase;

public class Homepage extends TestBase {

	// elements
	@FindBy(xpath = "//button[contains(.,'Customer Login')]")
	WebElement customerlogin;

	@FindBy(xpath = "//button[contains(.,'Bank Manager Login')]")
	WebElement managerlogin;

	@FindBy(xpath = "//strong[contains(.,'XYZ Bank')]")
	WebElement logo;

	public Homepage() {
		PageFactory.initElements(driver, this);
	}

	public CustomerLoginPage customerLoginbtn() throws IOException {
		customerlogin.click();
		return new CustomerLoginPage();
	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public String getPageURL() {
		return driver.getCurrentUrl();
	}

	public BankManagerLoginPage managerLoginBtn() throws IOException {
		managerlogin.click();
		return new BankManagerLoginPage();
	}

	// Actions
	public String verifyLogoText() {
		return logo.getText();
	}
}
