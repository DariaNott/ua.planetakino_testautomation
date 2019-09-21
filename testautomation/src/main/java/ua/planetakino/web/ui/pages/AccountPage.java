package ua.planetakino.web.ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ua.planetakino.config.EnvConfig;

public class AccountPage extends BasePage {

    @FindBy(xpath = "//label[contains(@for,'loginform-login')]")
    private WebElement getLoginField;

    @FindBy(xpath = "//input[contains(@id,'loginform-login')]")
    private WebElement loginField;

    @FindBy(xpath = "//label[contains(@for,'loginform-password')]")
    private WebElement getPasswordField;

    @FindBy(xpath = "//input[contains(@id,'loginform-password')]")
    private WebElement passwordField;

    @FindBy(xpath = "//button[contains(@class,'btn-small auth-submit')]")
    private WebElement loginButton;

    @FindBy(xpath = "//button[contains(@id,'pass-button')]")
    private WebElement changePassword;

    @FindBy(xpath = "//div[contains(@id,'email-status')]")
    private WebElement changeEmail;

    @FindBy(xpath = "//input[contains(@id,'accesschangeform-password')]")
    private WebElement oldPassInputField;

    @FindBy(xpath = "//input[contains(@id,'submit-editting')]")
    private WebElement submittOldPass;

    @FindBy(xpath = "//div[contains(@class,'authorised-user')]")
    private WebElement userIsAuthorised;

    @FindBy(xpath = "//div[contains(@class,'anonymous-user')]")
    private WebElement userIsAnonymous;

    public AccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Clicking on 'Change email' button")
    public EditAccountPage gotoEditAccountPage() {
        click(changeEmail);
        LOGGER.info("Clicked on changeEmail");
        reenterPasswordIfRequired();
        return new EditAccountPage(driver);
    }
    @Step("Logging in")
    public AccountPage logIn() {
        click(getLoginField);
        LOGGER.info("Clicked on getLoginField");
        EnvConfig config = EnvConfig.getEnvironment();
        loginField.sendKeys(config.getUsername());
        LOGGER.info("Username typed in loginField");
        click(getPasswordField);
        LOGGER.info("Clicked on getPasswordField");
        passwordField.sendKeys(config.getPassword());
        LOGGER.info("Username typed in passwordField");
        click(loginButton);
        LOGGER.info("Clicked on loginButton");
        return this;
    }

    public String getAuthorizationStatus() {
        String status = null;
        if (elementExists(userIsAuthorised)) {
            status = "authorised";
        } else if (elementExists(userIsAnonymous)) {
            status = "anonymous";
        }
        LOGGER.info("Receive authorization status.");
        return status;
    }

    private boolean elementExists(WebElement element) {
        try{
            return element.isDisplayed();
        } catch (WebDriverException ex){
            return false;
        }
    }

    private void reenterPasswordIfRequired() {
        try {
            if ((new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOf(driver.
                    findElement(By.xpath("//input[contains(@type,'password')]")))) != null) {
                (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOf(driver.
                        findElement(By.xpath("//input[contains(@type,'password')]"))))
                        .sendKeys("J7yZAQFL3yeHX74v");
                click(driver.findElement(By.xpath("//input[contains(@id,'submit-editting')]")));
                LOGGER.info("Requested password entered.");
            }
        } catch (WebDriverException ex) {
            LOGGER.info("Password wasn't requested.");
        }
    }
}
