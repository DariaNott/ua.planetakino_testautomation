package ua.planetakino;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import ua.planetakino.web.ui.pages.MainPage;

import java.util.concurrent.TimeUnit;

public class DemoTests {

    WebDriver driver;

    @Test
    public void checkclasses() {
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path + "\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.MINUTES);
        MainPage mainPage = new MainPage(driver);
        mainPage.openWebsite().getHeader().goToLogIn().logIn();
    }


}
