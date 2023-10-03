package epam.com.atm.test;

import epam.com.atm.driver.DriverSingleton;
import epam.com.atm.pages.ComposePage;
import epam.com.atm.pages.LoginPage;
import epam.com.atm.util.LoginUtil;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class LoginTest extends CommonConditions {

    private final static String body = "Test message";

    private final static String subject = "Message script";

    private final static String recipient = "olenaotest@gmail.com";
    private final static String url = "https://accounts.google.com/v3/signin/identifier?dsh=S-2013150678%3A1681917281681000&continue=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&emr=1&followup=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&ifkv=AQMjQ7Q-PoFk6chKa8ZqDP26RRfBQcV6uu7-BXwoq6EjmrXJANCLsifjG2KvylpNlLvrLSEW0CNgOw&osid=1&passive=1209600&service=mail&flowName=GlifWebSignIn&flowEntry=ServiceLogin";

    @Test
    public void login() throws MalformedURLException {
        JavascriptExecutor js = (JavascriptExecutor) DriverSingleton.getDriver();
        js.executeScript("window.location =\"" + url + "\"");
        LoginPage loginPage = new LoginPage(DriverSingleton.getDriver());
        ComposePage composePage = loginPage.loginUser(getFactoryUser(true).createUser());
        Assert.assertTrue(LoginUtil.isUserLogin(composePage));

    }
    public static WebDriver getDriver() throws MalformedURLException {
        return DriverSingleton.getDriver();
    }
}
