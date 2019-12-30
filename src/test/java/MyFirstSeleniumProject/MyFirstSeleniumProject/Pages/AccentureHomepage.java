package MyFirstSeleniumProject.MyFirstSeleniumProject.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccentureHomepage {

    private WebDriver driver;
    public AccentureHomepage(WebDriver driver){
        this.driver=driver;
    }

        By careers = By.xpath("//div[@aria-label='Careers']");
        By apply = By.xpath("//a[@data-analytics-link-name='search and apply']");

    public WebElement Careers ()
    {
        return driver.findElement(careers);
    }
    public WebElement Apply()
    {
        return driver.findElement(apply);
    }
}
