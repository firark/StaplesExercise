package google;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.LandingPage;
import pageObjects.SearchResult;
import resources.base;

import java.io.IOException;

public class StaplesSearch extends base {
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
    public void StaplesBaseSearch () {
        LandingPage lp = new LandingPage(driver);
        lp.getInput().sendKeys("Staples Solutions Gdansk");
        lp.getInput().sendKeys(Keys.ENTER);
        System.out.println("Entering 'Staples Solutions Gdansk' in the search input and submitting with Enter.");
        System.out.println(driver.getCurrentUrl());

        SearchResult sr = new SearchResult(driver);
        if (sr.getStaplesResult().getText().contains("staplespolska.pl")) {
            Assert.assertTrue(true);
            System.out.println("staplespolska.pl is found.");
        }
        else {
            System.out.println("staplespolska.pl not found.");
            Assert.fail();
        }

    }

    @AfterMethod
    public void teardown() {
        System.out.println("Quitting browser.");
        driver.quit(); }

}
