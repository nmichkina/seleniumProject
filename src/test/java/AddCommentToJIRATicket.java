import org.openqa.selenium.By;
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
import static org.testng.Assert.*;

public class AddCommentToJIRATicket {

  WebDriver driver = null;
  LoginPage loginPage = null;
  HomePage homePage = null;
  TicketPage ticketPage= null;

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
  public void successfulLoginTest() {
    homePage.navigateTo();
    loginPage.enterUserName("NataliiaMichkina");
    loginPage.enterPassword("NataliiaMichkina");
    loginPage.clickLogin();

    assertTrue(homePage.createButtonPresent());

    ticketPage.navigateTo();
    ticketPage.clickFooterCommentButton();
    ticketPage.enterComment("New comment");
    ticketPage.clickCommentSubmit();

    assertTrue(ticketPage.newCommentPresent());

    ticketPage.clickDeleteCommentButton();
    ticketPage.deleteCommentSubmitClick();

    assertTrue(ticketPage.successMessageDeleteCommentPresent());
  }

  @AfterMethod
  public void tearDown() {
    driver.quit();
  }
}

