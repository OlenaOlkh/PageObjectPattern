package epam.com.atm.test;

import epam.com.atm.model.FactoryUser;
import epam.com.atm.model.InvalidFactoryUser;
import epam.com.atm.model.ValidFactoryUser;
import epam.com.atm.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import java.net.MalformedURLException;

@Listeners({TestListener.class})
public class CommonConditions {
    protected static WebDriver driver;

    @BeforeTest
    public void initTest() throws MalformedURLException {
        System.out.println("SetUp");
        driver = getDriver();
    }

    /* @AfterTest
     public void afterTest() {
         System.out.println("TearDown");
         DriverSingleton.closeDriver();
     }*/
    public FactoryUser getFactoryUser(boolean isValid) {

        if (isValid) {
            return new ValidFactoryUser();
        }
        return new InvalidFactoryUser();
    }

    public static WebDriver getDriver() throws MalformedURLException {
        return driver;
    }

    /*public void setDriver(WebDriver driver) {
        this.driver = driver;
    }*/
}
