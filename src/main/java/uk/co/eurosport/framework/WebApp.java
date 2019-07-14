package uk.co.eurosport.framework;

import uk.co.eurosport.pages.VideosHomePage;
import junit.framework.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

/**
 * Created by Krishna on 14/07/2019.
 */
public class WebApp extends Browser {
    /* WebDriver variables */
    private static WebDriver driver = null;
    private static WebApp instance = null;

    /* Logging variables */
    private static final Logger log = LogManager.getLogger(WebApp.class);

    /* Properties */
    private static Properties props = ReadProperties.getProperties();
    private static final String url = props.getProperty("url");

    /* Private constructor - only one instance possible for this class */
    private WebApp() {
        instance = this;
    }

    public static WebApp getInstance() {
        if (instance != null) {
            return instance;
        } else {
            instance = new WebApp();
            return instance;
        }
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = initializeDriver();
        }
        return driver;
    }

    public static VideosHomePage gotoVideosHomePage() {
        driver = getDriver();
        driver.manage().deleteAllCookies();
        driver.get(url);
        VideosHomePage videosHomePage = new VideosHomePage(driver);
        Assert.assertTrue(videosHomePage.verifyPageLoaded());
        return videosHomePage;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    protected void finalize() throws Throwable {
        quitDriver();
        super.finalize();
    }
//
//    public static boolean verifyPageLoaded() {
//        return driver.getPageSource().contains(pageLoadedText);
//    }
}
