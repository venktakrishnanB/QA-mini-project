import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.HomePage;
import pages.AccountsPage;

import java.time.Duration;

public class AccountPageTest {
    public WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    AccountsPage accountsPage;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "F:\\chromedriver-win32 (1)\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        accountsPage = new AccountsPage(driver);

        loginPage.login("rahul", "rahul@2021");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("home-movie-heading")));
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test(priority = 1)
    public void testAccountsPageUi(){
        homePage.clickAccountsPage();
        Assert.assertEquals(accountsPage.getAccountsHeadingText(), "Account", "Heading does not matched");
        Assert.assertEquals(accountsPage.getUserNameText(), "User name : rahul", "Username does not matched");
        Assert.assertEquals(accountsPage.getPasswordText(), "Password : **********", "Expected text does not matched");
        Assert.assertEquals(accountsPage.getPlanDetailsOneText(), "Premium", "Expected Plan text does not matched");
        Assert.assertEquals(accountsPage.getPlanDetailsTwoText(), "Ultra HD", "Expected Video quality does not matched");
    }
    @Test(priority = 2)
    public void testAccountLogoutFunction(){
        homePage.clickAccountsPage();
        accountsPage.clickLogoutButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qamoviesapp.ccbp.tech/login", "Url does not matched");
    }
}
