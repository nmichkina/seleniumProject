import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.WebDriverFactory;

import static org.testng.Assert.assertTrue;

public class ViewJIRATicket {

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
    // wait
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    driver.get("https://jira.hillel.it/browse/WEBINAR-9060");
    assertTrue(driver.findElement(By.id("issuedetails")).isDisplayed());
    assertTrue(driver.getCurrentUrl().contains("9060"));

  }

  @Test
  public void unsuccessfulLoginTest() {

  }

  @AfterMethod
  public void tearDown() {
    driver.quit();
  }
}

//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30).getSeconds());
//    boolean elementIsPresent = wait.until(elementToBeClickable(By.id("create_link"))).isEnabled();