package pageObject;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.commands.Click;
import com.codeborne.selenide.impl.CollectionElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import static com.codeborne.selenide.Condition.and;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

/**
 * Created by 077 on 4/4/2016.
 */
public class FinderMissingDogsSelenidePage {

    private By inputRaceLocator = By.cssSelector("[ng-model='findby.race']");
    private By searchButtonLocator= By.cssSelector("[type='submit']");
    private By searchAllButtonLocator = By.cssSelector("[ng-click='getAll()']");
    private By containerDogsLocator = By.cssSelector(".container.well");
    private By raceDogsLocator = By.cssSelector(".race.ng-binding");

    private By stateDogLocator = By.id("state");

    private By lostBtnLocator = By.cssSelector(".btn-danger");
    private By possiblyFoundBtnLocator = By.cssSelector(".btn-success");





    public void typeRace(String race){
        $(inputRaceLocator).setValue(race);
    }
    public void clickBtnSearchRace(){
        $(searchButtonLocator).click();
    }
    public void clickBtnSearchAll(){
        $(searchAllButtonLocator).click();
    }

    public SelenideElement findDog(String race, String name, String description, String lostlocation) {

        ElementsCollection lista = $$(containerDogsLocator);

        for(int i=0; i<lista.size();i++){

            if(lista.get(i).has(text(name)) &&
                    lista.get(i).has(text(race)) &&
                    lista.get(i).has(text(description)) &&
                    lista.get(i).has(text(lostlocation))){

                return lista.get(i);
            }
        }
        return null;
        /*    return $$(containerDogsLocator).shouldHave(CollectionCondition.exactTexts("Beagle"
                                                ,name
                                                ,description
                                                ,lostlocation)).first();*/

    }

    public boolean existDog(String race, String name, String description, String lostlocation) {

        if(findDog(race,name,description,lostlocation)==null){
            return false;
        }
        else{
            return true;
        }

    }


    public boolean allResultsHaveThisRace(String race){

        boolean allResultsHaveThisRace = true;

        for(SelenideElement element : $$(containerDogsLocator)){
            if(!(element.find(raceDogsLocator).getText().equals(race))) {
                System.out.println(element.find(raceDogsLocator).getText());
                System.out.println(race);
                allResultsHaveThisRace = false;
            }
        }

        return allResultsHaveThisRace;
    }

    public void changeToPossiblyFoundDog(String race, String name, String description, String lostlocation){
        findDog(race,name,description,lostlocation).find(possiblyFoundBtnLocator).click();
    }

    public void changeTolostDog(String race, String name, String description, String lostlocation){
        findDog(race,name,description,lostlocation).find(lostBtnLocator).click();
    }

    public boolean isLost(String race, String name, String description, String lostlocation) {
        return findDog(race,name,description,lostlocation).find(stateDogLocator).getText().equals("Lost");

    }

    public boolean isPossiblyFound(String race, String name, String description, String lostlocation) {
        return findDog(race,name,description,lostlocation).find(stateDogLocator).getText().equals("PossibleFounded");
    }

    public ElementsCollection findDogs() {

        return $$(containerDogsLocator);
    }
}
