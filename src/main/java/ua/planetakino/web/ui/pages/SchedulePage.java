package ua.planetakino.web.ui.pages;

import io.qameta.allure.Step;
import org.joda.time.DateTime;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ua.planetakino.entity.MovieItem;
import ua.planetakino.helper.DateHelper;

import java.util.ArrayList;
import java.util.List;

public class SchedulePage extends BasePage {

    @FindBy(id = "mat-radio-2")
    private WebElement filterPeriodToday;

    @FindBy(id = "mat-radio-3")
    private WebElement filterPeriodTomorrow;

    @FindBy(id = "mat-radio-4")
    private WebElement filterPeriodWeek;

    @FindBy(id = "mat-radio-5")
    private WebElement filterPeriodMonth;

    @FindBy(xpath = "//mat-checkbox//input[@value='4DX']")
    private WebElement filterTechnology4DX;

    @FindBy(xpath = "//mat-checkbox//input[@value='Cinetech+']")
    private WebElement filterTechnologyCinetech;

    @FindBy(xpath = "//mat-checkbox//input[@value='IMAX']")
    private WebElement filterTechnologyIMAX;

    @FindBy(xpath = "//mat-checkbox//input[@value=\"RE'LUX\"]")
    private WebElement filterTechnologyReLUX;

    @FindBy(xpath = "//mat-checkbox//input[@value='2D']")
    private WebElement filterFormat2D;

    @FindBy(xpath = "//mat-checkbox//input[@value='3D']")
    private WebElement filterFormat3D;

    @FindBy(xpath = "//app-timetable-movie/div[contains(@class,'movie')]")
    private List<WebElement> movieItemBlocks;

    public SchedulePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public List<MovieItem> getMovieItems() {
        List<MovieItem> movieItems = new ArrayList<>();
        for (WebElement item : movieItemBlocks) {
            String name = getNameForMovieElement(item);
            List<DateTime> dates = getDatesForMovieElement(item);
            List<String> technologiesAndFormats = getTechnologyAndFormatForMovieElement(item);
            MovieItem mItem = new MovieItem(name, dates, technologiesAndFormats);
            movieItems.add(mItem);
        }
        return movieItems;
    }

    public WebElement getMovieBlock(String movieName) {
        for (WebElement item : movieItemBlocks) {
            String name = getNameForMovieElement(item);
            if (movieName.equals(name)) {
                return item;
            }
        }
        return null;
    }

    @Step("Clicking on the movie time to add ticket to the cart.")
    public OrderPage orderMovieTicket(String movieName, String movieTime) {
        WebElement movieBlock = getMovieBlock(movieName);
        WebElement movieTimeElement = getAvailableMovieTime(movieBlock, movieTime);
        scrollInView(movieTimeElement);
        LOGGER.info("Scrolled to  movieTimeElement.");
        click(movieTimeElement);
        LOGGER.info("Clicked on movieTimeElement.");
        return new OrderPage(driver);
    }

    @Step("Clicking on 'Week' radio button.")
    public SchedulePage selectFilterPeriodWeek() {
        scrollInView(filterPeriodWeek);
        LOGGER.info("Scrolled to filterPeriodWeek.");
        click(filterPeriodWeek);
        LOGGER.info("Clicked on filterPeriodWeek.");
        return this;
    }

    @Step("Clicking on 'Today' radio button.")
    public SchedulePage selectFilterPeriodToday() {
        scrollInView(filterPeriodToday);
        LOGGER.info("Scrolled to filterPeriodToday.");
        click(filterPeriodToday);
        LOGGER.info("Clicked on filterPeriodToday.");
        return this;
    }

    @Step("Clicking on 'Tomorrow' radio button.")
    public SchedulePage selectFilterPeriodTomorrow() {
        scrollInView(filterPeriodTomorrow);
        LOGGER.info("Scrolled to filterPeriodTomorrow.");
        click(filterPeriodTomorrow);
        LOGGER.info("Clicked on filterPeriodTomorrow.");
        return this;
    }

    @Step("Clicking on 'Month' radio button.")
    public SchedulePage selectFilterPeriodMonth() {
        scrollInView(filterPeriodMonth);
        LOGGER.info("Scrolled to filterPeriodMonth.");
        click(filterPeriodMonth);
        LOGGER.info("Clicked on filterPeriodMonth.");
        return this;
    }

    @Step("Clicking on '4DX' checkbox.")
    public SchedulePage selectFilterTechnology4DX() {
        scrollInView(filterTechnology4DX);
        LOGGER.info("Scrolled to filterTechnology4DX.");
        click(filterTechnology4DX);
        LOGGER.info("Clicked on filterTechnology4DX.");
        return this;
    }

    @Step("Clicking on 'Cinetech+' checkbox.")
    public SchedulePage selectFilterTechnologyCinetech() {
        scrollInView(filterTechnologyCinetech);
        LOGGER.info("Scrolled to filterTechnologyCinetech.");
        click(filterTechnologyCinetech);
        LOGGER.info("Clicked on filterTechnologyCinetech.");
        return this;
    }

    @Step("Clicking on 'IMAX' checkbox.")
    public SchedulePage selectFilterTechnologyIMAX() {
        scrollInView(filterTechnologyIMAX);
        LOGGER.info("Scrolled to filterTechnologyIMAX.");
        click(filterTechnologyIMAX);
        LOGGER.info("Clicked on filterTechnologyIMAX.");
        return this;
    }

    @Step("Clicking on 'RE'LUX' checkbox.")
    public SchedulePage selectFilterTechnologyReLUX() {
        scrollInView(filterTechnologyReLUX);
        LOGGER.info("Scrolled to filterTechnologyReLUX.");
        click(filterTechnologyReLUX);
        LOGGER.info("Clicked on filterTechnologyReLUX.");
        return this;
    }

    @Step("Clicking on '2D' checkbox.")
    public SchedulePage selectFilterFormat2D() {
        scrollInView(filterFormat2D);
        LOGGER.info("Scrolled to filterFormat2D.");
        click(filterFormat2D);
        LOGGER.info("Clicked on filterFormat2D.");
        return this;
    }

    @Step("Clicking on '3D' checkbox.")
    public SchedulePage selectFilterFormat3D() {
        scrollPageToBottom();
        LOGGER.info("Scrolled to bottom.");
        click(filterFormat3D);
        LOGGER.info("Clicked on filterFormat3D.");
        return this;
    }

    private List<DateTime> getDatesForMovieElement(WebElement movieItemBlock) {
        DateHelper helper = new DateHelper();
        List<DateTime> dates = new ArrayList<>();
        List<WebElement> dateElements = movieItemBlock.findElements(By
                .xpath(".//section//div[contains(@class,'showtime-date')]"));
        for (WebElement element : dateElements) {
            DateTime date = helper.dateConverter(element.getText());
            dates.add(date);
        }
        return dates;
    }

    private String getNameForMovieElement(WebElement movieItemBlock) {
        String name = movieItemBlock.findElement(By.xpath(".//section/a[contains(@class,'movie-name')]")).getText();
        return name;
    }

    private List<String> getTechnologyAndFormatForMovieElement(WebElement movieItemBlock) {
        List<String> technologiesAndFormats = new ArrayList<>();
        List<WebElement> techAndFormElements = movieItemBlock.findElements(By.xpath(".//span"));
        for (WebElement element : techAndFormElements) {
            String techAndFormat = element.getText().trim();
            technologiesAndFormats.add(techAndFormat);
        }
        return technologiesAndFormats;
    }

    private WebElement getAvailableMovieTime(WebElement movieBlock, String time) {
        List<WebElement> movieTimes = movieBlock.findElements(By.xpath(".//button[contains(@class,'chips')]"));
        for (WebElement movieTime : movieTimes) {
            if (movieTime.isEnabled() && time.equals(movieTime.getText())) {
                return movieTime;
            }
        }
        return null;
    }

}
