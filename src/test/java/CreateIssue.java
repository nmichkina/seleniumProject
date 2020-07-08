import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.WebDriverFactory;

import java.time.Duration;
import static org.testng.Assert.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertTrue;

public class CreateIssue {

    WebDriver driver = null;

    @BeforeMethod
    public void setUp() {
        WebDriverFactory.createInstance("Chrome");
        driver = WebDriverFactory.getDriver();
        driver.get("https://jira.hillel.it/secure/Dashboard.jspa");
        driver.findElement(By.id("login-form-username")).sendKeys("webinar5");
        driver.findElement(By.id("login-form-password")).sendKeys("webinar5");
        driver.findElement(By.id("login")).click();
    }

    @Test
    public void createIssue() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15).getSeconds());
        boolean createButtonPresent = wait.until(presenceOfElementLocated(By.id("create_link"))).isDisplayed();
        assertEquals(createButtonPresent, true);
        driver.findElement(By.id("create_link")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("create_link")).click();

        boolean createModalPresent = wait.until(presenceOfElementLocated(By.id("project-field"))).isDisplayed();
        assertEquals(createModalPresent, true);
        driver.findElement(By.id("project-field")).clear();
        driver.findElement(By.id("project-field")).sendKeys("Webinar (WEBINAR)");
        driver.findElement(By.id("project-field")).sendKeys(Keys.TAB);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("issuetype-field")).clear();
        driver.findElement(By.id("issuetype-field")).sendKeys("Task");
        driver.findElement(By.id("issuetype-field")).sendKeys(Keys.TAB);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("summary")).sendKeys("Create Jira task-ticket");
        driver.findElement(By.id("reporter-field")).clear();
        driver.findElement(By.id("reporter-field")).sendKeys("webinar5");
        driver.findElement(By.id("create-issue-submit")).click();
        boolean createdPopUp = wait.until(presenceOfElementLocated(By.cssSelector("div[class='aui-message closeable aui-message-success aui-will-close'] a[class='issue-created-key issue-link']"))).isDisplayed();
        assertEquals(createdPopUp, true); // проверка что появился папап
        WebElement popUP = driver.findElement(By.cssSelector("div[class='aui-message closeable aui-message-success aui-will-close'] a[class='issue-created-key issue-link']"));
        String ticketName = popUP.getAttribute("data-issue-key"); //получение значения атрибута
        assertTrue(ticketName.contains("WEBINAR")); //проверка что он содержит Webinar


    }

    @AfterMethod
    public void tearDown() {
        WebDriverFactory.getDriver().quit();
    }

}
