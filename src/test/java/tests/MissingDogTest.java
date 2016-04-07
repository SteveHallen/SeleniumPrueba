package tests;

import atu.testrecorder.exceptions.ATUTestRecorderException;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import configuration.Driver;
import configuration.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.service.DriverService;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.HomeMissingDogsPage;
import pageObject.NewMissingDogsPage;
import pageObject.FinderMissingDogsPage;

import java.sql.DriverManager;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;

/**
 * Created by 077 on 30/3/2016.
 */
public class MissingDogTest {
    private Driver driver;
    private HomeMissingDogsPage homeMissingDogsPage;
    private FinderMissingDogsPage findMissingDogPage;
    private NewMissingDogsPage newMissingDogPage;


    @BeforeTest
    public void setUp() throws ATUTestRecorderException {
        driver  = new Driver("Chrome");
        driver.getWebDriver().manage().window().maximize();

        homeMissingDogsPage = new HomeMissingDogsPage(driver.getWebDriver());
        findMissingDogPage = new FinderMissingDogsPage(driver.getWebDriver());
        newMissingDogPage = new NewMissingDogsPage(driver.getWebDriver());

    }
/*
    @Test
    public void testNewMissingDog(){
*/
        /*newMissingDogPage.selectRace("Pekines");*/

        /*newMissingDogPage.typeName("Spyke");
        newMissingDogPage.typeName("Spyke");*/

      /*  newMissingDogPage.typeName("Spyke");
        newMissingDogPage.typeDescription("Description");
        newMissingDogPage.typeLostlocation("Lost Location");
        newMissingDogPage.clickBotonNewMissingDog();

        findMissingDogPage.isInputDisplayed();

        Assert.assertTrue(driver.getWebDriver().getCurrentUrl().equals("http://localhost/MissingDog/#/findmissingdogs"));
*/
  /*  }*/

    @Test
    public void searchAMissingDog(){

     /*   open("http://localhost/MissingDog/#/findmissingdogs");
        By containerDogsLocator = By.cssSelector(".container.well");
        List<SelenideElement> a = Selenide.getElements(containerDogsLocator);
        System.out.println(a.get(0).getText());
        System.out.println(a.get(0).getText());
*/
        List<WebElement> a = findMissingDogPage.getListOfMissingDogsElements();
        System.out.println(a.get(0).getText());
        System.out.println(a.get(0).getText());


    }

    /*@Test
    public void searchByRace(){
        newMissingDogPage.selectRace("Pekines");
        newMissingDogPage.typeName("Spyke");

    }
*/


  /*  @AfterTest
    public void testFinish() throws ATUTestRecorderException {
        driver.closeBrowser();

    }
*/


}
