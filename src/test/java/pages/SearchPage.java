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

public class SearchPage {
    @FindBy(className = "search-empty-button")
    WebElement searchIcon;
    @FindBy(id = "search")
    WebElement searchInput;
    @FindBy(className = "search-button")
    WebElement searchButton;
    @FindBy(className = "link-item")
    List<WebElement> moviesCount;

    WebDriver driver;
    WebDriverWait wait;
    public SearchPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    public void clickSearchIcon(){
        searchIcon.click();
    }
    public void clickSearchButton(){
        searchButton.click();
    }
    public int getMoviesCount(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("link-item")));
        return moviesCount.size();
    }
    public void enterSearchText(String searchText){
        searchInput.sendKeys(searchText);
    }
    public void search(String searchText){
        enterSearchText(searchText);
        clickSearchButton();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("movie-image")));
    }
}
