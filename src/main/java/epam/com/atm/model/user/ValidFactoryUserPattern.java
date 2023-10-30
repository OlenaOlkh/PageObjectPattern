package epam.com.atm.model.user;


import epam.com.atm.service.ITestDataReader;

public class ValidFactoryUserPattern implements UserCreator {
    private static final String TESTDATA_USER_NAME = "testdata.user.name";
    private static final String TESTDATA_USER_PASSWORD = "testdata.user.password";

    private final ITestDataReader testdataReader;

    public ValidFactoryUserPattern(ITestDataReader testdataReader) {
        this.testdataReader = testdataReader;
    }

    @Override
    public User createUser() {
        String userName = testdataReader.getTestData(TESTDATA_USER_NAME);
        String userPassword = testdataReader.getTestData(TESTDATA_USER_PASSWORD);
        return new User(userName,userPassword);
    }
}
