package ua.planetakino;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import ua.planetakino.config.EnvConfig;
import ua.planetakino.helper.VerifyHelper;
import ua.planetakino.web.ui.pages.MainPage;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    private static Logger LOGGER = Logger.getLogger(TestBase.class);

    protected WebDriver driver;
    protected EnvConfig config;
    protected VerifyHelper helper;
    protected MainPage mainPage;

    @BeforeTest
    public void setChrome (){
        helper = new VerifyHelper();
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path + "\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.MINUTES);
        mainPage = new MainPage(driver);
        mainPage = mainPage.openWebsite();
    }

    @AfterTest
    public void cleanUp () {
        driver.quit();
    }

}
