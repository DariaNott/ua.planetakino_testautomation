package ua.planetakino;

import org.testng.annotations.Test;
import ua.planetakino.entity.MovieItem;

import java.util.List;

public class DemoTests extends TestBase {

    @Test
    public void checkclasses() {
        mainPage.openWebsite().getHeader().goToSchedulePage().selectFilterPeriodMonth()
                .orderMovieTicket(1, 3);

    }


}
