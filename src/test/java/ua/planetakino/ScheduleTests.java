package ua.planetakino;

import org.testng.annotations.Test;
import ua.planetakino.entity.MovieItem;

import java.util.List;

public class ScheduleTests extends TestBase {

    //period filter tests
    @Test
    public void checkFilterToday() {
        List<MovieItem> movieItems = mainPage.getHeader().goToSchedulePage().selectFilterPeriodToday().getMovieItems();
        helper.verifyDateRange(movieItems, 0);
    }

    @Test
    public void checkFilterTomorrow() {
        List<MovieItem> movieItems = mainPage.getHeader().goToSchedulePage().selectFilterPeriodTomorrow().getMovieItems();
        helper.verifyDateRange(movieItems, 1);
    }

    @Test
    public void checkFilterWeek() {
        List<MovieItem> movieItems = mainPage.getHeader().goToSchedulePage().selectFilterPeriodWeek().getMovieItems();
        helper.verifyDateRange(movieItems, 7);
    }

    //expected to fail as there are movies in this category that will be shown much later than a month
    @Test
    public void checkFilterMonth() {
        List<MovieItem> movieItems = mainPage.getHeader().goToSchedulePage().selectFilterPeriodMonth().getMovieItems();
        helper.verifyDateRange(movieItems, 31);
    }

    //technology and format tests
    @Test
    public void checkFilter_4DX_2D() {
        List<MovieItem> movieItems = mainPage.getHeader().goToSchedulePage().selectFilterTechnology4DX().selectFilterFormat2D()
                .getMovieItems();
        helper.verifyTechnologyAnfFormatFilter(movieItems, "4DX, 2D");
    }

    @Test
    public void checkFilter_CINETECH_2D() {
        List<MovieItem> movieItems = mainPage.getHeader().goToSchedulePage().selectFilterTechnologyCinetech().selectFilterFormat2D()
                .getMovieItems();
        helper.verifyTechnologyAnfFormatFilter(movieItems, "CINETECH+, 2D");
    }

    @Test
    public void checkFilter_IMAX_2D() {
        List<MovieItem> movieItems = mainPage.getHeader().goToSchedulePage().selectFilterTechnologyIMAX().selectFilterFormat2D()
                .getMovieItems();
        helper.verifyTechnologyAnfFormatFilter(movieItems, "IMAX, 2D");
    }

    @Test
    public void checkFilter_RELUX_2D() {
        List<MovieItem> movieItems = mainPage.getHeader().goToSchedulePage().selectFilterTechnologyReLUX().selectFilterFormat2D()
                .getMovieItems();
        helper.verifyTechnologyAnfFormatFilter(movieItems, "RE'LUX, 2D");
    }

    @Test
    public void checkFilter_4DX_3D() {
        List<MovieItem> movieItems = mainPage.getHeader().goToSchedulePage().selectFilterTechnology4DX()
                .selectFilterFormat3D().getMovieItems();
        helper.verifyTechnologyAnfFormatFilter(movieItems, "4DX, 3D");
    }

    @Test
    public void checkFilter_CINETECH_3D() {
        List<MovieItem> movieItems = mainPage.getHeader().goToSchedulePage().selectFilterTechnologyCinetech()
                .selectFilterFormat3D().getMovieItems();
        helper.verifyTechnologyAnfFormatFilter(movieItems, "CINETECH+, 3D");
    }

    @Test
    public void checkFilter_IMAX_3D() {
        List<MovieItem> movieItems = mainPage.getHeader().goToSchedulePage().selectFilterTechnologyIMAX()
                .selectFilterFormat3D().getMovieItems();
        helper.verifyTechnologyAnfFormatFilter(movieItems, "IMAX, 3D");
    }

    @Test
    public void checkFilter_RELUX_3D() {
        List<MovieItem> movieItems = mainPage.getHeader().goToSchedulePage().selectFilterTechnologyReLUX()
                .selectFilterFormat3D().getMovieItems();
        helper.verifyTechnologyAnfFormatFilter(movieItems, "RE'LUX, 3D");
    }
}
