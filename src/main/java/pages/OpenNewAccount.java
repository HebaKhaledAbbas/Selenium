package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class OpenNewAccount {

	WebDriver driver;
	
	By OPenAccountBtn = By.xpath("//button[contains(text(),'Open Account')]");
	By CustomerDropDown = By.xpath("//select[@id='userSelect']");
	By CurrencyDropDown = By.xpath("//select[@id='currency']");
	By ProcessBtn = By.xpath("//button[@type='submit']");
	By SubmitAddingCustomerBtn = By.xpath("//button[@type='submit']");
	By HomeBtn = By.xpath("//button[text()='Home']");

	public OpenNewAccount(WebDriver driver) {
		this.driver = driver;
	}

	public void ClickOpenAccountBtn() {

		driver.findElement(OPenAccountBtn).click();
	}

	public void selectCustomer() {

		WebElement customerDropDown = driver.findElement(CustomerDropDown);
		Select dropdown = new Select(customerDropDown);
		dropdown.selectByVisibleText("Hermoine Granger");

	}

	public void selectCurrency() {

		WebElement currencydropdown = driver.findElement(CurrencyDropDown);
		Select dropdown = new Select(currencydropdown);
		dropdown.selectByVisibleText("Dollar");
	}

	public void ClickProcess() {

		driver.findElement(ProcessBtn).click();
	}

	public void ClickHome() {

		driver.findElement(HomeBtn).click();
	}

}
