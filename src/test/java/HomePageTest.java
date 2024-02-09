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

public class HomePageTest {
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
    public void testHomePageHeadingTexts(){
        Assert.assertTrue(homePage.findMovieNameHeading().isDisplayed(), "Movie Name Heading is not displayed");
        Assert.assertEquals(homePage.getFirstHeading(), "Trending Now", "Heading does not matched");
        Assert.assertEquals(homePage.getSecondHeading(), "Originals", "Heading does not matched");
    }
    @Test(priority = 2)
    public void testPlayButtonUi(){
        Assert.assertTrue(homePage.findPlayButton().isDisplayed(),"Movie play button is not displayed");
    }
    @Test(priority = 3)
    public void testMovieList(){
        int count = 0;
        for(int i = 0; i < homePage.findListOfMovies(); i++){
            count++;
        }
        Assert.assertEquals(homePage.findListOfMovies(), count, "All movie are displayed");
    }
    @Test(priority = 4)
    public void testContactSection(){
        Assert.assertTrue(homePage.findSocialMediaContactElements().isDisplayed(), "Social media accounts icons are not displayed");
        Assert.assertEquals(homePage.getContactUsText(), "Contact Us", "Actual text is not matched with the expected text");
    }
}
