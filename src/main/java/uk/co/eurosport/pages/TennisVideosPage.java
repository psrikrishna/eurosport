package uk.co.eurosport.pages;

import uk.co.eurosport.framework.Browser;
import uk.co.eurosport.framework.DriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by Krishna on 14/07/2019.
 */
public class TennisVideosPage extends Browser {

    private static WebDriver driver;

    @FindBy(css = "abtasty-modal > div > div")
    static WebElement advertPopUp;

    @FindBy(css = "a[href*='60-second']")
    static List<WebElement> selectedTennisVideos;

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
        DriverUtils.checkElementVisibility(driver, selectedTennisVideos.get(0));
        selectedTennisVideos.get(0).click();
        return new VideoPlayerPage(driver);
    }

}
