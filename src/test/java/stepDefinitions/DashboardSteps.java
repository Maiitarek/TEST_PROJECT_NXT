package stepDefinitions;
import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.LoginPage;
import pageObjects.verifyAllURLs;
import pageObjects.Attendees;
import java.time.Duration;
import java.util.List;

import static config.Hooks.driver;


public class DashboardSteps {
    private LoginPage loginPage;
    private List<String> urls;
    private verifyAllURLs verifyURLs;
    private Attendees attendee;
    private String username = "random1295099";
    boolean errorsFound = false;


    // Constructor where we initialize the WebDriver and Page Object
    public DashboardSteps() {
        super();
    }

    @Given("I open the Admin login page")
    public void iOpenTheAdminLoginPage() {
        loginPage = new LoginPage(driver);  // Pass driver from Hooks
        loginPage.navigateTo("https://qa-test-frontend-ce07bae316f3.herokuapp.com/");
    }

    @When("I login with username {string} and password {string}")
    public void iLoginWithUsernameAndPassword(String username, String password) {

        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        loginPage.clickOnSkipButton();
    }

    @Then("I should see the dashboard")
    public void iShouldSeeTheDashboard() {

        loginPage.dashboadDisplayed();
        System.out.println("Dashboard is displayed!");

    }

    @And("I click on event")
    public void iClickOnEvent() {
        verifyURLs = new verifyAllURLs(driver); // pass the driver
        verifyURLs.clickOnEvent();

    }


    @And("I click on any {string}")
    public void iClickOnAnyEvent(String currentURL) {
        verifyURLs = new verifyAllURLs(driver);

        try {
            // Get the matching locator for the provided URL name
            By matchedLocator = verifyAllURLs.getMatchingLocator(currentURL);

            if (matchedLocator == null) {
                System.out.println("No matching locator found for the URL: " + currentURL);
                return;
            }

            // Locate the element using the matched locator
            WebElement element = driver.findElement(matchedLocator);

            if (element.isDisplayed()) {
                // Click the element
                element.click();
                System.out.println("Navigated to URL: " + currentURL);

                // Wait for the page to load (can adjust timeout as needed)
                new WebDriverWait(driver, Duration.ofSeconds(10)).until(
                        webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete")
                );

                // Check for errors or validation on the new page
                checkForErrorsOnPage(currentURL);
            } else {
                System.out.println("Element not visible for URL: " + currentURL);
            }
        } catch (NoSuchElementException e) {
            System.out.println("Error: Element not found for URL: " + currentURL);
        } catch (Exception e) {
            System.out.println("Unexpected error occurred for URL: " + currentURL);
            e.printStackTrace();
        }

    }

    private void checkForErrorsOnPage(String currentURL) {
        try {
            // Example check: Look for a common error message element
            List<WebElement> errorElements = driver.findElements(By.xpath("//*[contains(text(), 'Error')]"));

            if (!errorElements.isEmpty()) {
                System.out.println("Error detected on the page for URL: " + currentURL);
            } else {
                System.out.println("No errors detected on the page for URL: " + currentURL);
            }

            // Additional validations (e.g., correct title, specific elements loaded)
            String pageTitle = driver.getTitle();
            System.out.println("Page title for " + currentURL + ": " + pageTitle);
        } catch (Exception e) {
            System.out.println("Error while checking for errors on the page for URL: " + currentURL);
            e.printStackTrace();
        }
    }

    @Given("I am on the Attendees page and I add new User")
    public void iAmOnTheAttendeesPageAndIAddNewUser() throws InterruptedException {
        attendee = new Attendees(driver);
        attendee.clickonRegistration();
        attendee.clickonAttendees();
        attendee.clickonallUsers();
        attendee.clickonaddUser();
        attendee.sendFandLnames("Mai","Tarek");
        attendee.sendTitle("Senior");
        attendee.sendOrg("NXT");
        attendee.sendPhone("556100334");
        attendee.sendeEmail("maiitrek08@gmail.com");
        attendee.clickonaddUsername(username);
        attendee.clickonCreateBtn();
        attendee.clickonSaveBtn();
        attendee.clickonSaveBtn();
        attendee.clickonRegistration();
        attendee.clickonAttendees();
        attendee.clickonallUsers();
        Thread.sleep(3000);


    }

    @When("I add user to a trip")
    public void iUserToATrip() throws InterruptedException {

        Thread.sleep(3000);
        attendee.clickonAddTrioBtn();
        Thread.sleep(3000);
        attendee.selectPackage();
        attendee.clickonCreateBtn();


    }
}
