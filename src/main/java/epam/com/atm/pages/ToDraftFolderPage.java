package epam.com.atm.pages;

import epam.com.atm.driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class ToDraftFolderPage extends BasePage {
    public By draftFolder = By.xpath("//*[text()='Drafts']");
    public By subjectEmail = By.xpath("//*[@class='bog']//span[text()='Message script']");

    public ToDraftFolderPage(WebDriver driver) {
        super();
    }

    public DraftFolderPage openDraftFolder() throws MalformedURLException {

        DriverSingleton.getDriver().findElement(draftFolder).click();
        waitElementToBeClicable(subjectEmail);
        DriverSingleton.getDriver().findElement(subjectEmail).click();

        return new DraftFolderPage(DriverSingleton.getDriver());
    }
}
