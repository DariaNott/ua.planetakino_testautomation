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
import io.qameta.allure.Step;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    private static final Logger LOGGER = Logger.getLogger(TestBase.class);

    protected WebDriver driver;
    protected VerifyHelper helper;
    protected MainPage mainPage;

    @Step ("Initializing webdriver and open main page")
    @BeforeMethod
    public void setChrome() {
        helper = new VerifyHelper();
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path + "\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
        mainPage = new MainPage(driver);
        mainPage = mainPage.openWebsite();
        LOGGER.info("Opened page with url " + EnvConfig.getEnvironment().getWebUrl());
    }

    @Step("Closing driver.")
    @AfterMethod
    public void cleanUp() {
        if (driver != null) {
            driver.quit();
        }
        LOGGER.info("Driver closed.");
    }

}
