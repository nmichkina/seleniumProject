import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.WebDriverFactory;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest {

  WebDriver driver = null;

  @BeforeMethod
  public void setUp() {
    // любой Java Code
    WebDriverFactory.createInstance("Chrome");
    driver = WebDriverFactory.getDriver();
  }

  @Test
  public void successfulLoginTest() {
    driver.get("https://jira.hillel.it/secure/Dashboard.jspa");
    driver.findElement(By.id("login-form-username")).sendKeys("webinar5");
    driver.findElement(By.id("login-form-password")).sendKeys("webinar5");
    driver.findElement(By.id("login")).click();

    // Explicit Wait for element to appear
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10).getSeconds());
    boolean elementIsPresent = wait.until(presenceOfElementLocated(By.xpath("//*[contains(text(), 'Activity Stream')]"))).isDisplayed();
    assertEquals(elementIsPresent, true);

    driver.findElement(By.id("create_link")).click();
    assertEquals(wait.until(presenceOfElementLocated(By.id("issuetype-single-select"))).isDisplayed(), true);
    driver.findElement(By.id("summary")).sendKeys("Test Summary");


    // bad wait
  //    try {
  //      Thread.sleep(3000);
  //    } catch (InterruptedException e) {
  //      e.printStackTrace();
  //    }

  }

  @Test
  public void failedTest() {
    driver.get("https://jira.hillel.it/secure/Dashboard.jspa");
    assertEquals(1, 2);
  }


  @Test
  public void createIssue() {
    driver.get("https://jira.hillel.it/secure/Dashboard.jspa");
    driver.findElement(By.id("login-form-username")).sendKeys("webinar5");
    driver.findElement(By.id("login-form-password")).sendKeys("webinar5");
    driver.findElement(By.id("login")).click();

    // Explicit Wait for element to appear
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30).getSeconds());
    boolean elementIsPresent = wait.until(presenceOfElementLocated(By.id("create_link"))).isEnabled();
    assertEquals(elementIsPresent, true);

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    driver.findElement(By.id("create_link")).click();


    wait.until(presenceOfElementLocated(By.id("project-field"))).isDisplayed();
    driver.findElement(By.id("project-field")).clear();
    driver.findElement(By.id("project-field")).sendKeys("Webinar (WEBINAR)");
    driver.findElement(By.id("project-field")).sendKeys(Keys.TAB);

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    driver.findElement(By.id("issuetype-field")).clear();
    driver.findElement(By.id("issuetype-field")).sendKeys("task");
    driver.findElement(By.id("issuetype-field")).sendKeys(Keys.TAB);

    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    driver.findElement(By.id("summary")).sendKeys("Some summary1");
    driver.findElement(By.id("reporter-field")).clear();
    driver.findElement(By.id("reporter-field")).sendKeys("webinar5");
    driver.findElement(By.id("reporter-field")).sendKeys(Keys.TAB);
    driver.findElement(By.id("create-issue-submit")).click();


    // Explicit Wait for element to appear
    //wait = new WebDriverWait(driver, Duration.ofSeconds(10).getSeconds());
    boolean popUpIsPresent = wait.until(presenceOfElementLocated(By.className("aui-message-success"))).isDisplayed();
    assertEquals(popUpIsPresent, true);

    boolean titleIsPresent = wait.until(presenceOfElementLocated(By.xpath("//*[contains(text(), 'WEBINAR')]"))).isDisplayed();
    assertEquals(titleIsPresent,true);

    //aui-flag-container
  }

  @AfterMethod

  public void tearDown() { driver.quit();
  }
}
