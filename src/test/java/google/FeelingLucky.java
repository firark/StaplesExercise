package google;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.LandingPage;
import resources.base;

import java.io.IOException;

public class FeelingLucky extends base {
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
    public void FeelingLuckySearch () {
        LandingPage lp = new LandingPage(driver);
        lp.getInput().sendKeys("Staples Solutions Gdansk");
        lp.getLuckySubmit().click();
        System.out.println("Entering 'Staples Solutions Gdansk' in the search input and clicking Feeling Lucky button.");
        System.out.println(driver.getCurrentUrl());

        if (driver.getTitle().contains("Staples Solutions")) {
            Assert.assertTrue(true);
            System.out.println("User directed to staplespolska.pl");
        }
        else {
            System.out.println("User NOT directed to staplespolska.pl");
            Assert.fail();
        }
    }

    @AfterMethod
    public void teardown() {
        System.out.println("Quitting browser.");
        driver.quit(); }

}
