package epam.com.atm.pages;

import epam.com.atm.driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

public class CheckEmailPage extends BasePage {
    public By sendButton = By.xpath("//div[text()='Send']");
    public String emailRecipient = "//*[@email='%s']";


    public CheckEmailPage(WebDriver driver) {
        super();
    }

    public By getEmail(String email) throws MalformedURLException {
        By locator = By.xpath(String.format(emailRecipient, email));
        waitElementToBeClicable(locator);
        return locator;
    }

    public SentFolderPage send() throws MalformedURLException {

        WebElement sendButton1 = DriverSingleton.getDriver().findElement(sendButton);
        JavascriptExecutor js = (JavascriptExecutor) DriverSingleton.getDriver();
        js.executeScript("arguments[0].click();", sendButton1);

        return new SentFolderPage(DriverSingleton.getDriver());
    }
}
