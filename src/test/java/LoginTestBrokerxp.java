import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.HomePageBrokerxp;
import pages.HomePageFinmarket;
import pages.LoginPageBrockerxp;
import pages.LoginPageBrockerxp;
import utils.WebDriverFactory;

import static org.testng.Assert.assertTrue;

public class LoginTestBrokerxp {

  WebDriver driver = null;
  LoginPageBrockerxp loginPageBrockerxp = null;
  HomePageBrokerxp homePageBrokerxp = null;

  @Parameters("browserName")
  @BeforeMethod
  public void setUp(String browserName) {
    // любой Java Code
    WebDriverFactory.createInstance("Chrome");
    driver = WebDriverFactory.getDriver();
    loginPageBrockerxp = new LoginPageBrockerxp(driver);
    homePageBrokerxp = new HomePageBrokerxp(driver);
  }

//  @DataProvider(name = "Logins")
//  public Object[][] createData1(){
//          return new Object[][]{
//                  {"NataliiaMichkina","wrongPassword","Извините, имя пользователя или пароль неверны - пожалуйста, попробуйте еще раз."},
//                  {"wrongUserName","NataliiaMichkina","Извините, имя пользователя или пароль неверны - пожалуйста, попробуйте еще раз."},
//          };
//  }

//  @Test(dataProvider = "Logins")
//  public void unsuccessfulLoginTest(String name, String password) throws InterruptedException {
//    homePageFinmarket.navigateTo();
//    loginPageFinmarket.LoginButtonClick();
//    loginPageFinmarket.enterUserName(name);
//    loginPageFinmarket.enterPassword(password);
//    loginPageFinmarket.clickSubmitLogin();
//
//    assertTrue(loginPageFinmarket.depositButtonIsPresent());
//  }

  @Test
  public void successfulLoginTest(){
    homePageBrokerxp.navigateTo();
    loginPageBrockerxp.LoginButtonClick();
    loginPageBrockerxp.enterUserName("nataliia.m+1@pandats.com");
    loginPageBrockerxp.enterPassword("6127951Mn");
    loginPageBrockerxp.clickSubmitLogin();

    assertTrue(loginPageBrockerxp.CurrentDateIsPresent());
  }
  @AfterMethod

  public void tearDown() { driver.quit();
  }
}
