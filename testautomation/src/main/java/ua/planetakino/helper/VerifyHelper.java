package ua.planetakino.helper;

import org.joda.time.DateTime;
import org.testng.Assert;
import ua.planetakino.entity.Account;
import ua.planetakino.entity.MovieItem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class VerifyHelper {

    public void verifyDateRange(List<MovieItem> movieItems, int dateRange) {
        List<MovieItem> failedDatesInMovieItems = new ArrayList<>();
        for (MovieItem item : movieItems) {
            List<DateTime> datesList = item.getMovieDates();

            for (DateTime date : datesList) {
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

    public void verifyTechnologyAnfFormatFilter(List<MovieItem> movieItems, String filtersNames) {
        List<MovieItem> failedFilters = new ArrayList<>();
        for (MovieItem item : movieItems) {
            List<String> techAndFormatList = item.getMovieTechnologyAndFormat();

            for (String techAndFormat : techAndFormatList) {
                boolean doesTechAndFormatMatch = techAndFormat.contentEquals(techAndFormat);
                if (!doesTechAndFormatMatch) {
                    failedFilters.add(item);
                    break;
                }
            }
        }
        Assert.assertEquals(failedFilters.size(), 0, "Dates failed for: " + Arrays.toString(failedFilters.toArray()));
    }

    public void verifyProfileChangesInName(Account account, String firstName, String lastName) {
        Assert.assertEquals(account.getFirstName(), firstName);
        Assert.assertEquals(account.getLastName(), lastName);
    }

    public void verifyProfileChangesInSecretWord (Account account, String secretWord){
        Assert.assertEquals(account.getSecretWord(), secretWord);
    }

    public void verifyCityList (List<String> citiesAndTheaters) {
        List <String> cities = new ArrayList<>();
        cities.add("Київ (Blockbuster)");
        cities.add("Київ (River Mall)");
        cities.add("Одеса (Котовського)");
        cities.add("Одеса (Таїрова)");
        cities.add("Львів (King Cross)");
        cities.add("Львів (Forum Lviv)");
        cities.add("Харків (Французький бульвар)");
        cities.add("Суми (Мануфактура)");
        Assert.assertEquals(citiesAndTheaters, cities);
    }

}