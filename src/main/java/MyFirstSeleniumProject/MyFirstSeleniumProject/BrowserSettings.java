package MyFirstSeleniumProject.MyFirstSeleniumProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BrowserSettings {

    public WebDriver driver;

    public WebDriver initDriver() throws IOException {
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(
                "src//main//java//MyFirstSeleniumProject//MyFirstSeleniumProject//data.properties"
        );
        properties.load (fileInputStream);
       String browserName = properties.getProperty("browser");

       if (browserName.equals("chrome")) {
           //execute Chrome
           System.setProperty("webdriver.chrome.driver","C:\\Driver\\chromedriver.exe");
           driver = new ChromeDriver();
       }
       else if (browserName.equals("firefox")) {
           //execute Firefox
           System.setProperty("webdriver.gecko.driver","C:\\Driver\\geckodriver.exe");
           driver = new FirefoxDriver();

        }
       else if (browserName.equals("ie")) {
           //execute ie
           System.setProperty("webdriver.ie.driver","C:\\Driver\\iedriver.exe");
           driver = new InternetExplorerDriver();
       }
       else {
            System.out.println ("Enter correct browser name");
        }

       driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
       return driver;
    }
}
