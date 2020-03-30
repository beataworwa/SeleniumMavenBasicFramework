This is basic configuration for project with Java 8,Mave, Selenium.

There are two version of test plugins in pom.xml:
*surfire - to run test via mvn test
*failsafe - to run test via mvn verify

I strongly recommend using this webdriver manager:
https://github.com/bonigarcia/webdrivermanager

Examples of using it you can find in classes:
ChromeDriveryByManagerFactory, FirefoxDriverByManagerFactory

If you really need use plain webdriver example ot that you can find in:
ChromeDriverFactory




