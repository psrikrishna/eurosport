package uk.co.eurosport.steps;

import cucumber.api.PendingException;
import cucumber.api.java.it.Data;
import org.junit.Assert;
import uk.co.eurosport.framework.WebApp;
import uk.co.eurosport.pages.TennisVideosPage;
import uk.co.eurosport.pages.VideoPlayerPage;
import uk.co.eurosport.pages.VideosHomePage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class StepDefs {

    private static final Logger log = LogManager.getLogger(StepDefs.class);
    private static WebApp webApp;
    private static VideosHomePage videosHomePage;
    private static TennisVideosPage tennisVideosPage;
    private static VideoPlayerPage videoPlayerPage;

    @Given("^I am Eurosport Customer$")
    public void main_page_is_loaded() throws Throwable {
        webApp = WebApp.getInstance();
    }

    @When("^On Videos Hub Page$")
    public void i_login_into_the_webpage() throws Throwable {
        videosHomePage = webApp.gotoVideosHomePage();
    }

    @When("^I select to watch the videos from Tennis Section$")
    public void iSelectToWatchTheVideosFromTennisSection() throws Throwable {
        tennisVideosPage = videosHomePage.openTennisVideosFromAllSportsMenu();
    }

    @Then("^the selected video is playing$")
    public void theSelectedVideoIsPlaying() throws Throwable {
       videoPlayerPage = tennisVideosPage.closeAdvertAndOpenSelectedVideo();
    }

    @And("^the following player controls are displayed$")
    public void theFollowingPlayerControlsAreDisplayed(DataTable table) throws InterruptedException {
          List<String> totalList = table.asList(String.class);
            videoPlayerPage.verifyControls(totalList);
    }


    @And("^the following top events are displayed$")
    public void theFollowingTopEventsAreDisplayed(DataTable table) throws Throwable {
        List<String> totalList = table.asList(String.class);
        List<String> tennisTournaments = tennisVideosPage.getListOTennisTournaments();

        for(int i=1;i<tennisTournaments.size()-3;i++){
            Assert.assertEquals(totalList.get(i-1),tennisTournaments.get(i));
        }
    }
}
