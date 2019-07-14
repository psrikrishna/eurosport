package uk.co.eurosport.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static uk.co.eurosport.framework.DriverUtils.checkElementVisibility;

public class VideosHomePage {

    private static final Logger log = LogManager.getLogger(VideosHomePage.class);

    private static WebDriver driver;
    private static final String pageLoadedText = "Sport videos: highlights, transfers, analysis, interviews - Eurosport";

    @FindBy(css= "div[id*='_interstitial_header']")
    static WebElement closeAdOnHomePage;

    @FindBy(css = ".hamburger_zone")
    static WebElement allSportsMenu;

    @FindBy(css = "div[data-modal-id='navallsport'] >button >span")
    static WebElement toggleMenu;

    @FindBy(css = "li[class*='modalnav__rightcol-item modalnav__rightcol-item--favorite'] >a[href*='tennis']")
    static WebElement tennisVideos;

    /* Constructors */
    public VideosHomePage() {
    }

    public VideosHomePage(WebDriver aDriver) {
        this.driver = aDriver;
        PageFactory.initElements(this.driver, this);
    }

    public boolean verifyPageLoaded() {
        return driver.getTitle().equals(pageLoadedText);
    }

    public TennisVideosPage openTennisVideosFromAllSportsMenu() {
        checkElementVisibility(driver, closeAdOnHomePage);
        closeAdOnHomePage.click();

        allSportsMenu.click();
        checkElementVisibility(driver, tennisVideos);
        tennisVideos.click();
        return new TennisVideosPage(driver);
    }
}
