import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPage;
import utils.WebDriverFactory;

import static org.testng.Assert.assertTrue;

public class LoginTestFinmarket {

  WebDriver driver = null;
  LoginPage loginPage = null;
  HomePage homePage = null;

  @Parameters("browserName")
  @BeforeMethod
  public void setUp(String browserName) {
    // любой Java Code
    WebDriverFactory.createInstance("Chrome");
    driver = WebDriverFactory.getDriver();
    loginPage = new LoginPage(driver);
    homePage = new HomePage(driver);
  }

  @DataProvider(name = "Logins")
  public Object[][] createData1(){
          return new Object[][]{
                  {"NataliiaMichkina","wrongPassword","Извините, имя пользователя или пароль неверны - пожалуйста, попробуйте еще раз."},
                  {"wrongUserName","NataliiaMichkina","Извините, имя пользователя или пароль неверны - пожалуйста, попробуйте еще раз."},
          };
  }

  @Test(dataProvider = "Logins")
  public void unsuccessfulLoginTest(String name, String password, String expectedResult) throws InterruptedException {
    homePage.navigateTo();
    loginPage.enterUserName(name);
    loginPage.enterPassword(password);
    loginPage.clickLogin();

    assertTrue(loginPage.errorMessageIsPresent(expectedResult));
  }

  @Test
  public void successfulLoginTest(){
    homePage.navigateTo();
    loginPage.enterUserName("NataliiaMichkina");
    loginPage.enterPassword("NataliiaMichkina");
    loginPage.clickLogin();

    assertTrue(homePage.userIconIsPresent());
  }
  @AfterMethod

  public void tearDown() { driver.quit();
  }
}
