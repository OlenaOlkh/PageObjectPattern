# Page Object Pattern UI Automation Framework

This repository contains a Maven project with automated UI tests for a web application using the Page Object Model pattern.

## Modules

- [`src/test/java`](./src/test/java) — UI tests using Java, Selenium WebDriver, and TestNG.

## Technologies Used

- Java 17
- Maven
- Selenium WebDriver
- TestNG
- Allure Reports (optional integration)
- Page Object Pattern

## How to Run Tests

### Run UI tests
```bash
mvn clean test -Dbrowser=chrome -Denvironment=stage
```

## Project Structure
```
PageObjectPattern/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── epam/com/atm/pages/       # Page Object classes
│   └── test/
│       └── java/
│           └── epam/com/atm/test/        # UI test classes
├── pom.xml                              # Maven build file
└── README.md

```

## Author

**Olena Olkhovska**  
QA Automation Engineer   
Berlin, Germany  
LinkedIn: https://www.linkedin.com/in/olena-olkhovska/

---



