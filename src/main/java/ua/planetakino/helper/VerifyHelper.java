package ua.planetakino.helper;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import ua.planetakino.entity.Account;
import ua.planetakino.entity.MovieItem;
import ua.planetakino.web.ui.pages.BasePage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class VerifyHelper {

    protected static final Logger LOGGER = Logger.getLogger(BasePage.class);

    @Step("Checking range for date filters.")
    public void verifyDateRange(List<MovieItem> movieItems, int dateRange) {
        LOGGER.info("Checking range for date filters.");
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

    @Step("Checking technology and format filters.")
    public void verifyTechnologyAnfFormatFilter(List<MovieItem> movieItems, String filtersNames) {
        LOGGER.info("Checking technology and format filters.");
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

    @Step("Checking changes in first and last names.")
    public void verifyProfileChangesInName(Account account, String firstName, String lastName) {
        LOGGER.info("Checking changes in first and last names.");
        Assert.assertEquals(account.getFirstName(), firstName);
        Assert.assertEquals(account.getLastName(), lastName);
    }

    @Step("Checking changes in secret word.")
    public void verifyProfileChangesInSecretWord(Account account, String secretWord) {
        LOGGER.info("Checking changes in secret word.");
        Assert.assertEquals(account.getSecretWord(), secretWord);
    }

    @Step("Checking list of cities and cinemas.")
    public void verifyCityList(List<String> citiesAndTheaters) {
        LOGGER.info("Checking list of cities and cinemas.");
        List<String> cities = new ArrayList<>();
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

    @Step("Checking that user is authorized.")
    public void verifyAuthorizedUser(String status) {
        LOGGER.info("Checking that user is authorized.");
        Assert.assertEquals(status, "authorised");
    }

    @Step("Checking that user is anonymous.")
    public void verifyAnonymousUser(String status) {
        LOGGER.info("Checking that user is anonymous.");
        Assert.assertEquals(status, "anonymous");
    }

    @Step("Checking Payment Page URL.")
    public void verifyPaymentPage(String currentUrl) {
        LOGGER.info("Checking Payment Page URL.");
        Assert.assertEquals(currentUrl, "https://pay.planetakino.ua/checkout");
    }

    @Step("Checking that website with '{1}' title is opened in new tab.")
    public void verifyWebsiteIsOpenInNewTab(BasePage page, String expectedTitle) {
        LOGGER.info("Checking that website with '" + expectedTitle + "' title is opened in new tab.");
        Set<String> tabs = page.getWebDriver().getWindowHandles();
        for (String i : tabs) {
            WebDriver newDriver = page.getWebDriver().switchTo().window(i);
            String title = newDriver.getTitle();
            if (title.equals(expectedTitle)) {
                return;
            }
        }
        Assert.fail("No tabs with '" + expectedTitle + "' title found.");
    }
}
