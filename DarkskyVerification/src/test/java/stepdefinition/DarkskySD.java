package stepdefinition;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import framework.webPages.BasePage;
import framework.webPages.HomePage;
import framework.webPages.LoginPage;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import framework.webPages.HomePage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class DarkskySD {
    private HomePage homePage=new HomePage();
    private BasePage basePage=new BasePage();


    @Given("^I am on Darksky homepage$")

    public void iamOnHomePage(){
        Assert.assertEquals(SharedSD.getDriver().getTitle(), "Dark Sky - 260 Broadway, New York City, NY");
    }

@Then("^I verify timeline is displayed with two hours incremented$")
public void verifyTimeline2HrsIncremented(){Assert.assertEquals(homePage.darkSkyHrs(),homePage.actualHours());}


@When("^I expand today's timeline$")
public void expandDarkSkyTimeline() throws InterruptedException {homePage.clickOnTimeLine();}

@Then("^I verify lowest and highest temp is displayed correctly$")
public void lowestHighestDisplayedCorrectly(){Assert.assertTrue(homePage.verifyHighLowtempDisplayedCorrectly());}


@Then("^I verify current temp is not greater or less then temps from daily timeline$")
    public void verifyCurrentTemperatureNotGreaterLowerThanDaily(){
        Assert.assertTrue(homePage.VerifyGreaterLowerThanCurrentTemp());
}






}


