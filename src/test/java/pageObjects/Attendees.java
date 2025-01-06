package pageObjects;

import config.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;


import java.time.Duration;

public class Attendees extends BasePage {

    WebDriverWait wait;

    private By registration = By.xpath("//span[@class='Text_root__M6tno' and text()='Registration']");
    private By attendees = By.xpath("//p[contains(@class, 'Text_root') and text()='Attendees']");
    private By allUsers = By.xpath("(//div[@class='flex flex-col w-full bg-c-gray-700 p-s15 pb-s25 h-[150px] justify-between'])[1]");
    private By addUser = By.xpath("//span[contains(@class, 'Text_root') and text()='Add User']");
    private By firstName = By.id("firstName");
    private By lasttName = By.id("lastName");
    private By title = By.id("title");
    private By organization = By.id("organization");
    private By phone = By.xpath("//input[@placeholder='Phone Number']");
    private By email = By.id("email");
    private By username = By.id("username");
    private By createBtn = By.xpath("//button[text()='Create']");
    private By saveBtn = By.xpath("//button[text()='Save']");
    private By addTrip = By.xpath("//span[contains(text(), 'Add Trip')][1]");
    private By packg = By.xpath("//select[@id='entity']");

    // Constructor
    public Attendees(WebDriver driver){
        super(driver); // Initialize BasePage to get the shared driver
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Initialize WebDriverWait
    }

    public void clickonRegistration() {
        WebElement regsElement = wait.until(ExpectedConditions.visibilityOfElementLocated(registration));
        regsElement.click();
    }
    public void clickonAttendees() {
        WebElement attendeesElement = wait.until(ExpectedConditions.visibilityOfElementLocated(attendees));
        attendeesElement.click();
    }

    public void clickonallUsers() {
        WebElement allUsersElement = wait.until(ExpectedConditions.visibilityOfElementLocated(allUsers));
        allUsersElement.click();
    }

    public void clickonaddUser() {
        WebElement adduserElement = wait.until(ExpectedConditions.visibilityOfElementLocated(addUser));
        adduserElement.click();
    }

    public void clickonaddUsername(String usrname) {
        WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(username));
        usernameElement.clear();
        usernameElement.sendKeys(usrname);
    }

    public void clickonCreateBtn() {
        WebElement createBElement = wait.until(ExpectedConditions.visibilityOfElementLocated(createBtn));
        createBElement.click();
    }

    public void clickonSaveBtn() {
        WebElement saveBElement = wait.until(ExpectedConditions.visibilityOfElementLocated(saveBtn));
        saveBElement.click();
    }
    public void clickonAddTrioBtn() {
        WebElement addTripBElement = wait.until(ExpectedConditions.visibilityOfElementLocated(addTrip));
        addTripBElement.click();
    }


    public void sendFandLnames(String fname, String lname) {
        WebElement fnameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));
        WebElement lnameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(lasttName));
        fnameElement.sendKeys(fname);
        lnameElement.sendKeys(lname);

    }

    public void sendTitle(String Title) {
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(title));
        titleElement.sendKeys(Title);

    }

    public void sendOrg(String org) {
        WebElement orgElement = wait.until(ExpectedConditions.visibilityOfElementLocated(organization));
        orgElement.sendKeys(org);


    }

    public void sendPhone(String Phone) {
        WebElement phoneElement = wait.until(ExpectedConditions.visibilityOfElementLocated(phone));
        phoneElement.sendKeys(Phone);


    }

    public void sendeEmail(String Email) {
        WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(email));
        emailElement.sendKeys(Email);


    }

    public void selectPackage() {
        WebElement packageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(packg));
        packageElement.click();
        Select select = new Select(packageElement);
        select.selectByIndex(1);

    }



}
