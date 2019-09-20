package ua.planetakino.web.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends BasePage {

    @FindBy (xpath = "//div[contains(@class,'hall-ticket-info__seat-type')]")
    private WebElement seatPrice;

    @FindBy (xpath = "//div[contains(@class,'hall-scheme__hall')]")
    private WebElement hall;

    public OrderPage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public OrderPage buyAsGuest () {

    }

}
