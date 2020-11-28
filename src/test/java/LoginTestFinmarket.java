import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.HomePage;
import pages.LoginPageFinmarket;
import pages.HomePageFinmarket;
import utils.WebDriverFactory;

import static org.testng.Assert.assertTrue;

public class LoginTestFinmarket {

  WebDriver driver = null;
  LoginPageFinmarket loginPageFinmarket = null;
  HomePageFinmarket homePageFinmarket = null;

  @Parameters("browserName")
  @BeforeMethod
  public void setUp(String browserName) {
    // любой Java Code
    WebDriverFactory.createInstance("Chrome");
    driver = WebDriverFactory.getDriver();
    loginPageFinmarket = new LoginPageFinmarket(driver);
    homePageFinmarket = new HomePageFinmarket(driver);
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
    homePageFinmarket.navigateTo();
    loginPageFinmarket.LoginButtonClick();
    loginPageFinmarket.enterUserName("nataliia.m@pandats.com");
    loginPageFinmarket.enterPassword("6127951Mn");
    loginPageFinmarket.clickSubmitLogin();

    assertTrue(loginPageFinmarket.depositButtonIsPresent());
  }
  @AfterMethod

  public void tearDown() { driver.quit();
  }
}
