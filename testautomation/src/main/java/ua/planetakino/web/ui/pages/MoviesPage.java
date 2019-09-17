package ua.planetakino.web.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MoviesPage extends BasePage {


    public MoviesPage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //app-timetable-movie//div[contains(@class,'showtime-date')] - dates
    //app-timetable-movie//a[contains(@class,'tablet-movie-name link-text')] - names
    //app-timetable-movie/div[contains(@class,'movie')] - blocks with movies
}
