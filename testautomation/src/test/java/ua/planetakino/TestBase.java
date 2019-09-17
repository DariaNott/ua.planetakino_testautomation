package ua.planetakino;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import ua.planetakino.config.EnvConfig;

public abstract class TestBase {

    private static Logger LOGGER = Logger.getLogger(TestBase.class);

    protected WebDriver driver;
    protected EnvConfig config;


}
