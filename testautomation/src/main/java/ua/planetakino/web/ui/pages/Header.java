package ua.planetakino.web.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Header {

    private WebDriver driver;

    @FindBy(linkText = "Розклад")
    private WebElement scheduleButton;

    @FindBy(linkText = "Фільми")
    private WebElement moviesButton;

    @FindBy(xpath = "//span[contains(@class,'city-selector__text')]")
    private WebElement cityButton;

    @FindBy(linkText = "Вхід")
    private WebElement logInButton;

    @FindBy(xpath = "//div[contains(@class,'cart__icon')]")
    private WebElement cartIcon;

    @FindBy(xpath = "//div[contains(@class,'cart__countdown')]")
    private WebElement cartCountdown;

    @FindBy(xpath = "//div[contains(@class,'cart__items')]")
    private WebElement cartItems;

    @FindBy (xpath = "//div[contains(@class,'name')]")
    private WebElement accountIcon;

    public Header (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public SchedulePage goToSchedulePage () {
        scheduleButton.click();
        return new SchedulePage(driver);
    }

    public MoviesPage goToMoviesPage () {
        moviesButton.click();
        return new MoviesPage(driver);
    }

    public AccountPage goToAccountPage (){
        accountIcon.click();
        return new AccountPage(driver);
    }

    public AccountPage goToLogIn () {
        logInButton.click();
        return new AccountPage(driver);
    }
}
