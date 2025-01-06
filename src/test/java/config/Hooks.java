package config;

import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {

    public static WebDriver driver; // Static to make it accessible across step definitions

    @Before
    public void setup() {
        if (driver == null) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();  // Optionally maximize the window
    }
    }

//    @After
//    public void teardown() {
//        if (driver != null) {
//            driver.quit(); // Properly close the WebDriver after each scenario
//            driver = null;
//        }
//    }

    public static WebDriver getDriver() {
        return driver;
    }
}
