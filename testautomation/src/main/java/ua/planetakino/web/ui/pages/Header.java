package ua.planetakino.web.ui.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class Header {

    private WebDriver driver;
    protected static final Logger LOGGER = Logger.getLogger(BasePage.class);

    @FindBy(linkText = "Розклад")
    private WebElement scheduleButton;

    @FindBy(linkText = "Фільми")
    private WebElement moviesButton;

    @FindBy(xpath = "//div[contains(@class,'city-selector')]")
    private WebElement cityButton;

    @FindBy(linkText = "Вхід")
    private WebElement logInButton;

    @FindBy(xpath = "//a[contains(@class,'logout')]")
    private WebElement logOutButton;

    @FindBy(xpath = "//ul[@id='citylist']/li//a")
    private List<WebElement> cityList;


    public Header(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SchedulePage goToSchedulePage() {
        scheduleButton.click();
        LOGGER.info("Clicked on scheduleButton.");
        return new SchedulePage(driver);
    }

    public MoviesPage goToMoviesPage() {
        moviesButton.click();
        LOGGER.info("Clicked on moviesButton.");
        return new MoviesPage(driver);
    }

    public AccountPage goToLogIn() {
        logInButton.click();
        LOGGER.info("Clicked on logInButton.");
        return new AccountPage(driver);
    }

    public AccountPage logOut() {
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

    public Header openCitiesList() {
        cityButton.click();
        LOGGER.info("Clicked on cityButton.");
        return this;
    }
}
