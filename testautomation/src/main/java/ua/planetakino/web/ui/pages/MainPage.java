package ua.planetakino.web.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import ua.planetakino.config.EnvConfig;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //for a demo
    public MainPage openWebsite() {
        driver.get(EnvConfig.getEnvironment().getWebUrl());
        return this;
    }

}
