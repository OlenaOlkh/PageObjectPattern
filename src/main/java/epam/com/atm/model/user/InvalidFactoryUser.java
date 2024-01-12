package epam.com.atm.model.user;

import epam.com.atm.model.user.FactoryUser;

public class InvalidFactoryUser extends FactoryUser {
    private static final String TESTDATA_USER_NAME = "testdata.user.name";

    @Override
    public String getEmail() {
        return testdataReader.getTestData(TESTDATA_USER_NAME);
    }
    @Override
    public String getPassword() {
        return "Password invalid";
    }

}
