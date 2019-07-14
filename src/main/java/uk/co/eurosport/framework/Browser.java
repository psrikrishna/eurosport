package uk.co.eurosport.framework;
import cucumber.api.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Properties;

/**
 * Created by Krishna on 14/07/2019.
 */
public class Browser {

    private static String browser;
    private static WebDriver driver;
    private static Properties props = ReadProperties.getProperties();

    public static WebDriver initializeDriver() {
        browser = props.getProperty("browser");

        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/drivers/chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                break;
            default:
                System.out.println("Browser not implemented");
                driver.quit();
                break;
        }
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    @After
    public void closeBrowser(){
        driver.quit();
    }
}
