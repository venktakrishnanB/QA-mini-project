import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.HomePage;
import pages.SearchPage;

import java.time.Duration;

public class SearchPageTest {
    public WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    SearchPage searchPage;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "F:\\chromedriver-win32 (1)\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);

        loginPage.login("rahul", "rahul@2021");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("home-movie-heading")));
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @DataProvider
    public Object[][] moviesDataCount(){
        return new Object[][] {
                {"Venom", 2},
                {"Spider-man", 3},
                {"Black widow", 1},
                {"Luca", 1},
                {"Dragon fury", 1}
        };
    }
    @Test(dataProvider = "moviesDataCount")
    public void testSearchFunctionality(String searchText, int expectedCount){
        searchPage.clickSearchIcon();
        searchPage.search(searchText);
        int actualCount = searchPage.getMoviesCount();
        Assert.assertEquals(expectedCount, actualCount, "Movies count does not match");

    }
}
