package epam.com.atm.model;

public class InvalidFactoryUserPattern extends FactoryUser {
    private static final String TESTDATA_USER_NAME = "testdata.user.name";

    @Override
    public String getEmail() {
        return testdataReader.getTestData(TESTDATA_USER_NAME);
    }
    @Override
    public String getPassword() {
        return "Password invalid";
    }
    //By using this pattern, you can create different types of users with varying creation logic while keeping the client code unaware of the specifics of user creation. It promotes flexibility and maintainability in your testing framework.
    FactoryUser invalidUserFactory = new InvalidFactoryUser();
    User invalidUser = invalidUserFactory.createUser();
}
