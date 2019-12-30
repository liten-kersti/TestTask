package MyFirstSeleniumProject.MyFirstSeleniumProject.Tests;

import MyFirstSeleniumProject.MyFirstSeleniumProject.BrowserSettings;
import MyFirstSeleniumProject.MyFirstSeleniumProject.Pages.AccentureHomepage;
import MyFirstSeleniumProject.MyFirstSeleniumProject.Pages.ApplyPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;


public class AppTest extends BrowserSettings {

    @BeforeClass
    public void beforeClass() throws IOException {
       driver = initDriver();
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }

    @Test

    public void ElementsPresence() {

        driver.get("https://www.accenture.com/lv-en");
        AccentureHomepage accentureHomepage=new AccentureHomepage(driver);

        //navigating to Apply Page
         accentureHomepage.Careers().click();
         accentureHomepage.Apply().click();

        ApplyPage applyPage=new ApplyPage(driver);

        //verifying the SEARCH button is present and contains 'SEARCH' text
         WebElement button = applyPage.Btn();
         String buttonText = button.getText();
         String expectedText = "SEARCH";
         Assert.assertEquals(buttonText, expectedText, "Text not found!");

        //verifying header text is present
         WebElement title = applyPage.PageTitle();
         String titleText = title.getText();
         String expectedTitle = "Search Jobs at Accenture";
         Assert.assertEquals(titleText, expectedTitle, "Title not found!");

        //verifying searchbox is present
       applyPage.SearchBox().isDisplayed();

    }
}


