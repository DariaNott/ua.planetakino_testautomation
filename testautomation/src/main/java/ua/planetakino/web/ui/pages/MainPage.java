package ua.planetakino.web.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //for a demo
    public MainPage openWebsite() {
        driver.get("https://planetakino.ua/");
        return this;
    }

}
