package ua.planetakino;

import org.testng.annotations.Test;

public class OrderTests extends TestBase {

    @Test
    public void checkOrder() {
        mainPage.openWebsite().getHeader().goToLogIn().logIn();
        String url = mainPage.openWebsite()
                .getHeader().goToSchedulePage()
                .selectFilterPeriodMonth()
                .orderMovieTicket("Шакіра — світовий тур «Ельдорадо» (12+)", "19:00")
                .addSeat()
                .submitOrder()
                .getCurrentURL();
        helper.verifyPaymentPage(url);
    }
}
