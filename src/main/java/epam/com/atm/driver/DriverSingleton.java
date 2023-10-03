package epam.com.atm.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverSingleton {
    private static WebDriver driver;
    public static WebDriver getDriver() throws MalformedURLException {
        System.setProperty("environment", "stage");
        DesiredCapabilities caps = new DesiredCapabilities();
        // caps.setBrowserName("chrome");
        if (null == driver) {
            switch (System.getProperty("browser"))
                /*  switch (System.getProperty("browser"))*/ {
                case "chrome":
                    // WebDriverManager.chromedriver().setup();
                    //   WebDriverManager.chromedriver().clearDriverCache().setup();
                    ChromeOptions options = new ChromeOptions();
                    driver = new ChromeDriver(options);
                    break;
                case "chromeRemote":
                    ChromeOptions optionsRemote = new ChromeOptions();
                    optionsRemote.addArguments("--incognito");
                    caps.setBrowserName("chrome");
                    caps.setPlatform(Platform.WIN10);
                    caps.setCapability(ChromeOptions.CAPABILITY, optionsRemote);
                    driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), caps);
                    break;
                case "Edge":
                    WebDriverManager.edgedriver().setup();
                    caps.setBrowserName("edge");
                    driver = new EdgeDriver();
                    break;
                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
            }
        }

        driver.manage().window().maximize();
        return driver;
    }
    /*public static void closeDriver() {
        driver.quit();
        driver = null;
    }*/
}
