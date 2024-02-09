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

public class HomePage {
    @FindBy(className = "home-movie-heading")
    WebElement movieNameHeading;
    @FindBy(className = "movies-list-heading")
    WebElement trendingNowHeading;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[2]/h1")
    WebElement originalsHeading;
    @FindBy(className = "home-movie-play-button")
    WebElement playButton;
    @FindBy(className = "link-item")
    List<WebElement> movieList;
    @FindBy(className = "footer-icons-container")
    WebElement socialMediaContactElements;
    @FindBy(className = "contact-us-paragraph")
    WebElement contactUsText;
    @FindBy(className = "website-logo")
    WebElement websiteLogo;
    @FindBy(linkText = "Home")
    WebElement navHomeLink;
    @FindBy(linkText = "Popular")
    WebElement navPopularLink;
    @FindBy(className = "avatar-button")
    WebElement accountsPage;
    @FindBy(xpath = "/html/body/div[1]/div/div[2]/div[1]/div/div/div/div/div[1]/div/a/div/img")
    WebElement homePageMovie;
    @FindBy(className = "movie-title")
    WebElement movieTitle;
    @FindBy(className = "movie-overview")
    WebElement movieDescription;
    @FindBy(className = "play-button")
    WebElement moviePlayButton;
    @FindBy(className = "detailed-movie-categories-container")
    WebElement movieInformation;
    @FindBy(className = "similar-movies-heading")
    WebElement moreMoviesTitle;
    @FindBy(className = "image-style")
    WebElement moreMoviesElement;
    @FindBy(className = "footer-icons-container")
    WebElement socialMediaContactEl;
    @FindBy(className = "contact-us-paragraph")
    WebElement contactUsTextElement;
    WebDriver driver;
    WebDriverWait wait;
    public HomePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }
    public WebElement findMovieNameHeading(){
        return  movieNameHeading;
    }
    public String getFirstHeading(){
        return trendingNowHeading.getText();
    }
    public String getSecondHeading(){
        return originalsHeading.getText();
    }
    public WebElement findPlayButton(){
         return playButton;
    }
    public int findListOfMovies(){
        return movieList.size();
    }
    public WebElement findSocialMediaContactElements(){
        return socialMediaContactElements;
    }
    public String getContactUsText(){
        return contactUsText.getText();
    }
    public WebElement findWebsiteLogo(){
        return websiteLogo;
    }
    public void clickNavHomeLink(){
        navHomeLink.click();
    }
    public void clickNavPopularLink(){
        navPopularLink.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("movie-image")));
    }
    public void clickAccountsPage(){
        accountsPage.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("account-heading")));
    }
    public void clickHomePageMovie(){
        homePageMovie.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("movie-title")));
    }
    public String getMovieTitle(){
        return movieTitle.getText();
    }
    public String getMovieDescription(){
        return movieDescription.getText();
    }
    public WebElement findMoviePlayButton(){
        return moviePlayButton;
    }
    public WebElement getMovieInformation(){
        return movieInformation;
    }
    public String getMoreMoviesTitle(){
        return moreMoviesTitle.getText();
    }
    public WebElement findMoreMoviesElement(){
        return moreMoviesElement;
    }
    public WebElement getSocialMediaContactEl(){
        return socialMediaContactEl;
    }
    public String getContactUsTextEl(){
        return contactUsTextElement.getText();
    }
}
