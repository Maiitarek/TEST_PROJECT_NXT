package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;

    }

    public void navigateTo(String url) {

            driver.navigate().to(url);
            System.out.println("Navigated to: " + url);
    }


    public String getPageTitle() {
        return driver.getTitle();
    }
}
