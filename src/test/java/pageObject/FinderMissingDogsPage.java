package pageObject;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import configuration.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by 077 on 30/3/2016.
 */
public class FinderMissingDogsPage {
    WebDriver driver;


    private By inputRaceLocator = By.cssSelector("[ng-model='findby race']");
    private By titleFindMissingDogLocator = By.cssSelector("[for='race']");
    private By containerDogsLocator = By.cssSelector(".container.well");
    private By descriptionLocator = By.cssSelector(".description");

    public FinderMissingDogsPage(WebDriver driver){
        this.driver = driver;

    }


    /*public boolean exist(String description, String name, String location, String race ){
        List<WebElement> listOfContainers = getListOfMissingDogsElements();
        for (WebElement container : listOfContainers) {
           if(container.findElement(descriptionLocator).getText().trim().equals(description) )
                   {
                           return true;
                   }
        }

        return false;
    }*/

    public List<WebElement> getListOfMissingDogsElements(){
        WaitHelper.forElementDisplayed(driver, containerDogsLocator, 120);
        return driver.findElements(containerDogsLocator);
        /*return driver.findElements(containerDogsLocator);*/
    }

    /*public String getRaceFirstDog(){

        WaitHelper.forElementDisplayed(driver, containerDogsLocator, 120);
        List<WebElement> a driver.findElements(containerDogsLocator);
        a.get(0).findElement(By.cssSelector(class="lostlocation ng-binding"Çz))

    }*/

    public boolean titleContains(String title){
        System.out.println(driver.findElement(titleFindMissingDogLocator).getText());
        return (driver.findElement(titleFindMissingDogLocator)).getText().equals(title);
    }

    public boolean isInputDisplayed(){

        return driver.findElement(inputRaceLocator).isDisplayed();
    }
}
