package pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.ElementLocator;
import org.openqa.selenium.support.pagefactory.FieldDecorator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Field;
import java.util.List;

/**
 * Created by 077 on 30/3/2016.
 */
public class NewMissingDogsPage {

    Integer TIMEOUT = 5;
    WebDriver driver;

    @FindBy(css="[ng-model='newDog.name']")
    WebElement inputName;
    @FindBy(css="[ng-model='newDog.description']")
    WebElement textAreaDescription;
    @FindBy(css="[ng-model='newDog.lostlocation']")
    WebElement textAreaLostlocation;
    @FindBy(css="[ng-model='newDog.race']")
    WebElement dropdownRace;
    @FindBy(css="[type='submit']")
    WebElement submitButton;

    public NewMissingDogsPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);


    }

    public void typeName(String text){
       whenIsReady(inputName).sendKeys(text);
    }

    public void typeDescription(String text){
        whenIsReady(textAreaDescription).sendKeys(text);
    }

    public void typeLostlocation(String text){
        whenIsReady(textAreaLostlocation).sendKeys(text);
    }

    public void selectRace(String text){
        new Select(whenIsReady(dropdownRace)).selectByVisibleText(text);
    }

    public void clickBotonNewMissingDog(){
        whenIsReady(submitButton).submit();
    }

    public WebElement whenIsReady(WebElement element){
        new WebDriverWait(driver, TIMEOUT).until(ExpectedConditions.visibilityOf(element));
        return element;
    }

}
