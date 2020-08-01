import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.WebDriverFactory;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.*;

public class AddCommentToJIRATicket {

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
    driver.findElement(By.id("login-form-username")).sendKeys("NataliiaMichkina");
    driver.findElement(By.id("login-form-password")).sendKeys("NataliiaMichkina");
    driver.findElement(By.id("login")).click();
    // wait
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    driver.get("https://jira.hillel.it/browse/WEBINAR-12148");
    driver.findElement(By.id("footer-comment-button")).click();
    driver.findElement(By.id("comment")).sendKeys("New comment");
    driver.findElement(By.id("issue-comment-add-submit")).click();

      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10).getSeconds());
      boolean elementIsPresent = wait.until(presenceOfElementLocated(By.xpath("//*[contains(text(), 'New comment')]"))).isDisplayed();
    assertEquals(elementIsPresent, true);

    driver.findElement(By.xpath("//span[@class='icon-default aui-icon aui-icon-small aui-iconfont-delete']")).click();
    wait = new WebDriverWait(driver,Duration.ofSeconds(5).getSeconds());

    wait.until(presenceOfElementLocated(By.id("comment-delete-submit"))).isDisplayed();
    driver.findElement(By.id("comment-delete-submit")).click();

    try {
          Thread.sleep(3000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }

    elementIsPresent = wait.until(presenceOfElementLocated(By.xpath("//div[@class='aui-message closeable aui-message-success aui-will-close']"))).isDisplayed();
    assertEquals(elementIsPresent, true);
  }

  @AfterMethod
  public void tearDown() {
    driver.quit();
  }
}

