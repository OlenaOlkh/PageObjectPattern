package epam.com.atm.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;

public class DriverSingleton {
    private static final Logger logger = LoggerFactory.getLogger(DriverSingleton.class);

    private static WebDriver driver;
    public static WebDriver getDriver() throws MalformedURLException {
        System.setProperty("environment", "stage");
        DesiredCapabilities caps = new DesiredCapabilities();
        // caps.setBrowserName("chrome");
        if (null == driver) {
            switch (System.getProperty("browser"))
                 {
                case "chrome":
                    // WebDriverManager.chromedriver().setup();
                    //   WebDriverManager.chromedriver().clearDriverCache().setup();
                    ChromeOptions options = new ChromeOptions();
                   // driver = new ChromeDriver(options);
                    System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$");
                    logger.info("@@@@@@@@@@@@@@@@@@@@@@@@");
                    driver = new EnhancedWebDriverDecorator(new ChromeDriver(options));
                    {
                    };
                    break;
                case "chromeRemote":
                    ChromeOptions optionsRemote = new ChromeOptions();
                    optionsRemote.addArguments("--incognito");
                    caps.setBrowserName("chrome");
                    caps.setPlatform(Platform.WIN10);
                    caps.setCapability(ChromeOptions.CAPABILITY, optionsRemote);
                 //   driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);

                    break;
                case "Edge":
                    WebDriverManager.edgedriver().setup();
                    caps.setBrowserName("edge");
                    driver = new EdgeDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                   // driver = new ChromeDriver();
                    driver = new EnhancedWebDriverDecorator(new ChromeDriver())
                    {
                    };
                    break;
            }
        }

        driver.manage().window().maximize();
        return driver;
    }
    public static void closeDriver() {
        driver.quit();
        driver = null;
    }
}

//Чтобы создать паттерн Декоратор с логированием в вашем коде, следуйте этим шагам:
//
//Создайте интерфейс для вашего базового компонента (в данном случае WebDriver):
//Создайте класс, который реализует этот интерфейс. Этот класс будет представлять базовый компонент:
//Создайте класс-декоратор, который также реализует интерфейс EnhancedWebDriver. Этот класс будет добавлять логирование к функциональности базового компонента:
//В вашем DriverSingleton, создайте драйвер, обернутый в декоратор для добавления логирования:
//Теперь ваш DriverSingleton будет возвращать EnhancedWebDriver, который включает логирование через паттерн Декоратор. Вы можете добавить другие декораторы или настраивать логирование по мере необходимости.
