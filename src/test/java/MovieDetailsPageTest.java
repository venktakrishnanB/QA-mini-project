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
import pages.PopularPage;

import java.time.Duration;

public class MovieDetailsPageTest {
    public WebDriver driver;
    LoginPage loginPage;
    HomePage homePage;
    PopularPage popularPage;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "F:\\chromedriver-win32 (1)\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");

        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        popularPage = new PopularPage(driver);

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
    public void testHomePageMovieUi(){
        homePage.clickHomePageMovie();
        Assert.assertEquals(homePage.getMovieTitle(), "No Time to Die", "Movie Title is not matched");
        Assert.assertEquals(homePage.getMovieDescription(), "Bond has left active service and is enjoying a tranquil life in Jamaica. His peace is short-lived when his old friend Felix Leiter from the CIA turns up asking for help. The mission to rescue a kidnapped scientist turns out to be far more treacherous than expected, leading Bond onto the trail of a mysterious villain armed with dangerous new technology.", "Movie description is not matched");
        Assert.assertTrue(homePage.findMoviePlayButton().isDisplayed(), "Play Button is not displayed");
        Assert.assertTrue(homePage.getMovieInformation().isDisplayed(), "Movie information is not displayed");
        Assert.assertEquals(homePage.getMoreMoviesTitle(), "More like this", "Heading is not matched");
        Assert.assertTrue(homePage.findMoreMoviesElement().isDisplayed(), "More movies are not displayed");
        Assert.assertTrue(homePage.getSocialMediaContactEl().isDisplayed(), "Social media contact icons are not displayed");
        Assert.assertEquals(homePage.getContactUsTextEl(), "Contact Us", "Text does not matched");
    }
    @Test(priority = 2)
    public void testPopularPageMovieUi(){
        homePage.clickNavPopularLink();
        popularPage.clickPopularMovie();
        Assert.assertEquals(popularPage.getPopularMovieHeading(), "Venom", "Movie Title is not matched");
        Assert.assertEquals(popularPage.getPopularMovieDescription(), "nvestigative journalist Eddie Brock attempts a comeback following a scandal, but accidentally becomes the host of Venom, a violent, super powerful alien symbiote.", "Movie description is not matched");
        Assert.assertTrue(popularPage.findPopularMoviePlayButton().isDisplayed(), "Play Button is not displayed");
        Assert.assertTrue(popularPage.getPopularMovieInformation().isDisplayed(), "Movie information is not displayed");
        Assert.assertEquals(popularPage.getMoreMoviesHeadingText(), "More like this", "Heading is not matched");
        Assert.assertTrue(popularPage.findMoreMoviesElement().isDisplayed(), "More movies are not displayed");
        Assert.assertTrue(popularPage.findContactUsOnSocialMediaIcons().isDisplayed(), "Social media contact icons are not displayed");
        Assert.assertEquals(popularPage.getContactUsText(), "Contact Us", "Text does not matched");
    }
}
