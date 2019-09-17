package ua.planetakino.web.ui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SchedulePage extends BasePage {

    @FindBy(xpath = "//mat-radio-button[contains(@id,'mat-radio-2')]")
    private WebElement filterPeriodToday;

    @FindBy (xpath = "//mat-radio-button[contains(@id,'mat-radio-3')]")
    private WebElement filterPeriodTomorrow;

    @FindBy (xpath = "//mat-radio-button[contains(@id,'mat-radio-4')]")
    private WebElement filterPeriodWeek;

    @FindBy (xpath = "//mat-radio-button[contains(@id,'mat-radio-5')]")
    private WebElement filterPeriodMonth;

    @FindBy (xpath = "//mat-checkbox[contains(@id,'mat-checkbox-1')]")
    private WebElement filterTechnology4DX;

    @FindBy (xpath = "//mat-checkbox[contains(@id,'mat-checkbox-2')]")
    private WebElement filterTechnologyCinetech;

    @FindBy (xpath = "//mat-checkbox[contains(@id,'mat-checkbox-3')]")
    private WebElement filterTechnologyIMAX;

    @FindBy (xpath = "//mat-checkbox[contains(@id,'mat-checkbox-4')]")
    private WebElement filterTechnologyReLUX;

    @FindBy (xpath = "//mat-checkbox[contains(@id,'mat-checkbox-5')]")
    private WebElement filterFormat2D;

    @FindBy (xpath = "//mat-checkbox[contains(@id,'mat-checkbox-6')]")
    private WebElement filterFormat3D;

    public SchedulePage (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

}
