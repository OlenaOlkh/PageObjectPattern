package epam.com.atm.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverSingletonDecorator {
    private static EnhancedWebDriver driver = new EnhancedWebDriverDecorator(new ChromeDriver());
    public static EnhancedWebDriver getDriver() throws MalformedURLException {
        System.setProperty("environment", "stage");
        DesiredCapabilities caps = new DesiredCapabilities();

        if (null == driver) {
            switch ("browser") {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    driver = new EnhancedWebDriverDecorator(new ChromeDriver(options));
                    break;
                case "chromeRemote":
                    ChromeOptions optionsRemote = new ChromeOptions();
                    optionsRemote.addArguments("--incognito");
                    caps.setBrowserName("chrome");
                    caps.setPlatform(Platform.WIN10);
                    caps.setCapability(ChromeOptions.CAPABILITY, optionsRemote);
                    driver = new EnhancedWebDriverDecorator(new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps));
                    break;
                case "Edge":
                    WebDriverManager.edgedriver().setup();
                    caps.setBrowserName("edge");
                    driver = new EnhancedWebDriverDecorator(new EdgeDriver());
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new EnhancedWebDriverDecorator(new ChromeDriver());
                    break;
            }
        }

        driver.manage().window().maximize();
        return driver;
    }
}
