package ua.planetakino.web.ui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ua.planetakino.entity.Account;

public class EditAccountPage extends BasePage {

    @FindBy(xpath = "//input[contains(@id,'profilechangeform-firstname')]")
    private WebElement inputFirstName;

    @FindBy(xpath = "//input[contains(@id,'profilechangeform-lastname')]")
    private WebElement inputLastName;

    @FindBy(xpath = "//input[contains(@name,'ProfileChangeForm[secretWord]')]")
    private WebElement inputSecretWord;

    @FindBy(xpath = "//input[contains(@class,'btn-input-block btn-input-block-form')]")
    private WebElement saveChangesButton;

    public EditAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Changing the full name of the user.")
    public EditAccountPage changeName(String firstName, String lastName) {
        LOGGER.info("Clicked on inputFirstName.");
        click(inputFirstName);
        LOGGER.info("Field inputFirstName cleared.");
        inputFirstName.clear();
        LOGGER.info("New value entered into inputFirstName field.");
        inputFirstName.sendKeys(firstName);
        LOGGER.info("Clicked on inputFirstName.");
        click(inputLastName);
        LOGGER.info("Field inputLastName cleared.");
        inputLastName.clear();
        LOGGER.info("New value entered into inputLastName field.");
        inputLastName.sendKeys(lastName);
        return this;
    }

    @Step("Changing secret word")
    public EditAccountPage changeSecretWord(String secretWord) {
        LOGGER.info("Clicked on inputSecretWord.");
        click(inputSecretWord);
        LOGGER.info("Field inputSecretWord cleared.");
        inputSecretWord.clear();
        LOGGER.info("New value entered into inputSecretWord field.");
        inputSecretWord.sendKeys(secretWord);
        return this;
    }

    @Step("Confirming changes by clicking on button 'Save'")
    public AccountPage confirmChanges() {
        LOGGER.info("Clicked on saveChangesButton.");
        click(saveChangesButton);
        return new AccountPage(driver);
    }

    public Account getAccountInfo() {
        String firstName = inputFirstName.getAttribute("value");
        String lastName = inputLastName.getAttribute("value");
        String secretWord = inputSecretWord.getAttribute("value");
        Account account = new Account(firstName, lastName, secretWord);
        return account;
    }
}
