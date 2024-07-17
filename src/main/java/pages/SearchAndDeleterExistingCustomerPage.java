package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchAndDeleterExistingCustomerPage {

	WebDriver driver;

	By CustomersBtn = By.xpath("//button[contains(text(),'Customers')]");
	By SearchBox = By.xpath("//input[@placeholder='Search Customer']");
	// By CustomerSearchResult= By.xpath("//tr[@class='ng-scope']");
	By DeleteBtn = By.xpath("//button[text()='Delete']");

	public SearchAndDeleterExistingCustomerPage(WebDriver driver) {
		this.driver = driver;
	}

	public void waitForElementToAppear(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void clickCustomersBtn() {

		driver.findElement(CustomersBtn).click();
	}

	public void typeFirstNameInSearchBox(String firstname) {

		driver.findElement(SearchBox).sendKeys(firstname);
	}

//	public WebElement LastNameFieldIsNotEmpty() {
//		
//		 WebElement field = driver.findElement(CustomerSearchResult);
//		 return field;
//	}

	public boolean CheckBtnIsDisplayed() {

		WebElement Delete = driver.findElement(DeleteBtn);
		waitForElementToAppear(Delete);
		return Delete.isDisplayed();
	}

	public void clickONDeleteCustomer() {

		driver.findElement(DeleteBtn).click();
	}

}
