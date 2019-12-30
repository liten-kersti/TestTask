package MyFirstSeleniumProject.MyFirstSeleniumProject.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ApplyPage {
    private WebDriver driver;
    public ApplyPage (WebDriver driver) { this.driver=driver; }
        By pageTitle = By.xpath("//h1[@class='page-title']");
        By btn = By.xpath("//span[@class='button-text ucase']");
        By searchBox = By.xpath("//input[@id='job-search-hero-bar']");

    public WebElement PageTitle () { return driver.findElement(pageTitle); }
    public WebElement Btn () { return driver.findElement(btn); }
    public WebElement SearchBox () { return driver.findElement(searchBox); }
}
