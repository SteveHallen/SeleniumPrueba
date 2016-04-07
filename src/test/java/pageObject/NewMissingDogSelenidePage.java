package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by 077 on 30/3/2016.
 */

public class NewMissingDogSelenidePage {

    private By nameLocator = new By.ByCssSelector("[ng-model='newDog.name']");
    private By buttonSubmitLocator = new By.ByCssSelector("[type='submit']");
    private By descriptionLocator= new By.ByCssSelector("[ng-model='newDog.description']");
    private By lostLocationLocator= new By.ByCssSelector("[ng-model='newDog.lostlocation']");
    private By raceDropDownLocator= new By.ByCssSelector("[ng-model='newDog.race']");

    public void selectRace(String race){
        $(raceDropDownLocator).selectOption(race);
    }
    public void typeName(String name){
        $(nameLocator).setValue(name);
    }
    public void typeDescription(String description){
        $(descriptionLocator).setValue(description);
    }
    public void typeLostLocation(String lostLocation){
        $(lostLocationLocator).setValue(lostLocation);
    }
    public void clickSubmit(){
        $(buttonSubmitLocator).click();
    }
    public void hoverButton(){
        $(buttonSubmitLocator).hover();
    }
}
