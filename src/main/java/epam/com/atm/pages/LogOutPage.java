package epam.com.atm.pages;

import epam.com.atm.driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class LogOutPage extends BasePage {
    private By menuButtonBy = By.xpath("//a[contains(@href,'SignOutOptions')]");
    private By logoutBy = By.xpath("//*[text()='Sign out']//parent::div//parent::span//parent::a");

    public LogOutPage(WebDriver driver) {
        super();
    }

    public void logOut() throws MalformedURLException {

        DriverSingleton.getDriver().findElement(menuButtonBy).click();
        //   WebElement iframe = DriverSingleton.getDriver().findElement(By.cssSelector("//iframe[@name='account']"));
        //  DriverSingleton.getDriver().switchTo().frame(iframe);
        waitElementToBeClicable(logoutBy);
        DriverSingleton.getDriver().findElement(logoutBy).click();
    }
}
