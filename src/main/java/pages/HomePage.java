package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	WebDriver driver;

	By BankManagerLoginBtn = By.xpath("//button[text()='Bank Manager Login']");
	By CustomerLoginBtn = By.xpath("//button[text()='Customer Login']");

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	public void ClickOnBankManagerLogin() {

		driver.findElement(BankManagerLoginBtn).click();
	}

	public void ClickOnCustomerLogin() {

		driver.findElement(CustomerLoginBtn).click();
	}
}
