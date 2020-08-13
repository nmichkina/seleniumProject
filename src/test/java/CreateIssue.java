import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.TicketPage;
import utils.WebDriverFactory;
import java.time.Duration;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class CreateIssue {

  WebDriver driver = null;
  LoginPage loginPage = null;
  HomePage homePage = null;
  TicketPage ticketPage = null;

  @BeforeMethod
  public void setUp() {
    // любой Java Code
    WebDriverFactory.createInstance("Chrome");
    driver = WebDriverFactory.getDriver();
    loginPage = new LoginPage(driver);
    homePage = new HomePage(driver);
    ticketPage = new TicketPage(driver);
  }


  @Test
  public void createIssue() {
    homePage.navigateTo();
    loginPage.enterUserName("NataliiaMichkina");
    loginPage.enterPassword("NataliiaMichkina");
    loginPage.clickLogin();
    assertTrue(homePage.userIconIsPresent());

    ticketPage.createButtonClick();

    ticketPage.enterProjectName("Webinar (WEBINAR)");

    ticketPage.enterIssueType("task");

    ticketPage.enterSummary("Some summary");
    ticketPage.enterReporter("NataliiaMichkina");
    ticketPage.clickCreateIssueSubmitButton();

    ticketPage.createIsueSuccessMessagePresent();
    assertTrue(ticketPage.createIsueSuccessMessagePresent());
    ticketPage.popupTitleIsPresent();
    assertTrue(ticketPage.popupTitleIsPresent());
  }

  @AfterMethod

  public void tearDown() { driver.quit();
  }
}
