package stepDefinitions;

import io.cucumber.java.en.*;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import pageObjects.LandingPage;
import pageObjects.SearchResult;
import resources.base;

@RunWith(Cucumber.class)
public class stepDefinitions extends base {

    @Given("^Open the browser$")
    public void open_the_browser() throws Throwable {
        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
    }

    @And("^I am taken to Google Homepage$")
    public void i_am_taken_to_google_homepage() {
        LandingPage lp = new LandingPage(driver);
        if (lp.getFrame().isDisplayed()) {
            driver.switchTo().frame(0);
            lp.getIntroAgree().click();
        }
        else
            System.out.println("The apply frame is not displayed.");
    }

    @When("^I enter text to search \"([^\"]*)\"$")
    public void i_enter_text_to_search_something(String arg1) {
        LandingPage lp = new LandingPage(driver);
        lp.getInput().sendKeys(arg1);
    }

    @Then("^I am taken to results page$")
    public void i_am_taken_to_results_page() {
        System.out.println(driver.getCurrentUrl());
    }

    @Then("^I am taken to staplespolska.pl Landing page$")
    public void i_am_taken_to_staplespolskapl_landing_page() {
        System.out.println(driver.getCurrentUrl());
    }

    @Then("^I quit the browser$")
    public void i_quit_the_browser() {
        driver.quit(); }

    @And("^Submit the search with Enter$")
    public void submit_the_search_with_enter() {
        LandingPage lp = new LandingPage(driver);
        lp.getInput().sendKeys(Keys.ENTER);
    }

    @And("^Staples Solutions page is displayed as one of the results.$")
    public void staples_solutions_page_is_displayed_as_one_of_the_results() {
        SearchResult sr = new SearchResult(driver);
        if (sr.getStaplesResult().getText().contains("staplespolska.pl")) {
            Assert.assertTrue(true);
        }
        else {
            Assert.fail();
        }
    }

    @And("^Submit the search with I'm Feeling Lucky button$")
    public void submit_the_search_with_im_feeling_lucky_button() {
        LandingPage lp = new LandingPage(driver);
        lp.getLuckySubmit().click();
    }

    @But("^There are no results for that search$")
    public void there_are_no_results_for_that_search() {

        SearchResult sr = new SearchResult(driver);
        if (sr.getNoResults().isDisplayed()) {
            Assert.assertTrue(true);
        }
        else
        {
            System.out.println("Results were found.");
            Assert.fail();
        }
    }

}