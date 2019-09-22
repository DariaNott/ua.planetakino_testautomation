package ua.planetakino.web.ui.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected Header header;
    protected WebDriver driver;
    protected static final Logger LOGGER = Logger.getLogger(BasePage.class);


    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.header = new Header(driver);
    }

    public Header getHeader() {
        return new Header(driver);
    }

    public WebDriver getWebDriver() {
        return driver;
    }

    public WebElement waitClickability(WebElement element) {
        new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    public void click(WebElement element) {
        Actions actions = new Actions(driver);
        waitClickability(element);
        actions.moveToElement(element).click().build().perform();
    }

    public String getCurrentURL() {
        String url = driver.getCurrentUrl();
        return url;
    }

    public void scrollInView(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        waitClickability(element);
    }

    public void scrollPageToBottom() {
        ((JavascriptExecutor) driver)
                .executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}
