import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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
    driver.findElement(By.id("login-form-username")).sendKeys("Artur Piluck");
    driver.findElement(By.id("login-form-password")).sendKeys("12345qx");
    driver.findElement(By.id("login")).click();

    // Explicit Wait for element to appear
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1).getSeconds());
    assertEquals(wait.until(presenceOfElementLocated(By.xpath("//*[contains(text(), 'Activity Stream')]"))).isDisplayed(), true);

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

  @AfterMethod
  public void tearDown() {
    driver.quit();
  }
}
