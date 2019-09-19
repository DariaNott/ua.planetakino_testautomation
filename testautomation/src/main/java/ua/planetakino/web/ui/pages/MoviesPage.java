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

public class MoviesPage extends BasePage {


    public MoviesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
