package epam.com.atm.service;

import java.util.ResourceBundle;

public class TestDataReader implements ITestDataReader {
    private static final ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("environment"));
    public String getTestData(String key) {
        return resourceBundle.getString(key);
    }
}
