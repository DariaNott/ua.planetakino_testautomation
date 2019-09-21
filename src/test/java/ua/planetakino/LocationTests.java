package ua.planetakino;

import org.testng.annotations.Test;

import java.util.List;

public class LocationTests extends TestBase {

    @Test
    public void checkCitiesList () {
        List <String> cities = mainPage.getHeader().openCitiesList().getCitiesAndTheatersList();
        helper.verifyCityList(cities);
    }
}
