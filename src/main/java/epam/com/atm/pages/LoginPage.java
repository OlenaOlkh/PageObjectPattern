package epam.com.atm.pages;

import epam.com.atm.driver.DriverSingleton;
import epam.com.atm.model.user.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;

// mvn clean test -Dbrowser=chrome -Denvironment=stage
public class LoginPage extends BasePage {
    public By inputUserName = By.xpath("//input[@id='identifierId']");
    public By inputPassword = By.xpath("//input[@type='password']");
    public By clickButton = By.xpath("//span[text()='Next']//parent::button");


    public LoginPage(WebDriver driver) {
        super();
    }

    private final Logger logger = (Logger) LogManager.getRootLogger();

    public ComposePage loginUser(User user) throws MalformedURLException {


        new Actions(DriverSingleton.getDriver())
                .clickAndHold(DriverSingleton.getDriver().findElement(inputUserName))
                .sendKeys(user.getUsername())
                .click(DriverSingleton.getDriver().findElement(clickButton))
                .perform();
        new WebDriverWait(DriverSingleton.getDriver(), Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(inputPassword));


        new Actions(DriverSingleton.getDriver())
                .clickAndHold(DriverSingleton.getDriver().findElement(inputPassword))
                .sendKeys(user.getPassword())
                .click(DriverSingleton.getDriver().findElement(clickButton))
                .perform();

        logger.info("User " + user.getUsername() + " logged in");
        return new ComposePage(DriverSingleton.getDriver());
    }
}
