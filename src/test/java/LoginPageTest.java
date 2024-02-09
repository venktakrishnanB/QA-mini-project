import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.time.Duration;

public class LoginPageTest {
    public WebDriver driver;
    LoginPage loginPage;
    @BeforeMethod
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "F:\\chromedriver-win32 (1)\\chromedriver-win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://qamoviesapp.ccbp.tech");
        loginPage = new LoginPage(driver);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
    @Test(priority = 1)
    public void testLoginPageUi(){
        Assert.assertTrue(loginPage.findWebsiteLogo().isDisplayed(), "Website logo image is not displayed");
        Assert.assertEquals(loginPage.getHeadingText(), "Login", "Heading text does not matched");
        Assert.assertEquals(loginPage.getLabelTextAt(0), "USERNAME", "Username label text does not match");
        Assert.assertEquals(loginPage.getLabelTextAt(1), "PASSWORD", "Password label text does not match");
    }
    @Test(priority = 2)
    public void testLoginWithEmptyInputs(){
        loginPage.clickLoginButton();
        Assert.assertEquals(loginPage.getErrorMessageText(), "*Username or password is invalid", "Error text with empty input fields does not match");
    }
    @Test(priority = 3)
    public void testLoginWithEmptyUsername(){
        loginPage.login("", "rahul@2021");
        Assert.assertEquals(loginPage.getErrorMessageText(), "*Username or password is invalid", "Error text with empty username do not match");
    }
    @Test(priority = 4)
    public void testLoginWithEmptyPassword(){
        loginPage.login("rahul", "");
        Assert.assertEquals(loginPage.getErrorMessageText(), "*Username or password is invalid", "Error text with empty password do not match");
    }
    @Test(priority = 5)
    public void testLoginWithInvalidCreds(){
        loginPage.login("rahul", "rahul");
        Assert.assertEquals(loginPage.getErrorMessageText(), "*username and password didn't match", "Error text with invalid password do not match");
    }
    @Test(priority = 6)
    public void testLoginWithValidCreds(){
        loginPage.login("rahul", "rahul@2021");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://qamoviesapp.ccbp.tech/"));
        Assert.assertEquals(driver.getCurrentUrl(), "https://qamoviesapp.ccbp.tech/", "URLs do not match");
    }
}
