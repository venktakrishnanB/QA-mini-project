package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class LoginPage {
    @FindBy(className = "login-website-logo")
    WebElement websiteLogoImage;
    @FindBy(className = "sign-in-heading")
    WebElement headingText;
    @FindBy(className = "input-label")
    List<WebElement> labelText;
    @FindBy(id = "usernameInput")
    WebElement userNameElement;
    @FindBy(id = "passwordInput")
    WebElement passwordElement;
    @FindBy(className = "login-button")
    WebElement loginButton;
    @FindBy(className = "error-message")
    WebElement errorMessage;
    WebDriver driver;
    WebDriverWait wait;
    public LoginPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    public WebElement findWebsiteLogo(){
        return  websiteLogoImage;
    }
    public String getHeadingText(){
        return headingText.getText();
    }
    public String getLabelTextAt(int index){
        return labelText.get(index).getText();
    }
    public void enterUserId(String userName){
        userNameElement.sendKeys(userName);
    }
    public void enterPassword(String password){
        passwordElement.sendKeys(password);
    }
    public void clickLoginButton(){
        loginButton.click();
    }
    public void login(String userName, String password){
        enterUserId(userName);
        enterPassword(password);
        clickLoginButton();
    }
    public String getErrorMessageText(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-message")));
        return errorMessage.getText();
    }
}
