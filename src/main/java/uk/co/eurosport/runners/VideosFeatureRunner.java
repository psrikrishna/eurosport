package uk.co.eurosport.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/main/resources/features/WatchVideos.feature",
        glue = "uk.co.eurosport.steps",
        monochrome = true)

/**
 * Created by Krishna on 14/07/2019.
 */
public class VideosFeatureRunner extends AbstractTestNGCucumberTests {
}
