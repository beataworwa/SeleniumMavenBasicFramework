package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

class FirefoxDriverByManagerFactory implements DriverFactory {
    @Override
    public WebDriver getWebDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }


}
