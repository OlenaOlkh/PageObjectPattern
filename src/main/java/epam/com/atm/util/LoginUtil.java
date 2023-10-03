package epam.com.atm.util;


import epam.com.atm.pages.ComposePage;
import java.net.MalformedURLException;

public class LoginUtil {
    public static Boolean isUserLogin(ComposePage composePage) throws MalformedURLException {
        return composePage.ifElementIsDisplayed(composePage.getComposeBy());
    }
}
