package tests;

import factory.DriverFactoryStrategy;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstTest {

    WebDriver webDriver;

    @Before
    public void setupDriver() {
        webDriver = DriverFactoryStrategy.getWebdriver();
    }

    @Test
    public void openMainPage() {
        webDriver.get("https://allegro.pl/");
        waitForLoad(webDriver);
    }

    void waitForLoad(WebDriver driver) {
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
    }

    @After
    public void cleanUp() {
        if (webDriver != null) {
            webDriver.close();
            webDriver.quit();
        }

    }
}
