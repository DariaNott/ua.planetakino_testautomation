package ua.planetakino;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MoviesTests extends TestBase {
    @Test
    public void checkMovieTrailerPresence () {
        boolean status = mainPage.getHeader().goToMoviesPage().openFirstMovieDetails().getPlayerPresenceStatus();
        Assert.assertTrue(status);
    }
}
