package ua.planetakino.web.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class MoviesPage extends BasePage {

    @FindBy(xpath = "//a[contains(@class,'poster')]")
    private WebElement moviePoster;

    @FindBy(id = "ytplayer")
    private WebElement headTrailerPlayer;

    @FindBy (xpath = "//a[contains(@class,'buy-online-banner_glasses')]")
    private WebElement aboutGlassesButton;

    public MoviesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public MoviesPage openFirstMovieDetails() {
        click(moviePoster);
        LOGGER.info("Clicked on moviePoster.");
        return this;
    }

    public MoviesPage openAboutGlassInfo () {
        click(aboutGlassesButton);
        LOGGER.info("Clicked on aboutGlassesButton.");
        return this;
    }

    public boolean getPlayerPresenceStatus() {
        boolean status = false;
        if (headTrailerPlayer != null) {
            status = true;
        }
        return status;
    }
}

