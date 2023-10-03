package epam.com.atm.model;

public class ValidFactoryUser extends FactoryUser {
    private static final String TESTDATA_USER_NAME = "testdata.user.name";
    private static final String TESTDATA_USER_PASSWORD = "testdata.user.password";


    @Override
    public String getEmail() {

        return testdataReader.getTestData(TESTDATA_USER_NAME);
    }
    @Override
    public String getPassword() {
        return testdataReader.getTestData(TESTDATA_USER_PASSWORD);
    }
}
