package ua.planetakino;

import org.testng.annotations.Test;
import ua.planetakino.entity.MovieItem;

import java.util.List;

public class DemoTests extends TestBase{

    @Test
    public void checkclasses() {
        List<MovieItem> movieItems = mainPage.openWebsite().getHeader().goToSchedulePage().selectFilterPeriodWeek()
                .getMovieItems();
        helper.verifyDateRange(movieItems, 5);
    }


}
