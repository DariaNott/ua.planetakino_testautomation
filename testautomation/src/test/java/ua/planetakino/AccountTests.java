package ua.planetakino;

import org.testng.annotations.Test;
import ua.planetakino.entity.Account;

public class AccountTests extends TestBase {

    @Test
    public void checkLogIn () {
        mainPage.getHeader().goToLogIn().logIn();
        //TODO assert
//div[contains(@class,'authorised-user')]
    }

    @Test
    public void chekLogOut () {
        mainPage.getHeader().goToLogIn().logIn().getHeader().logOut();
        //TODO assert
//div[contains(@class,'anonymous-user')]
    }

    @Test
    public void checkNameChange() {
        String name = "Amy";
        String surname = "Pond";
        Account account = mainPage.getHeader().goToLogIn().logIn().gotoEditAccountPage().changeName(name, surname).confirmChanges()
                .gotoEditAccountPage().getAccountInfo();
        helper.verifyProfileChangesInName(account, name, surname);
    }

    @Test
    public void checkSecretWordChange() {
        String secretWord = "timey-wimey";
        Account account = mainPage.getHeader().goToLogIn().logIn().gotoEditAccountPage().changeSecretWord(secretWord)
                .confirmChanges().gotoEditAccountPage().getAccountInfo();
        helper.verifyProfileChangesInSecretWord(account, secretWord);
    }
}
