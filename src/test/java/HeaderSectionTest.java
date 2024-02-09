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

import java.time.Duration;

public class HeaderSectionTest {
    public WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "F:\\chromedriver-win32 (1)\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

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
    public void testHeaderSectionUi(){
        Assert.assertTrue(homePage.findWebsiteLogo().isDisplayed(), "Website Logo is displayed");
    }
    @Test(priority = 2)
    public void testNavigationByPopularLink(){
        homePage.clickNavPopularLink();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qamoviesapp.ccbp.tech/popular", "Expected Navigation to popular page was failed");
    }
    @Test(priority = 3)
    public void testNavigationByHomeLink(){
        homePage.clickNavPopularLink();
        homePage.clickNavHomeLink();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qamoviesapp.ccbp.tech/", "Expected Navigation to home page was failed");
    }
    @Test(priority = 4)
    public void testNavigationByAccountsPage(){
        homePage.clickAccountsPage();
        Assert.assertEquals(driver.getCurrentUrl(), "https://qamoviesapp.ccbp.tech/account", "Expected Navigation to accounts page was failed");
    }
}
