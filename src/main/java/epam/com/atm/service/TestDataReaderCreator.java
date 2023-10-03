package epam.com.atm.service;

public class TestDataReaderCreator {
    public static ITestDataReader getITestDataReader() {
        return new TestDataReader();
    }
}
