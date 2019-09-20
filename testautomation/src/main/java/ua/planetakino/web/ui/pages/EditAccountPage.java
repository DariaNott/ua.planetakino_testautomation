package ua.planetakino.web.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ua.planetakino.entity.Account;

public class EditAccountPage extends BasePage {

    @FindBy(xpath = "//input[contains(@id,'profilechangeform-firstname')]")
    private WebElement inputFirstName;

    @FindBy (xpath = "//input[contains(@id,'profilechangeform-lastname')]")
    private WebElement inputLastName;

    @FindBy (xpath = "//input[contains(@name,'ProfileChangeForm[secretWord]')]")
    private WebElement inputSecretWord;

    @FindBy (xpath = "//input[contains(@class,'btn-input-block btn-input-block-form')]")
    private WebElement saveChangesButton;

    public EditAccountPage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public EditAccountPage changeName (String firstName, String lastName) {
        click(inputFirstName);
        inputFirstName.clear();
        inputFirstName.sendKeys(firstName);
        click(inputLastName);
        inputLastName.clear();
        inputLastName.sendKeys(lastName);
        return this;
    }

    public EditAccountPage changeSecretWord (String secretWord){
        click(inputSecretWord);
        inputSecretWord.clear();
        inputSecretWord.sendKeys(secretWord);
        return this;
    }

    public AccountPage confirmChanges () {
        click(saveChangesButton);
        return new AccountPage(driver);
    }

    public Account getAccountInfo () {
        String firstName = inputFirstName.getAttribute("value");
        String lastName = inputLastName.getAttribute("value");
        String secretWord = inputSecretWord.getAttribute("value");
        Account account = new Account(firstName, lastName, secretWord);
        return account;
    }
}
