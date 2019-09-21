package ua.planetakino.web.ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class OrderPage extends BasePage {

    @FindBy(xpath = "//div[contains(@class,'hall-ticket-info__seat-type')]")
    private WebElement seatPrice;

    @FindBy(xpath = "//div[contains(@class,'hall__seat')]")
    private List<WebElement> allSeats;

    @FindBy(xpath = "//div[contains(@class,'mobile-tablet')]//button[contains(@class,'add-to-cart')]")
    private WebElement addToCartButton;


    public OrderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Clicking on a seat icon to add it to the cart.")
    public OrderPage addSeat() {
        List<WebElement> availableSeats = getSeatsList();
        click(availableSeats.get(3));
        LOGGER.info("Clicked on an available seat.");
        return this;
    }

    @Step("Clicking on 'Add to cart' button.")
    public OrderPage submitOrder() {
        click(addToCartButton);
        LOGGER.info("Clicked on addToCartButton.");
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
