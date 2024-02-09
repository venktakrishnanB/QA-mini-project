package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PopularPage {
    @FindBy(className = "movie-image")
    WebElement moviesElement;
    @FindBy(xpath = "/html/body/div[1]/div/div[1]/li[1]/a/img")
    WebElement popularMovieElement;
    @FindBy(className = "movie-title")
    WebElement popularMovieTitle;
    @FindBy(className = "movie-overview")
    WebElement popularMovieDescription;
    @FindBy(className = "play-button")
    WebElement popularMoviePlayButton;
    @FindBy(className = "detailed-movie-categories-container")
    WebElement popularMovieInformation;
    @FindBy(className = "similar-movies-heading")
    WebElement moreMoviesHeading;
    @FindBy(className = "image-style")
    WebElement moreMoviesElement;
    @FindBy(className = "footer-icons-container")
    WebElement contactUsOnSocialMedia;
    @FindBy(className = "contact-us-paragraph")
    WebElement contactUsText;
    WebDriver driver;
    WebDriverWait wait;
    public PopularPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    public WebElement findMoviesElements(){
        return moviesElement;
    }
    public void clickPopularMovie(){
        popularMovieElement.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("movie-title")));
    }
    public String getPopularMovieHeading(){
        return popularMovieTitle.getText();
    }
    public String getPopularMovieDescription(){
        return popularMovieDescription.getText();
    }
    public WebElement findPopularMoviePlayButton(){
        return popularMoviePlayButton;
    }
    public WebElement getPopularMovieInformation(){
        return popularMovieInformation;
    }
    public String getMoreMoviesHeadingText(){
        return moreMoviesHeading.getText();
    }
    public WebElement findMoreMoviesElement(){
        return moreMoviesElement;
    }
    public WebElement findContactUsOnSocialMediaIcons(){
        return contactUsOnSocialMedia;
    }
    public String getContactUsText(){
        return contactUsText.getText();
    }
}
