package epam.com.atm.pages;

import epam.com.atm.driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class SentFolderPage extends BasePage {
    public By sendButton = By.xpath("//div[text()='Send']");
    public By checkDraftFolder = By.xpath("//*[text()[contains(.,'Saving')]]");
    public By sentFolder = By.xpath("//*[text()='Sent']");

    public SentFolderPage(WebDriver driver) {
        super();
    }

    public By getCheckDraftFolder() {
        return checkDraftFolder;
    }

    public void sentEmail() throws MalformedURLException {

        DriverSingleton.getDriver().findElement(checkDraftFolder).click();
        waitElementToBeClicable(sentFolder);
        DriverSingleton.getDriver().findElement(sentFolder).click();

    }

}
