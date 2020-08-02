import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.WebDriverFactory;
import static org.testng.Assert.assertTrue;

public class ViewJIRATicket {

  WebDriver driver = null;
  HomePage homePage = null;
  LoginPage loginPage = null;

  @BeforeMethod
  public void setUp() {
    // любой Java Code
    WebDriverFactory.createInstance("Chrome");
    driver = WebDriverFactory.getDriver();
    loginPage = new LoginPage(driver);
    homePage = new HomePage(driver);
  }

  @Test
  public void successfulLoginTest() {
    homePage.navigateTo();
    loginPage.enterUserName("NataliiaMichkina");
    loginPage.enterPassword("NataliiaMichkina");
    loginPage.clickLogin();

    homePage.jiraTicketPath();
    assertTrue(driver.findElement(By.id("issuedetails")).isDisplayed());
    assertTrue(driver.getCurrentUrl().contains("9060"));

  }

  @AfterMethod
  public void tearDown() {
    driver.quit();
  }
}

//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30).getSeconds());
//    boolean elementIsPresent = wait.until(elementToBeClickable(By.id("create_link"))).isEnabled();