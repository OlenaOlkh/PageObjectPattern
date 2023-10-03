package epam.com.atm.pages;

import epam.com.atm.driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class DraftFolderPage extends BasePage {
    public By draftBy = By.xpath("//a[contains(@href,'drafts')]//parent::span");
    public By draftFolderBy = By.xpath("//*[text()='Drafts']");
    public By clickOnRowBy = By.xpath("//*[@class='bog']//span[text()='test subject']");
    public String subjectString = "//*[@class='bog']//span[text()='%s']";


    public DraftFolderPage(WebDriver driver) {
        super();
    }

    public CheckEmailPage openMailInDrafts(String subject) throws MalformedURLException {

        By locator = getCheckBySubject(subject);
        waitElementToBeClicable(locator);
        DriverSingleton.getDriver().findElement(locator).click();
        return new CheckEmailPage(DriverSingleton.getDriver());
    }

    public By getCheckBySubject(String subject) throws MalformedURLException {
        By locator = By.xpath(String.format(subjectString, subject));
        waitElementToBeClicable(locator);
        return locator;
    }
}
