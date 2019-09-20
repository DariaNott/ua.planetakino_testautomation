package ua.planetakino.web.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MoviesPage extends BasePage {

    @FindBy(xpath = "//a[contains(@class,'poster')]")
    private WebElement moviePoster;

    @FindBy(id = "ytplayer")
    private WebElement headTrailerPlayer;

    public MoviesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MoviesPage openFirstMovieDetails() {
        click(moviePoster);
        return this;
    }

    public boolean getPlayerPresenceStatus() {
        boolean status = false;
        if (headTrailerPlayer == null) {
            status = true;
        }
        return status;
    }
}

