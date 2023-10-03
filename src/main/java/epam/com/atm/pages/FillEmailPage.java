package epam.com.atm.pages;

import epam.com.atm.driver.DriverSingleton;
import epam.com.atm.model.Email;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.net.MalformedURLException;
import java.time.Duration;

public class FillEmailPage extends BasePage {
    public By fieldSubject = By.name("subjectbox");
    public By emailSubject = By.xpath("//*[@name='subjectbox']");
    public By fieldRecipient = By.xpath("//div[text()='Recipients']");
    public By emailRecipient = By.xpath("//*[@email='olenaotest@gmail.com']");
    public By messageBody = By.xpath("//div[@aria-label='Message Body']");
    public By sendButton = By.xpath("//div[text()='Send']");
    public By crossMark = By.xpath("//*[@aria-label='Save & close']");
    public By sendRecipient = By.xpath("//input[@aria-haspopup='listbox']");


    public FillEmailPage(WebDriver driver) {
        super();
    }

    public void fillEmail(Email email) throws MalformedURLException {
        waitElementToBeClicable(messageBody);
        new Actions(DriverSingleton.getDriver())
                .clickAndHold(DriverSingleton.getDriver().findElement(messageBody))
                .sendKeys(email.getBody())
                .clickAndHold(DriverSingleton.getDriver().findElement(fieldSubject))
                .sendKeys(email.getSubject())
                .pause(Duration.ofSeconds(3))
                .click(DriverSingleton.getDriver().findElement(fieldRecipient))
                .clickAndHold(DriverSingleton.getDriver().findElement(sendRecipient))
                .sendKeys(email.getRecipient())
                .perform();
    }

    public ToDraftFolderPage close() throws MalformedURLException {
        DriverSingleton.getDriver().findElement(crossMark).click();
        return new ToDraftFolderPage(DriverSingleton.getDriver());
    }

    public By getEmailSubject() {
        return emailSubject;
    }

    public By getFieldSubject() {
        return fieldSubject;
    }
}



