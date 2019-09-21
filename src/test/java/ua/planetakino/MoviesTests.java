package ua.planetakino;

import org.testng.Assert;
import org.testng.annotations.Test;
import ua.planetakino.web.ui.pages.MoviesPage;

public class MoviesTests extends TestBase {
    @Test
    public void checkMovieTrailerPresence () {
        boolean status = mainPage.getHeader().goToMoviesPage().openFirstMovieDetails().getPlayerPresenceStatus();
        Assert.assertTrue(status);
    }

    @Test
    public void checkInfoAboutGlassesShownInNewTab (){
        MoviesPage page = mainPage.getHeader().goToMoviesPage().openFirstMovieDetails().openAboutGlassInfo();
        helper.verifyWebsiteIsOpenInNewTab(page, "Усе про наші 3D-окуляри");
    }
}
