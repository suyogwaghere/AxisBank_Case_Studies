package AxisBank.Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import AxisBank.Base.TestBase;

public class CustomerLoginPage extends TestBase {

	// elements
	@FindBy(xpath = "//select[@id='userSelect']")
	WebElement YourNameDropdown;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement loginBtn;

	public CustomerLoginPage() throws IOException {
		PageFactory.initElements(driver, this);
	}

	public AccountPage clickloginbtn() throws Exception {
		loginBtn.click();

		return new AccountPage();
	}

	// Actions
	public String selectUser() {
		Select selectCustomer = new Select(YourNameDropdown);
		selectCustomer.selectByIndex(1);
		String selecteduser = selectCustomer.getFirstSelectedOption().getText();

		return selecteduser;
	}
}
