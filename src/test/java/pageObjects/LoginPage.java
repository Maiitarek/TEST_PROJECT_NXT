package pageObjects;

import config.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage {

    WebDriverWait wait;

    // Locator for the fields
    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By skipButton = By.xpath("//button[contains(text(), 'Skip')]");
    private By Dashboard = By.cssSelector("h2.Heading_h2__plkLc.font-bold");



    // Constructor to initialize WebDriver and WebDriverWait
    public LoginPage(WebDriver driver) {
        super(driver); // Initialize BasePage to get the shared driver
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize WebDriverWait

    }

    // Method to enter the username
    public void enterUsername(String username) {
        WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        usernameElement.sendKeys(username);
    }

    // Method to enter the password
    public void enterPassword(String password) {
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passwordElement.sendKeys(password);
    }

    public void clickLogin() {
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginBtn.click();
    }

    public void clickOnSkipButton(){

        WebElement skipBTN = wait.until(ExpectedConditions.elementToBeClickable(skipButton));
        skipBTN.click();
    }

    public void dashboadDisplayed(){

        WebElement dashboard = wait.until(ExpectedConditions.elementToBeClickable(Dashboard));
        Assert.assertTrue("Dashboard is not displayed", dashboard.isDisplayed());
    }

}
