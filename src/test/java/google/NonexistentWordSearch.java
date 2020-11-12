package google;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.LandingPage;
import pageObjects.SearchResult;
import resources.base;

import java.io.IOException;

public class NonexistentWordSearch extends base {
    public WebDriver driver;

    @BeforeClass(alwaysRun = true)
    public void Initialize() throws IOException
    {
        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
    }

    @BeforeMethod
    public void CloseIFrame()
    {
        LandingPage lp = new LandingPage(driver);
        if (lp.getFrame().isDisplayed()) {
            System.out.println("The apply frame is displayed.");
            driver.switchTo().frame(0);
            lp.getIntroAgree().click();
            System.out.println("Apply frame accepted.");
        }
        else
            System.out.println("The apply frame is not displayed.");
    }

    @Test
    public void NonexistentSearch() {
        LandingPage lp = new LandingPage(driver);
        lp.getInput().sendKeys("StaplesSolutionsGdanskPolskaSearchWithNoResultsThisTime");
        lp.getInput().sendKeys(Keys.ENTER);
        System.out.println(driver.getCurrentUrl());

        SearchResult sr = new SearchResult(driver);
        if (sr.getNoResults().isDisplayed()) {
            Assert.assertTrue(true);
            System.out.println("No results for the search.");
        }
        else
        {
            System.out.println("Results were found.");
            Assert.fail();
        }
    }

    @AfterMethod
    public void teardown()
    {
        System.out.println("Quitting browser.");
        driver.quit();
    }
}