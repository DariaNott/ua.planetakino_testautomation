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
        LOGGER.info("Clicked on scheduleButton.");
        waitClickability(scheduleButton);
        scheduleButton.click();
        return new SchedulePage(driver);
    }

    @Step("Clicking on 'Movies' button in header")
    public MoviesPage goToMoviesPage() {
        LOGGER.info("Clicked on moviesButton.");
        waitClickability(moviesButton);
        moviesButton.click();
        return new MoviesPage(driver);
    }

    @Step("Clicking on 'Log in' button in header")
    public AccountPage goToLogIn() {
        LOGGER.info("Clicked on logInButton.");
        waitClickability(logInButton);
        logInButton.click();
        return new AccountPage(driver);
    }

    @Step("Clicking on 'Log out' icon in header")
    public AccountPage logOut() {
        LOGGER.info("Clicked on logOutButton.");
        waitClickability(logOutButton);
        logOutButton.click();
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
        LOGGER.info("Clicked on cityButton.");
        waitClickability(cityButton);
        cityButton.click();
        return this;
    }

    private WebElement waitClickability(WebElement element) {
        new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }
}
