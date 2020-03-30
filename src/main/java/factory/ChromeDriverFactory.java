package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

class ChromeDriverFactory implements DriverFactory {
    private static final String DRIVER_PATH = "/driver/chromedriver.exe";

    @Override
    public WebDriver getWebDriver() {
        URL driverUrl = ChromeDriverFactory.class.getResource(DRIVER_PATH);
        File file = null;
        try {
            file = new File(driverUrl.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        WebDriver webDriver = new ChromeDriver();
        return webDriver;
    }


}