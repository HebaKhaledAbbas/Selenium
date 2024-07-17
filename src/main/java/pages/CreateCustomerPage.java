package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CreateCustomerPage {

	WebDriver driver;
	// private String url =
	// "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";

	By AddCustomerBtn = By.xpath("//button[contains(text(),'Add Customer')]");
	By FirstNameTextBox = By.xpath("//input[@placeholder='First Name']");
	By LastNameTextBox = By.xpath("//input[@placeholder='Last Name']");
	By PostCodeTextBox = By.xpath("//input[@placeholder='Post Code']");
	By SubmitAddingCustomerBtn = By.xpath("//button[@type='submit']");

	public CreateCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	public void ClickAddCustomerBtn() {

		driver.findElement(AddCustomerBtn).click();
	}

	public void EnterFirstName(String FirstName) {

		driver.findElement(FirstNameTextBox).sendKeys(FirstName);
	}

	public void EnterLastName(String LastName) {

		driver.findElement(LastNameTextBox).sendKeys(LastName);
	}

	public void EnterPostCode(String postcode) {

		driver.findElement(PostCodeTextBox).sendKeys(postcode);
	}

	public void ClickSubmitAddingCustomer() {

		driver.findElement(SubmitAddingCustomerBtn).click();
	}
}
