package AxisBank.Pages;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import AxisBank.Base.TestBase;

public class OpenAccountPage extends TestBase {

	// elements
	@FindBy(xpath = "(//select)[1]")
	WebElement customerDropdown;

	@FindBy(xpath = "(//select)[2]")
	WebElement currencyDropdown;

	@FindBy(xpath = "//button[contains(.,'Process')]")
	WebElement processBtn;

	public OpenAccountPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	// Actions

	public String acceptAlert() {
		Alert alert = driver.switchTo().alert();
		String alText = alert.getText();
		alert.accept();
		return alText;
	}

	public void clickProcessBtn() {
		processBtn.click();
	}

	public void selectCurrency() {
		Select selectCurrency = new Select(currencyDropdown);
		selectCurrency.selectByIndex(2);
	}

	public void selectCustomer() {
		Select selectCustomer = new Select(customerDropdown);
		selectCustomer.selectByIndex(1);
	}

}
