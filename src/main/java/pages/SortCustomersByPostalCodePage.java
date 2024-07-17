package pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SortCustomersByPostalCodePage {

	WebDriver driver;

	By CustomersBtn = By.xpath("//button[contains(text(),'Customers')]");

	public SortCustomersByPostalCodePage(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnCustomers() {

		driver.findElement(CustomersBtn).click();

	}

}
