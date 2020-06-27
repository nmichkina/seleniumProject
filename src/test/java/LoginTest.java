import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    // wait
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    assertTrue(driver.findElement(By.id("header-details-user-fullname")).isDisplayed());
  }

  @Test
  public void unsuccessfulLoginTest() {

  }

  @AfterMethod
  public void tearDown() {
    driver.quit();
  }
}
