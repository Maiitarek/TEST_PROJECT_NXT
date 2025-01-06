package pageObjects;
import config.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;



public class verifyAllURLs extends BasePage {

    private WebDriverWait wait;
    private final  By errorIndicator = By.xpath("//*[contains(text(), 'Error')]");
    private By event = By.xpath("//tbody/tr[1]/td[2]");
    private static By contentURL = By.xpath("//span[@class='Text_root__M6tno' and text()='Content']");
    private static By regsURL = By.xpath("//span[@class='Text_root__M6tno' and text()='Registration']");;
    private static By planningURL = By.xpath("//span[@class='Text_root__M6tno' and text()='Planning']");;
    private static By reportsURL = By.xpath("//span[@class='Text_root__M6tno' and text()='Reports']");
    private static By exploreURL = By.xpath("//p[contains(@class, 'Text_root__M6tno') and text()='Explore']");
    private static By itineraryURL = By.xpath("//p[contains(@class, 'Text_root__M6tno') and text()='Itinerary']");
    private static By sendupdatesURL = By.xpath("//p[contains(@class, 'Text_root__M6tno') and text()='Send Updates']");
    private static By packagesURL = By.xpath("//p[contains(@class, 'Text_root__M6tno') and text()='Packages']");
    private static By sessionssURL = By.xpath("//p[contains(@class, 'Text_root__M6tno') and text()='Sessions']");
    private static By attendeesURL = By.xpath("//p[contains(@class, 'Text_root__M6tno') and text()='Attendees']");
    private static By applicationURL = By.xpath("//p[contains(@class, 'Text_root__M6tno') and text()='Applications']");
    private static By usersReportsURL = By.xpath("//p[contains(@class, 'Text_root__M6tno') and text()='Users Reports']");



    public verifyAllURLs(WebDriver driver) {
        super(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    public void clickOnEvent(){

        WebElement eventElement = wait.until(ExpectedConditions.elementToBeClickable(event));
        eventElement.click();

    }


    public static By getMatchingLocator(String currentURL) {
        switch (currentURL.toLowerCase()) {
            case "content":
                return contentURL;
            case "registration":
                return regsURL;
            case "planning":
                return planningURL;
            case "reports":
                return reportsURL;
            case "explore":
                return exploreURL;
            case "itinerary":
                return itineraryURL;
            case "sendupdates":
                return sendupdatesURL;
            case "packages":
                return packagesURL;
            case "sessions":
                return sessionssURL;
            case "attendees":
                return attendeesURL;
            case "applications":
                return applicationURL;
            case "usersreports":
                return usersReportsURL;
            default:
                return null;
        }
    }
}



