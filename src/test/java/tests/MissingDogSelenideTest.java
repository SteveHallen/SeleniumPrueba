package tests;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.testng.TextReport;
import configuration.Utilities;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import pageObject.FinderMissingDogsSelenidePage;
import pageObject.NewMissingDogSelenidePage;

import static com.codeborne.selenide.Selenide.*;

/**
 * Created by 077 on 1/4/2016.
 */

@Listeners(TextReport.class)
public class MissingDogSelenideTest {


    NewMissingDogSelenidePage newMissingDogPage;
    FinderMissingDogsSelenidePage finderMissingDogsPage;


    String race;
    String name;
    String description;
    String lostlocation;

    @BeforeTest
    public void setUp() throws ATUTestRecorderException {
        open("http://localhost/MissingDog/#/findmissingdogs");
        newMissingDogPage = new NewMissingDogSelenidePage();
        finderMissingDogsPage = new FinderMissingDogsSelenidePage();



        race = "Maltes";
        name = Utilities.randomString(15,3);
        description = Utilities.randomString(15,3);
        lostlocation = Utilities.randomString(15,3);
    }



   /* @Test(priority = 1)
    public void newMissingDogWithTest() {


        newMissingDogPage.selectRace(race);
        newMissingDogPage.typeName(name);
        newMissingDogPage.typeDescription(description);
        newMissingDogPage.typeLostLocation(lostlocation);
        newMissingDogPage.clickSubmit();

        finderMissingDogsPage.clickBtnSearchAll();
        Assert.assertTrue(finderMissingDogsPage.existDog(race,name,description,lostlocation),"Existe un perrito con esa raza nombre descripcion y lostlocation");
    }

    @Test(priority = 2)
    public void changeStateTest() {

        finderMissingDogsPage.clickBtnSearchAll();
        finderMissingDogsPage.changeTolostDog(race,name,description,lostlocation);
        Assert.assertTrue(finderMissingDogsPage.isLost(race,name,description,lostlocation),"Perro perdido: "+name);

        finderMissingDogsPage.changeToPossiblyFoundDog(race,name,description,lostlocation);
        Assert.assertTrue(finderMissingDogsPage.isPossiblyFound(race,name,description,lostlocation),"Perro posiblemente encontrado: "+name);


    }*/

   /* @Test(priority = 3)
    public void findByRaceTest() {
        String race = "Beagle";

        finderMissingDogsPage.typeRace(race);
        finderMissingDogsPage.clickBtnSearchRace();
        Assert.assertTrue(finderMissingDogsPage.allResultsHaveThisRace(race),"Todos los resultados tienen como raza: "+race);

        race = "Boxer";

        finderMissingDogsPage.typeRace(race);
        finderMissingDogsPage.clickBtnSearchRace();
        Assert.assertTrue(finderMissingDogsPage.allResultsHaveThisRace(race),"Todos los resultados tienen como raza: "+race);

    }*/


    @Test(priority = 4)
    public void findByRaceTest() {

        finderMissingDogsPage.clickBtnSearchAll();
        ElementsCollection listDogs1 = finderMissingDogsPage.findDogs().filterBy(Condition.text(race));


        finderMissingDogsPage.typeRace(race);
        finderMissingDogsPage.clickBtnSearchRace();
        ElementsCollection listDogs2  = finderMissingDogsPage.findDogs();

        Assert.assertTrue(listDogs1.size() == listDogs2.size(),"Filtrar por raza"+race);


    }







     /*   @Test
    public void newMissingDogWithoutPageObject() {
        open("http://localhost/MissingDog/#/newmissingdog");
        $(By.cssSelector("[ng-model='newDog.name']"))
        a.setValue("Spyke2").pressEnter();
        a.getText().equals(text("Spyke2"));

    }*/



}
