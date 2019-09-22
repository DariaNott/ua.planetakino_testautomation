package ua.planetakino.entity;

import org.joda.time.DateTime;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MovieItem {

    private String name;
    private List<DateTime> dates;
    private List<String> technologyAndFormat;

    public MovieItem(String name, List<DateTime> dates, List<String> technologyAndFormat) {
        this.name = name;
        if (dates == null) {
            this.dates = new ArrayList<>();
        } else {
            this.dates = dates;
        }
        if (technologyAndFormat == null) {
            this.technologyAndFormat = new ArrayList<>();
        } else {
            this.technologyAndFormat = technologyAndFormat;
        }
    }

    public String getMovieName() {
        return name;
    }

    public List<DateTime> getMovieDates() {
        return dates;
    }

    public List<String> getMovieTechnologyAndFormat() {
        return technologyAndFormat;
    }

    @Override
    public String toString() {
        return "MovieItem{" +
                "name='" + name + '\'' +
                ", dates=" + Arrays.toString(dates.toArray()) +
                ", technology=" + Arrays.toString(technologyAndFormat.toArray()) +
                '}';
    }
}

