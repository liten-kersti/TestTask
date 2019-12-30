package MyFirstSeleniumProject.MyFirstSeleniumProject.Tests;

import MyFirstSeleniumProject.MyFirstSeleniumProject.Pages.AccentureHomepage;
import MyFirstSeleniumProject.MyFirstSeleniumProject.Pages.ApplyPage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class RunCucumberTest extends AbstractTestNGCucumberTests {


    WebDriver driver;

    @Given("User lands on Homepage$")
    public void user_lands_on_homepage() throws Exception {

        System.setProperty("webdriver.chrome.driver", "C:\\Driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.accenture.com/lv-en");
        throw new PendingException();
    }

    @When("User navigates to Apply page$")
    public void user_navigates_to_apply_page() throws Exception {
        AccentureHomepage accentureHomepage = new AccentureHomepage(driver);
        accentureHomepage.Careers().click();
        accentureHomepage.Apply().click();
        throw new PendingException();
    }

    @Then("^Test checks presence of header, searchbox and search button$")
    public void test_checks_presence_of_header_searchbox_and_search_button() throws Exception {
        ApplyPage applyPage = new ApplyPage(driver);
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

        throw new PendingException();
    }

}
