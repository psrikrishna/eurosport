package uk.co.eurosport.pages;

import uk.co.eurosport.framework.Browser;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static uk.co.eurosport.framework.DriverUtils.checkElementVisibility;

/**
 * Created by Krishna on 14/07/2019.
 */
public class VideoPlayerPage extends Browser {

    private static WebDriver driver;

    @FindBy(css = "#vjs_video_3_html5_api")
    static WebElement playingVideo;

    @FindBy(css = "video__skip")
    static WebElement waitToSkipAdButton;

    @FindBy(css = "video__skip video__skip--skippable")
    static WebElement skipAdButton;

    @FindBy(css = "button.vjs-play-control.vjs-control.vjs-button.vjs-playing")
    static WebElement playButton;

    @FindBy(css = "button.vjs-play-control.vjs-control.vjs-button.vjs-paused")
    static WebElement pauseButton;

    @FindBy(css = "button[title='Fullscreen']")
    static WebElement maximizeButton;

    public VideoPlayerPage(WebDriver aDriver) {
        this.driver = aDriver;
        PageFactory.initElements(this.driver, this);
    }

    public void verifyControls(List<String> controls) throws InterruptedException {
        Actions builder = new Actions(driver);
        builder.moveToElement(playingVideo).build().perform();

        for (String control : controls) {
            switch (control) {
                case "Play":
                    try {
                        if (waitToSkipAdButton.isDisplayed()) {
                            Thread.sleep(10000);
                        }
                    } catch (NoSuchElementException e) {
                    }

                    try {
                        if (skipAdButton.isDisplayed()) {
                            Thread.sleep(10000);
                        }
                    } catch (NoSuchElementException e) {
                    }

                    builder.moveToElement(playingVideo).build().perform();
                    checkElementVisibility(driver, playButton);
                    Assert.assertTrue(playButton.isDisplayed());
                    playButton.click();
                    break;
                case "Pause":
                    Assert.assertTrue(pauseButton.isDisplayed());
                    break;
                case "Maximize":
                    Assert.assertTrue(maximizeButton.isDisplayed());
                    break;
            }
        }
        driver.quit();
    }
}