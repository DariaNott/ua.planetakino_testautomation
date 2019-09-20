package ua.planetakino.web.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ua.planetakino.config.EnvConfig;

public abstract class BasePage {
    protected Header header;
    protected WebDriver driver;
    protected EnvConfig config;

    public BasePage (WebDriver driver) {
        this.driver = driver;
        this.header = new Header(driver);
    }

    public Header getHeader () {
        return new Header(driver);
    }

    public WebElement waitClickability (WebElement element) {
        new WebDriverWait (driver, 10).until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    public  WebElement waitVisibility (WebElement element) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public void click (WebElement element){
        Actions actions = new Actions(driver);
        waitClickability(element);
        actions.moveToElement(element).click().build().perform();
    }
}
