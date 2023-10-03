package epam.com.atm.model;


import epam.com.atm.service.ITestDataReader;
import epam.com.atm.service.TestDataReaderCreator;


public abstract class FactoryUser {
    public abstract String getEmail();

    public abstract String getPassword();

    public ITestDataReader testdataReader = TestDataReaderCreator.getITestDataReader();

    public User createUser() {
        return new User(getEmail(), getPassword());
    }

    ;
}
