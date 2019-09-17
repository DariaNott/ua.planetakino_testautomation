package ua.planetakino.entity;

import org.joda.time.DateTime;

public class MovieItem {
    private String name;
    private DateTime date;

    public MovieItem () {
    }

    public void setMovieName (String name) {
        this.name = name;
    }

    public void setMovieDate (DateTime date){
        this.date = date;
    }

    public String getMovieName(){
        return name;
    }

    public DateTime getMovieDate (){
        return date;
    }
}
