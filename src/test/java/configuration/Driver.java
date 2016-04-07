package configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by 077 on 30/3/2016.
 */
public class Driver {
    WebDriver driver;


    public WebDriver getWebDriver() {
        return driver;
    }

    public Driver(String typeOfBrowser){

        if (typeOfBrowser.equals("Firefox")) {
            driver = new FirefoxDriver();

        } else if (typeOfBrowser.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\077\\Downloads\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
        } else {
            driver = new FirefoxDriver();
        }

        driver.get("http://localhost/MissingDog/#/findmissingdogs");
    }

    public void closeBrowser(){

        driver.quit();
    }
}
