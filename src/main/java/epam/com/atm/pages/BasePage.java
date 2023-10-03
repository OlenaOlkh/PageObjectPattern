package epam.com.atm.pages;

import epam.com.atm.driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;

public class BasePage {
    public final int WAITER_DURATION = 5;

    public void waitElementToBeClicable(By elementBy) throws MalformedURLException {

        new WebDriverWait(DriverSingleton.getDriver(), Duration.ofSeconds(WAITER_DURATION)).until(ExpectedConditions.elementToBeClickable(elementBy));
    }

    public String getAttributeBy(By elementBy, String attribute) throws MalformedURLException {
        return DriverSingleton.getDriver().findElement(elementBy).getAttribute(attribute);
    }


    public Boolean ifElementIsDisplayed(By elementBy) throws MalformedURLException {
        return DriverSingleton.getDriver().findElement(elementBy).isDisplayed();
    }
}
