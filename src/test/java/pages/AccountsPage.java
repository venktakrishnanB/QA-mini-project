package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountsPage {
    @FindBy(className = "account-heading")
    WebElement accountHeading;
    @FindBy(className = "membership-username")
    WebElement userNameText;
    @FindBy(className = "membership-password")
    WebElement passwordText;
    @FindBy(className = "plan-paragraph")
    WebElement planDetailsOne;
    @FindBy(className = "plan-details")
    WebElement planDetailsTwo;
    @FindBy(className = "logout-button")
    WebElement logoutButton;

    WebDriver driver;
    WebDriverWait wait;
    public AccountsPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    public String getAccountsHeadingText(){
        return accountHeading.getText();
    }
    public String getUserNameText(){
        return userNameText.getText();
    }
    public String getPasswordText(){
        return passwordText.getText();
    }
    public String getPlanDetailsOneText(){
        return planDetailsOne.getText();
    }
    public String getPlanDetailsTwoText(){
        return planDetailsTwo.getText();
    }
    public void clickLogoutButton(){
        logoutButton.click();
    }
}
