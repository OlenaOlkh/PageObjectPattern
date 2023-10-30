package epam.com.atm.model.user;

//o implement the Abstract Factory Pattern, you should define an abstract factory interface, concrete factory classes for different types of objects, and product interfaces for the objects you want to create. Here's an example of how to implement the Abstract Factory Pattern in your code:
//
//Define a factory interface for creating different types of users:
//Create concrete factory classes that implement the factory interface to create specific types of users:
//Define a product interface for the user:
//Create concrete user classes that implement the product interface for different user types:
//In your client code, use the abstract factory to create different types of users without knowing their specific implementation:
//With this implementation, you can easily create different types of users with varying creation logic while keeping the client code unaware of the specifics of user creation. The Abstract Factory Pattern promotes flexibility and maintainability in your testing framework.

public interface UserCreator {
    User createUser();
}
