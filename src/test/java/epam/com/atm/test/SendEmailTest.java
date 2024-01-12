package epam.com.atm.test;


import epam.com.atm.driver.DriverSingleton;
import epam.com.atm.model.Email;
import epam.com.atm.pages.*;
import epam.com.atm.util.LoginUtil;
import epam.com.atm.waiters.Waiter;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;

import java.net.MalformedURLException;

import static org.testng.Assert.assertEquals;

public class SendEmailTest extends CommonConditions {
    private static final String BODY = "Message Body";
    private static final String SUBJECT = "Message script";
    private static final String RECIPIENT = "olenaotest@gmail.com";
    private static final String url = "https://accounts.google.com/v3/signin/identifier?dsh=S-2013150678%3A1681917281681000&continue=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&emr=1&followup=https%3A%2F%2Fmail.google.com%2Fmail%2Fu%2F0%2F&ifkv=AQMjQ7Q-PoFk6chKa8ZqDP26RRfBQcV6uu7-BXwoq6EjmrXJANCLsifjG2KvylpNlLvrLSEW0CNgOw&osid=1&passive=1209600&service=mail&flowName=GlifWebSignIn&flowEntry=ServiceLogin";


    @Test
    public void testAllFlow() throws MalformedURLException {
       //   setUp();
        Email email = new Email(RECIPIENT, SUBJECT, BODY);
        //   driver.get(url);
        JavascriptExecutor js = (JavascriptExecutor) DriverSingleton.getDriver();
        //DriverSingleton.getDriver().get(URL);
        js.executeScript("window.location =\"" + url + "\"");
        LoginPage loginPage = new LoginPage(DriverSingleton.getDriver());
        ComposePage composePage = loginPage.loginUser(getFactoryUser(true).createUser());
        Assert.assertTrue(LoginUtil.isUserLogin(composePage));
        FillEmailPage fillEmailPage = composePage.compose();
        fillEmailPage.fillEmail(email);
        ToDraftFolderPage goToDraftFolderPage = fillEmailPage.close();
        DraftFolderPage draftFolderPage = goToDraftFolderPage.openDraftFolder();
        CheckEmailPage checkEmailPage = draftFolderPage.openMailInDrafts(SUBJECT);
        Waiter.waitExplicit();
        // assertEquals(SUBJECT, fillEmailPage.getAttributeBy(fillEmailPage.getEmailSubject(), "value"));
        // assertEquals( "Message Body",fillEmailPage.getAttributeBy(fillEmailPage.getFieldSubject(),"value"));
        assertEquals(RECIPIENT, checkEmailPage.getAttributeBy(checkEmailPage.getEmail(RECIPIENT), "email"));
        SentFolderPage sentFolderPage = checkEmailPage.send();
        Assert.assertTrue(sentFolderPage.ifElementIsDisplayed(sentFolderPage.getCheckDraftFolder())); // check if the folder "draft" is empty
        sentFolderPage.sentEmail();
        /*LogOutPage logOutPage = new LogOutPage(driver);
        Assert.assertTrue(sentFolderPage.ifElementIsDisplayed(draftFolderPage.getCheckBySubject(SUBJECT))); // check if email in the "Sent" folder using locator of subject
        logOutPage.logOut();*/
    }
}


