package tests;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pages.HomePage;
import pages.OpenNewAccount;

public class TestOpenNewAccount {

	WebDriver driver;
	OpenNewAccount opennewaccount;
	HomePage homepage;

	@BeforeMethod
	public void testSetup() {
		WebDriverManager.chromedriver().clearDriverCache().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		opennewaccount = new OpenNewAccount(driver);
		homepage = new HomePage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.of(5, ChronoUnit.SECONDS));
		driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
	}

	@Test(description = "Test to verify opening new account")
	public void OpenNewAccount() {

		homepage.ClickOnBankManagerLogin();
		opennewaccount.ClickOpenAccountBtn();
		opennewaccount.selectCustomer();
		opennewaccount.selectCurrency();
		opennewaccount.ClickProcess();

		Alert alert = driver.switchTo().alert();
		String ActualAlertText = alert.getText();
		String ExpectedAlertText = "Account created successfully with account Number";
		assertTrue(ActualAlertText.contains(ExpectedAlertText), "Alert text does not contain the expected substring");

//		Assert.assertEquals(ActualAlertText, ExpectedAlertText);

		alert.accept();
		opennewaccount.ClickHome();

	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

}
