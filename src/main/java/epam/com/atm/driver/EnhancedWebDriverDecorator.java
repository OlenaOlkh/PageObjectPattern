package epam.com.atm.driver;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Interactive;
import org.openqa.selenium.interactions.Sequence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.List;
import java.util.Set;


public class EnhancedWebDriverDecorator implements WebDriver, TakesScreenshot, JavascriptExecutor, HasCapabilities, Interactive {
    private final WebDriver driver;
    private final Logger logger = LoggerFactory.getLogger(EnhancedWebDriverDecorator.class);

    //Create a concrete decorator class that implements the EnhancedWebDriver interface and delegates to the original WebDriver instance
    public EnhancedWebDriverDecorator(WebDriver driver) {
        this.driver = driver;
    }


    @Override
    public void get(String url) {
        logger.info("Navigating to URL: " + url);
        driver.get(url);
        System.out.println("%%%%%%%%%% " + url);
    }

    @Override
    public String getCurrentUrl() {
        String currentUrl = driver.getCurrentUrl();
        logger.info("Current URL is: " + currentUrl);
        return currentUrl;
    }

    @Override
    public String getTitle() {
        String title = driver.getTitle();
        logger.info("Page title is: " + title);
        return title;
    }
    @Override
    public List<WebElement> findElements(By by) {

        return driver.findElements(by);
    }

    @Override
    public WebElement findElement(By by) {
        return driver.findElement(by);
    }

    @Override
    public String getPageSource() {
        return driver.getPageSource();
    }

    @Override
    public void close() {
        driver.close();
    }

    @Override
    public void quit() {
        driver.quit();
    }

    @Override
    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    @Override
    public String getWindowHandle() {
        return driver.getWindowHandle();
    }

    @Override
    public WebDriver.TargetLocator switchTo() {
        return driver.switchTo();
    }

    @Override
    public WebDriver.Navigation navigate() {
        return driver.navigate();
    }

    @Override
    public WebDriver.Options manage() {
        return driver.manage();
    }

    @Override
    public <X> X getScreenshotAs(OutputType<X> target) throws WebDriverException {
        return ((TakesScreenshot) driver).getScreenshotAs(target);
    }

    @Override
    public Object executeScript(String script, Object... args) {
        return ((JavascriptExecutor) driver).executeScript(script, args);
    }

    @Override
    public Object executeAsyncScript(String script, Object... args) {
        return ((JavascriptExecutor) driver).executeAsyncScript(script, args);
    }

    @Override
    public Capabilities getCapabilities() {

        return((HasCapabilities) driver).getCapabilities();
    }

    @Override
    public void perform(Collection<Sequence> actions) {
        ((Interactive) driver).perform(actions);
    }

    @Override
    public void resetInputState() {
        ((Interactive) driver).resetInputState();

    }
}
