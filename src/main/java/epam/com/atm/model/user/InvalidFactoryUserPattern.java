package epam.com.atm.model.user;


import epam.com.atm.service.ITestDataReader;

public class InvalidFactoryUserPattern implements UserCreator {
    private static final String TESTDATA_USER_NAME = "testdata.user.name";
    private final ITestDataReader testdataReader;

    public InvalidFactoryUserPattern(ITestDataReader testdataReader) {
        this.testdataReader = testdataReader;
    }

    @Override
    public User createUser() {
         String userName = testdataReader.getTestData(TESTDATA_USER_NAME);
        return new User(userName,"Password invalid");
    }
}

