package uk.co.eurosport.pages;

import org.openqa.selenium.By;
import uk.co.eurosport.framework.Browser;
import uk.co.eurosport.framework.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Krishna on 14/07/2019.
 */
public class TennisVideosPage extends Browser {

    private static WebDriver driver;

    @FindBy(css = "abtasty-modal > div > div")
    static WebElement advertPopUp;

    @FindBy(css = "a[href*='vid1201835']")
    static List<WebElement> selectedTennisVideo;

    @FindBy(css = "#nav_category .categorylist .categorylist__item")
    static List<WebElement> topEvents;

    public static TennisVideosPage ourInstance = new TennisVideosPage();

    public static TennisVideosPage getInstance() {
        return ourInstance;
    }

    public TennisVideosPage() {
    }

    public TennisVideosPage(WebDriver aDriver) {
        this.driver = aDriver;
        PageFactory.initElements(this.driver, this);
    }

    public VideoPlayerPage closeAdvertAndOpenSelectedVideo(){
        driver = getDriver();
        DriverUtils.checkElementVisibility(driver, advertPopUp);
        advertPopUp.click();
        DriverUtils.checkElementVisibility(driver, selectedTennisVideo.get(0));
        DriverUtils.clickByJS(driver, selectedTennisVideo.get(0));
        return new VideoPlayerPage(driver);
    }

    public List<String> getListOTennisTournaments(){
        List<String> tennisTournaments = new ArrayList<>();

        for(WebElement event : topEvents){
            tennisTournaments.add(event.getText());
        }
        return tennisTournaments;
    }

}
