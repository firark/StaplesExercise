package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
    public WebDriver driver;
    By searchInput = By.name("q");
    By luckySubmit = By.xpath("//*[@name='btnI']");
    By introAgree = By.xpath("//*[@id=\"introAgreeButton\"]/span/span");
    By frame = By.xpath("//*[@id=\"cnsw\"]/iframe");

    public LandingPage(WebDriver driver){ this.driver=driver; }
    public WebElement getInput()
    {
        return driver.findElement(searchInput);
    }
    public WebElement getLuckySubmit()
    {
        return driver.findElement(luckySubmit);
    }
    public WebElement getFrame() { return driver.findElement(frame); }
    public WebElement getIntroAgree() { return driver.findElement(introAgree); }

}
