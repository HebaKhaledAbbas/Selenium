package tests;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.google.gson.stream.JsonReader;

import data.JsonDataReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.CreateCustomerPage;
import pages.HomePage;

//@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class TestCreateCustomer {

	WebDriver driver;
	CreateCustomerPage createCustomer;
	HomePage homepage;

	@BeforeMethod
	public void testSetup() {
		WebDriverManager.chromedriver().clearDriverCache().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		createCustomer = new CreateCustomerPage(driver);
		homepage = new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.of(5, ChronoUnit.SECONDS));
		driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
	}

	@Test(description = "Test to verify customer creation")
	public void CreateCustomer() throws FileNotFoundException, IOException, ParseException {

		JsonDataReader jsonReaderObject = new JsonDataReader();
		jsonReaderObject.JsonReader();

		homepage.ClickOnBankManagerLogin();
		createCustomer.ClickAddCustomerBtn();
		createCustomer.EnterFirstName(jsonReaderObject.FirstName);
		createCustomer.EnterLastName(jsonReaderObject.LastName);
		createCustomer.EnterPostCode(jsonReaderObject.PostCode);
		createCustomer.ClickSubmitAddingCustomer();
		
		Alert alert = driver.switchTo().alert();
		String ActualAlertText = alert.getText();
		String ExpectedAlertText = "Customer added successfully with customer id";
		assertTrue(ActualAlertText.contains(ExpectedAlertText), "Alert text does not contain the expected substring");

		alert.accept();
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
