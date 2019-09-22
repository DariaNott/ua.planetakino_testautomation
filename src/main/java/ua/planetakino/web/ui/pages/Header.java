package ua.planetakino.web.ui.pages;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class Header {

    private WebDriver driver;

    protected static final Logger LOGGER = Logger.getLogger(BasePage.class);

    @FindBy(xpath = "//li/a[contains(@href,'showtimes')]")
    private WebElement scheduleButton;

    @FindBy(xpath = "//li/a[contains(@href,'movies')]")
    private WebElement moviesButton;

    @FindBy(xpath = "//div[contains(@class,'city-selector')]")
    private WebElement cityButton;

    @FindBy(xpath = "//a[contains(@href,'enter')]")
    private WebElement logInButton;

    @FindBy(xpath = "//a[contains(@class,'logout')]")
    private WebElement logOutButton;

    @FindBy(xpath = "//ul[@id='citylist']/li//a")
    private List<WebElement> cityList;


    public Header(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("Clicking on 'Schedule' button in header")
    public SchedulePage goToSchedulePage() {
        waitClickability(scheduleButton);
        scheduleButton.click();
        LOGGER.info("Clicked on scheduleButton.");
        return new SchedulePage(driver);
    }

    @Step("Clicking on 'Movies' button in header")
    public MoviesPage goToMoviesPage() {
        waitClickability(moviesButton);
        moviesButton.click();
        LOGGER.info("Clicked on moviesButton.");
        return new MoviesPage(driver);
    }

    @Step("Clicking on 'Log in' button in header")
    public AccountPage goToLogIn() {
        waitClickability(logInButton);
        logInButton.click();
        LOGGER.info("Clicked on logInButton.");
        return new AccountPage(driver);
    }

    @Step("Clicking on 'Log out' icon in header")
    public AccountPage logOut() {
        waitClickability(logOutButton);
        logOutButton.click();
        LOGGER.info("Clicked on logOutButton.");
        return new AccountPage(driver);
    }

    public List<String> getCitiesAndTheatersList() {
        List<String> citiesAndTheatersNames = new ArrayList<>();
        for (WebElement city : cityList) {
            citiesAndTheatersNames.add(city.getText());
        }
        return citiesAndTheatersNames;
    }

    @Step("Clicking on cities button in header")
    public Header openCitiesList() {
        waitClickability(cityButton);
        cityButton.click();
        LOGGER.info("Clicked on cityButton.");
        return this;
    }

    private WebElement waitClickability(WebElement element) {
        new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }
}
