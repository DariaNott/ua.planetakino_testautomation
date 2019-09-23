package ua.planetakino;

import org.testng.annotations.Test;
import ua.planetakino.entity.Account;

public class AccountTests extends TestBase {

    @Test
    public void checkLogIn() {
        String status = mainPage.getHeader().goToLogIn().logIn().getAuthorizationStatus();
        helper.verifyAuthorizedUser(status);
    }

    @Test
    public void checkLogOut() {
        String status = mainPage.getHeader().goToLogIn().logIn().getHeader().logOut().getAuthorizationStatus();
        helper.verifyAnonymousUser(status);
    }

    @Test
    public void checkNameChange() {
        String name = "Робин";
        String surname = "Шантель";
        Account account = mainPage.getHeader().goToLogIn().logIn().gotoEditAccountPage().changeName(name, surname).confirmChanges()
                .gotoEditAccountPage().getAccountInfo();
        helper.verifyProfileChangesInName(account, name, surname);
    }

    @Test
    public void checkSecretWordChange() {
        String secretWord = "доберман";
        Account account = mainPage.getHeader().goToLogIn().logIn().gotoEditAccountPage().changeSecretWord(secretWord)
                .confirmChanges().gotoEditAccountPage().getAccountInfo();
        helper.verifyProfileChangesInSecretWord(account, secretWord);
    }
}
