package configuration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class WaitHelper {

	public static final int TIMEOUT = 500;


	public static void forElementClickable(WebDriver driver, By by, int timeout) {
		try{(new WebDriverWait(driver, timeout)).until(ExpectedConditions
				.elementToBeClickable(by));}catch (Exception e){e.printStackTrace();}
	}
	
	public static void forElementClickable(WebDriver d, By by) {
		try{(new WebDriverWait(d, TIMEOUT)).until(ExpectedConditions
				.elementToBeClickable(by));}catch (Exception e){e.printStackTrace(); }
	}

	public static void forValue(WebDriver dirver, By by, int timeout, String value) {
		try{(new WebDriverWait(dirver, timeout)).until(ExpectedConditions
				.textToBePresentInElementValue(by, value));}catch (Exception e){e.printStackTrace();}
	}

	public static void forValue(WebDriver driver, By by, String value) {
		forValue(driver, by, TIMEOUT, value);
	}

	public static void forVisibility(WebDriver driver, By by, int timeout) {
		(new WebDriverWait(driver, timeout)).until(ExpectedConditions
				.presenceOfElementLocated(by));
	}

	public static void forVisibility(WebDriver driver, By by) {
		try{ forVisibility(driver, by, TIMEOUT);}catch (Exception e){e.printStackTrace();}
	}

	public static void forPresence(WebDriver driver, By by, int timeout) {
		try{(new WebDriverWait(driver, timeout)).until(ExpectedConditions
				.presenceOfElementLocated(by));}catch (Exception e){e.printStackTrace();}
	}

	public static void forPresence(WebDriver driver, By by) {
		try{forPresence(driver, by, TIMEOUT);}catch (Exception e){e.printStackTrace();}
	}

	public static void forInvisibility(WebDriver driver, By by, int timeout) {
		try {(new WebDriverWait(driver, timeout)).until(ExpectedConditions
				.invisibilityOfElementLocated(by));}catch (Exception e){e.printStackTrace();}
	}

	public static void forSpinnerInvisibility(WebDriver driver, By by, int timeout){
		//Wait Until the spinner disappears
		int time = 0;
		boolean isSpinnerDisplayed = true;

		while (time < timeout && isSpinnerDisplayed == true){
			isSpinnerDisplayed = false;
			try{
				List<WebElement> listOfSpinners = driver.findElements(by);
				for (int i = 0; i < listOfSpinners.size(); i++) {
					if (listOfSpinners.get(i).isDisplayed()) {
						WaitHelper.sleep(2);
						time += 1;
						isSpinnerDisplayed = true;
					}
				}
			}catch (Exception e){
				time += 1;
			}
		}
	}

	public static void forInvisibility(WebDriver driver, By by) {
		try{ forInvisibility(driver, by, TIMEOUT);}catch (Exception e){e.printStackTrace();}
	}

	public static void sleep(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void forUpdateAttr(WebDriver driver, By by, String attribute,
			String expected, int timeout) {
		int tries = 0;
		while (!driver.findElement(by).getAttribute(attribute).contains(expected)
				&& tries < timeout) {
			sleep(1);
			tries++;
		}
	}
	public static boolean isShown(WebDriver driver, By locator){
		try{
			driver.findElement(locator);
			return true;
		}catch (NoSuchElementException e){
			return false;
		}
	}

	public static void forElement(WebDriver driver, By by, int timeout) {
		try {
			int tries = 0;
			while (!isShown(driver, by) && tries < timeout) {
				sleep(1);
				tries++;
			}}catch (Exception e){}
	}


	public static void forElementDisplayed(WebDriver driver, By by, int timeout) {

        WebDriverWait wait = new WebDriverWait(driver, timeout);//
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));

		/*driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);*/

		/*try {
			int tries = 0;
			while (! driver.findElement(by).isDisplayed() && tries < timeout) {
				sleep(2);
				tries++;
			}}catch (Exception e){}*/

	}

	public static void forUpdateAttr(WebDriver driver, By by, String attribute,
			String expected) {
		forUpdateAttr(driver, by, attribute, expected, TIMEOUT);
	}

	public static void forUpdateText(WebDriver driver, By by, String expected,
			int timeout) {
		int tries = 0;
		while (!driver.findElement(by).getText().contains(expected)
				&& tries < timeout) {
			sleep(1);
			tries++;
		}
	}

	public static void forUpdateText(WebDriver driver, By by, String expected) {
		forUpdateText(driver, by, expected, TIMEOUT);
	}

	public static Boolean forConditionHappening(WebDriver driver,
			Callable<Boolean> evaluator, int checkInterval, int timeOut) {
		long startMillis = (new Date()).getTime();
		long currentMillis = startMillis;
		boolean timeouted = false;
		Boolean conditionHappened = false;

		try {
			while (!conditionHappened && !timeouted) {
				conditionHappened = evaluator.call();
				if (!conditionHappened) {
					sleep(checkInterval);
					currentMillis = (new Date()).getTime();
					timeouted = (((currentMillis - startMillis) / 1000) > timeOut);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return conditionHappened;
	}

}
