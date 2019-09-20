package ua.planetakino.web.ui.pages;

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

    @FindBy(xpath = "//mat-radio-button[contains(@id,'mat-radio-2')]")
    private WebElement filterPeriodToday;

    @FindBy(xpath = "//mat-radio-button[contains(@id,'mat-radio-3')]")
    private WebElement filterPeriodTomorrow;

    @FindBy(xpath = "//mat-radio-button[contains(@id,'mat-radio-4')]")
    private WebElement filterPeriodWeek;

    @FindBy(xpath = "//mat-radio-button[contains(@id,'mat-radio-5')]")
    private WebElement filterPeriodMonth;

    @FindBy(xpath = "//mat-checkbox[contains(@id,'mat-checkbox-1')]")
    private WebElement filterTechnology4DX;

    @FindBy(xpath = "//mat-checkbox[contains(@id,'mat-checkbox-2')]")
    private WebElement filterTechnologyCinetech;

    @FindBy(xpath = "//mat-checkbox[contains(@id,'mat-checkbox-3')]")
    private WebElement filterTechnologyIMAX;

    @FindBy(xpath = "//mat-checkbox[contains(@id,'mat-checkbox-4')]")
    private WebElement filterTechnologyReLUX;

    @FindBy(xpath = "//mat-checkbox[contains(@id,'mat-checkbox-5')]")
    private WebElement filterFormat2D;

    @FindBy(xpath = "//mat-checkbox[contains(@id,'mat-checkbox-6')]")
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
            List<WebElement> availableMovieTime = getAvailableMovieTime(item);
            MovieItem mItem = new MovieItem(name, dates, technologiesAndFormats, availableMovieTime);
            movieItems.add(mItem);
        }
        return movieItems;
    }

    public OrderPage orderMovieTicket(int movieIndex, int movieTimeIndex) {
        List<MovieItem> movieItems = getMovieItems();
        MovieItem movieToGo = movieItems.get(movieIndex);
        WebElement movieTime = movieToGo.getMovieTime().get(movieTimeIndex);
        click(movieTime);
        return new
                OrderPage(driver);
    }

    public SchedulePage selectFilterPeriodWeek() {
        click(filterPeriodWeek);
        return this;
    }

    public SchedulePage selectFilterPeriodToday() {
        click(filterPeriodToday);
        return this;
    }

    public SchedulePage selectFilterPeriodTomorrow() {
        click(filterPeriodTomorrow);
        return this;
    }

    public SchedulePage selectFilterPeriodMonth() {
        click(filterPeriodMonth);
        return this;
    }

    public SchedulePage selectFilterTechnology4DX() {
        click(filterTechnology4DX);
        return this;
    }

    public SchedulePage selectFilterTechnologyCinetech() {
        click(filterTechnologyCinetech);
        return this;
    }

    public SchedulePage selectFilterTechnologyIMAX() {
        click(filterTechnologyIMAX);
        return this;
    }

    public SchedulePage selectFilterTechnologyReLUX() {
        click(filterTechnologyReLUX);
        return this;
    }

    public SchedulePage selectFilterFormat2D() {
        click(filterFormat2D);
        return this;
    }

    public SchedulePage selectFilterFormat3D() {
        click(filterFormat3D);
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
        String name = movieItemBlock.findElement(By.xpath(".//section/a[contains(@class,'movie-name')]"))
                .getText();
        return name;
    }

    private List<String> getTechnologyAndFormatForMovieElement(WebElement movieItemBlock) {
        List<String> technologiesAndFormats = new ArrayList<>();
        List<WebElement> techAndFormElements = movieItemBlock.findElements(By
                .xpath(".//span"));
        for (WebElement element : techAndFormElements) {
            String techAndFormat = element.getText().trim();
            technologiesAndFormats.add(techAndFormat);
        }
        return technologiesAndFormats;
    }

    private List<WebElement> getAvailableMovieTime(WebElement movieItemBlock) {
        List<WebElement> movieTime = movieItemBlock.findElements(By.xpath(".//button[contains(@class,'chips')]"));
        List<WebElement> availableMovieTime = new ArrayList<>();
        for (WebElement time : movieTime) {
            if (time.isEnabled()) {
                availableMovieTime.add(time);
            }
        }
        return availableMovieTime;
    }

}
