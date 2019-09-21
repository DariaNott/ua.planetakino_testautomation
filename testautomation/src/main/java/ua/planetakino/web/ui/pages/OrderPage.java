package ua.planetakino.web.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class OrderPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'hall-ticket-info__seat-type')]")
    private WebElement seatPrice;

    @FindBy(xpath = "//div[contains(@class,'hall__seat')]")
    private List<WebElement> allSeats;

    @FindBy(xpath = "//div[contains(@class,'mobile-tablet')]//button[contains(@class,'add-to-cart')]")
    private WebElement addToCartButton;

    @FindBy(linkText = "ок, в мене є")
    private WebElement haveGlassesButton;

    @FindBy(linkText = "Куплю у кінотеатрі")
    private WebElement buyGlassesInCinemaButton;

    @FindBy(linkText = "Куплю зараз і отримаю на вході до залу")
    private WebElement buyGlassesNowButton;

    public OrderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public OrderPage addSeat() {
        List<WebElement> availableSeats = getSeatsList();
        click(availableSeats.get(3));
        LOGGER.info("Clicked on an available seat.");
        return this;
    }

    public OrderPage submitOrder() {
        click(addToCartButton);
        LOGGER.info("Clicked on addToCartButton.");
        return this;
    }

    public OrderPage haveGlasses() {
        click(haveGlassesButton);
        LOGGER.info("Clicked on haveGlassesButton.");
        return this;
    }

    public OrderPage buyGlassesInCinema() {
        click(buyGlassesInCinemaButton);
        LOGGER.info("Clicked on buyGlassesInCinemaButton.");
        return this;
    }

    public OrderPage buyGlassesNow() {
        click(buyGlassesNowButton);
        LOGGER.info("Clicked on buyGlassesNowButton.");
        return this;
    }

    private List<WebElement> getSeatsList() {
        List<WebElement> availableSeats = new ArrayList<>();
        for (WebElement seat : allSeats) {
            if (seat.isEnabled()) {
                availableSeats.add(seat);
            }
        }
        return availableSeats;
    }

}
