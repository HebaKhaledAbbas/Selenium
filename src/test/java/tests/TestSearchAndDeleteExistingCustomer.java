package tests;

import static org.testng.Assert.assertFalse;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.SearchAndDeleterExistingCustomerPage;

public class TestSearchAndDeleteExistingCustomer {

	WebDriver driver;
	SearchAndDeleterExistingCustomerPage searchforexistingcustomer;
	HomePage homepage;

	By DeletedCustomerInfo = By.cssSelector("td.ng-binding");

	@BeforeClass
	public void testSetup() {
		WebDriverManager.chromedriver().clearDriverCache().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		searchforexistingcustomer = new SearchAndDeleterExistingCustomerPage(driver);
		homepage = new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.of(5, ChronoUnit.SECONDS));
		driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
	}

	@Test(description = "Test to verify search on an exist customer by firstname")
	public void SearchForCustomer() {

		homepage.ClickOnBankManagerLogin();
		searchforexistingcustomer.clickCustomersBtn();
		searchforexistingcustomer.typeFirstNameInSearchBox("Ron");
		
//		WebElement lastnamefield = searchforexistingcustomer.LastNameFieldIsNotEmpty();
//		assertFalse(lastnamefield.isEmpty(), "The field is empty");

		boolean isDeleteButtonDisplayed = searchforexistingcustomer.CheckBtnIsDisplayed();
		Assert.assertTrue(isDeleteButtonDisplayed);
		
	}

	@Test(description = "Test to verify Delete Customer")
	public void TestDeleteCustomer(){

		searchforexistingcustomer.clickONDeleteCustomer();
		
		List<WebElement> elements = driver.findElements(By.className("DeletedCustomerInfo"));
		for (WebElement element : elements) {
			assertFalse(element.isDisplayed(), "Element is still displayed: " + element);
		}

	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

}
