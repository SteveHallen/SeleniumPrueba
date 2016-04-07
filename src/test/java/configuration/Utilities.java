package configuration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.UUID;

/**
 * Created by 077 on 4/4/2016.
 */
public class Utilities {

    public static String randomString(int cantidadCaracteres, int cantidadPalabras) {
        String result = UUID.randomUUID().toString().replace("-","").substring(0,cantidadCaracteres);
        return result;
    }
}