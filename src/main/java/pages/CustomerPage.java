package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CustomerPage {

	WebDriver driver;

	By YourNameDropDown = By.xpath("//select[@id='userSelect']");
	By loginBtn = By.xpath("//button[@type='submit']");
	By DepositBtn = By.xpath("//button[contains(text(),'Deposit')]");
	By DepositTextBox = By.xpath("//input[@type='number']");
	By DepositSubmitBtn = By.xpath("//button[@type='submit']");
	By SuccessMsg = By.xpath("//span[text()='Deposit Successful']");
	By TransactionsBtn = By.xpath("//button[contains(text(),'Transactions')]");

	public CustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	public void SelectYourNameAndPressLogin() {

		WebElement dropdown = driver.findElement(YourNameDropDown);
		Select dropDown = new Select(dropdown);
		dropDown.selectByVisibleText("Harry Potter");

		driver.findElement(loginBtn).click();
	}

	public void clickOnDeposit() {

		driver.findElement(DepositBtn).click();
	}

	public void enterDepositAmount(String deposit) {

		driver.findElement(DepositTextBox).sendKeys(deposit);
	}

	public void clickDepositSubmitBtn() {

		driver.findElement(DepositSubmitBtn).click();
	}
	
	public boolean assertSuccessMsgIsDisplayed() {
		
		return driver.findElement(SuccessMsg).isDisplayed();
	}

	public void NavigateToTransactions() {

		driver.findElement(TransactionsBtn).click();
	}

}
