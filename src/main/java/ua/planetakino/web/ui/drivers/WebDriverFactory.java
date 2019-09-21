package ua.planetakino.web.ui.drivers;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverFactory {

    private WebDriverFactory () {}

    public static WebDriver getDriver(String webDriverName) {
        switch (webDriverName) {
            case "firefox":
                throw new UnsupportedOperationException("Firefox driver is not supported, yet!");
            case "ie":
                throw new UnsupportedOperationException("Edge driver is not supported, yet!");
            default:
                WebDriverManager.chromedriver().setup();
                ChromeOptions opts = new ChromeOptions();
                opts.addArguments("--disable-browser-side-navigation");
                return new ChromeDriver(opts);
        }
    }
}
