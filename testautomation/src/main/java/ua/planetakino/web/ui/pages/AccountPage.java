package ua.planetakino.web.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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

    public AccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public EditAccountPage gotoEditAccountPage() {
        click(changeEmail);
        //the site may ask
        return new EditAccountPage(driver);
    }

    public AccountPage logIn() {
        config = new EnvConfig(System.getProperty("env", "prod"));
        click(getLoginField);
        loginField.sendKeys(config.getUsername());
        click(getPasswordField);
        passwordField.sendKeys(config.getPassword());
        click(loginButton);
        return this;
    }
}
