package ua.planetakino;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ua.planetakino.config.EnvConfig;
import ua.planetakino.helper.VerifyHelper;
import ua.planetakino.web.ui.drivers.WebDriverFactory;
import ua.planetakino.web.ui.pages.MainPage;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    private static final Logger LOGGER = Logger.getLogger(TestBase.class);

    protected WebDriver driver;
    protected VerifyHelper helper;
    protected MainPage mainPage;

    @BeforeMethod
    public void setChrome() {
        helper = new VerifyHelper();
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().pageLoadTimeout(EnvConfig.getEnvironment().getTimeoutPageLoad(), TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(EnvConfig.getEnvironment().getImplicitlyWait(), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        mainPage = new MainPage(driver);
        mainPage = mainPage.openWebsite();
        LOGGER.info("Opened page with url " + EnvConfig.getEnvironment().getWebUrl());
    }

    @AfterMethod
    public void cleanUp() {
        if (driver != null) {
            driver.quit();
        }
        LOGGER.info("Driver closed.");
    }

}
