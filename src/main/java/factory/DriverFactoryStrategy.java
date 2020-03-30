package factory;

import config.SupportedBrowser;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class DriverFactoryStrategy {

    private static final String BROWSER = "CHROME";
    private static final int PAGE_LOAD_TIMEOUT_SECONDS = 240;
    private static final Map<SupportedBrowser, DriverFactory> driverStartegyForBrowser = new HashMap<>();

    static {
        driverStartegyForBrowser.put(SupportedBrowser.CHROME, new ChromeDriverFactory());
        //driverStartegyForBrowser.put(SupportedBrowser.CHROME, new ChromeDriverByManagerFactory());
        driverStartegyForBrowser.put(SupportedBrowser.FIREFOX, new FirefoxDriverByManagerFactory());
    }


    public static synchronized WebDriver getWebdriver() {
        WebDriver driver = driverStartegyForBrowser.get(SupportedBrowser.valueOf(BROWSER)).getWebDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT_SECONDS, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}
