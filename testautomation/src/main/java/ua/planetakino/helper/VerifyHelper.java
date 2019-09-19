package ua.planetakino.helper;

import org.joda.time.DateTime;
import org.testng.Assert;
import ua.planetakino.entity.MovieItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VerifyHelper {

    public void verifyDateRange (List<MovieItem> movieItems, int dateRange){
        List<MovieItem> failedDatesInMovieItems = new ArrayList<>();
        for (MovieItem item: movieItems){
            List <DateTime>datesList = item.getMovieDates();

            for (DateTime date: datesList) {
                DateHelper helper = new DateHelper();
                boolean isDateWithinRange = helper.isThisDateWithinRange(date, dateRange);
                if (!isDateWithinRange) {
                    failedDatesInMovieItems.add(item);
                    break;
                }
            }
        }
        Assert.assertEquals(failedDatesInMovieItems.size(), 0, "Dates failed for: " + Arrays.toString(failedDatesInMovieItems.toArray()));
    }

    public void verifyTechnologyAnfFormatFilter (List<MovieItem> movieItems, String filtersNames){
        List <MovieItem> failedFilters = new ArrayList<>();
        for (MovieItem item: movieItems){
            List <String> techAndFormatList = item.getMovieTechnologyAndFormat();

            for (String techAndFormat: techAndFormatList){
                boolean doesTechAndFormatMatch = techAndFormat.contentEquals(techAndFormat);
                if (!doesTechAndFormatMatch){
                    failedFilters.add(item);
                    break;
                }
            }
        }
        Assert.assertEquals(failedFilters.size(), 0, "Dates failed for: " + Arrays.toString(failedFilters.toArray()));
    }

}