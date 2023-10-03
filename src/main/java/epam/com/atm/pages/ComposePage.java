package epam.com.atm.pages;

import epam.com.atm.driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class ComposePage extends BasePage {
    public By clickCompose = By.xpath("//div[text()='Compose']");

    public ComposePage(WebDriver driver) {
        super();
    }

    public By getComposeBy() throws MalformedURLException {
        waitElementToBeClicable(clickCompose);
        return clickCompose;
    }

    public FillEmailPage compose() throws MalformedURLException {

        DriverSingleton.getDriver().findElement(clickCompose).click();
        return new FillEmailPage(DriverSingleton.getDriver());
    }

}
