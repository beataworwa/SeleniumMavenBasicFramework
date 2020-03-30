package factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverByManagerFactory implements DriverFactory {

    @Override
    public WebDriver getWebDriver() {
        WebDriverManager.chromedriver().version("79.0.3945.36").setup();
        return new ChromeDriver();
    }
}
