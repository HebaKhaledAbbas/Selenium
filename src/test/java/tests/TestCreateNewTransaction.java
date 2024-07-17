package tests;

import static org.testng.Assert.assertTrue;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.CustomerPage;
import pages.HomePage;

public class TestCreateNewTransaction {
	
	WebDriver driver;
	HomePage homepage;
	CustomerPage customerpage;

	@BeforeMethod
	public void testSetup() {
		WebDriverManager.chromedriver().clearDriverCache().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		homepage = new HomePage(driver);
		customerpage = new CustomerPage(driver);
		driver.manage().timeouts().implicitlyWait(Duration.of(5, ChronoUnit.SECONDS));
		driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
	}

	@Test(description = "Test to verify transaction creation")
	public void TestCreateTransaction() {

		homepage.ClickOnCustomerLogin();
		customerpage.SelectYourNameAndPressLogin();
		customerpage.clickOnDeposit();
		customerpage.enterDepositAmount("5");
        customerpage.clickDepositSubmitBtn();
        boolean messageDisplayed = customerpage.assertSuccessMsgIsDisplayed();
        Assert.assertTrue(messageDisplayed);
        customerpage.NavigateToTransactions();
        
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}


}
