package ua.planetakino;

import org.testng.annotations.Test;
import ua.planetakino.entity.Account;

public class AccountTests extends TestBase {

    @Test
    public void checkLogIn () {
        String status =  mainPage.getHeader().goToLogIn().logIn().getAuthorizationStatus();
        helper.verifyAuthorizedUser(status);
    }

    @Test
    public void chekLogOut () {
        String status = mainPage.getHeader().goToLogIn().logIn().getHeader().logOut().getAuthorizationStatus();
        helper.verifyAnonymousUser(status);
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
