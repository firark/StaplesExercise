package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchResult {
    public WebDriver driver;
    By staplesResult = By.partialLinkText("Staples Solutions");
    By noResults = By.className("mnr-c");

    public SearchResult(WebDriver driver) { this.driver = driver; }
    public WebElement getStaplesResult() { return driver.findElement(staplesResult); }
    public WebElement getNoResults() { return driver.findElement(noResults); }


}
