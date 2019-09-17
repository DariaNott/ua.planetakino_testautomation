package ua.planetakino.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class EnvConfig {
    private String webUrl;
    private int timeoutPageLoad;
    private int implicitlyWait;
    String username;
    String password;


    public EnvConfig(String envName) {

        String path = System.getProperty("user.dir") + "/src/main/resources/config/"
                + envName + ".properties";
        Properties properties = loadProperties(path);
        webUrl = properties.getProperty(webUrl);
        timeoutPageLoad = Integer.parseInt(properties.getProperty("timeout.PageLoad"));
        implicitlyWait = Integer.parseInt(properties.getProperty("timeout.implicitlyWait"));
        username = properties.getProperty(username);
        password = properties.getProperty(password);
    }

    private Properties loadProperties(String path) {
        try (InputStream input = new FileInputStream(path)) {
            Properties prop = new Properties();
            prop.load(input);
            return prop;
        } catch (IOException ex) {
            throw new IllegalArgumentException("Cannot read property file by specified path!", ex);
        }
    }

    public String getWebUrl() {
        return webUrl;
    }

    public int getTimeoutPageLoad() {
        return timeoutPageLoad;
    }

    public int getImplicitlyWait() {
        return implicitlyWait;
    }

    public String getUsername () {
        return username;
    }

    public String getPassword () {
        return password;
    }
}
