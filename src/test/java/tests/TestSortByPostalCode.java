package tests;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.CreateCustomerPage;
import pages.HomePage;
import pages.SortCustomersByPostalCodePage;

public class TestSortByPostalCode {

	WebDriver driver;
	CreateCustomerPage createCustomer;
	HomePage homepage;
	SortCustomersByPostalCodePage sortByPostalCode;

	By PostCodeLink = By.xpath("//a[@href='#'][contains(text(),'Post Code')]");
	By PostCodesValues = By.xpath("//tbody/tr/td[3]");

	@BeforeClass
	public void testSetup() {
		WebDriverManager.chromedriver().clearDriverCache().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		createCustomer = new CreateCustomerPage(driver);
		homepage = new HomePage(driver);
		sortByPostalCode = new SortCustomersByPostalCodePage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.of(5, ChronoUnit.SECONDS));
		driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
	}

	@Test(description = "Test to verify sorting descending by postalcode")
	public void SortDescendingByPostalCode() {

		homepage.ClickOnBankManagerLogin();
		sortByPostalCode.clickOnCustomers();

		driver.findElement(PostCodeLink).click();
		List<WebElement> postalCodeElements = driver.findElements(PostCodesValues);

		// Extract the text values of the postal codes
		List<String> postalCodes = new ArrayList<>();
		for (WebElement element : postalCodeElements) {
			postalCodes.add(element.getText());
		}

		// Create a copy of the list and sort it
		List<String> sortedPostalCodes = new ArrayList<>(postalCodes);
		Collections.sort(sortedPostalCodes);
		Collections.reverse(sortedPostalCodes);

		assertEquals(sortedPostalCodes, postalCodes, "Postal codes are not sorted in descending order");

	}

	@Test(description = "Test to verify sorting ascending by postalcode")
	public void SortAscendingByPostalCode() {

		driver.findElement(PostCodeLink).click();
		List<WebElement> postalCodeElements = driver.findElements(PostCodesValues);

		// Extract the text values of the postal codes
		List<String> postalCodes = new ArrayList<>();
		for (WebElement element : postalCodeElements) {
			postalCodes.add(element.getText());
		}

		// Create a copy of the list and sort it
		List<String> sortedPostalCodes = new ArrayList<>(postalCodes);
		Collections.sort(sortedPostalCodes);

		assertEquals(sortedPostalCodes, postalCodes, "Postal codes are not sorted in ascending order");

	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

}
