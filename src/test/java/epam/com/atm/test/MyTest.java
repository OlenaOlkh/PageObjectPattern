package epam.com.atm.test;

import epam.com.atm.model.user.*;
import epam.com.atm.pages.LoginPage;
import epam.com.atm.service.TestDataReaderCreator;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static epam.com.atm.test.CommonConditions.driver;

public class MyTest extends CommonConditions{
UserCreator creator;

@BeforeTest
    public void init(){
    if (creator == null){
        creator =  new ValidFactoryUserPattern(TestDataReaderCreator.getITestDataReader());
    }else{
        creator = new InvalidFactoryUserPattern (TestDataReaderCreator.getITestDataReader());
    }
 }

    @Test
    public void invcalidLogin() throws MalformedURLException {
    LoginPage login = new LoginPage(driver);
    login.loginUser((User) creator);
    }
}
