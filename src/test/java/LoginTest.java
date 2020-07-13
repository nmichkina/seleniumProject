import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.WebDriverFactory;

import static org.testng.Assert.assertTrue;

public class LoginTest {

    WebDriver driver = null;
    LoginPage loginPage = null;
    HomePage homePage = null;

    @BeforeMethod
    public void setUp() {
        WebDriverFactory.createInstance("Chrome");
        driver = WebDriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
    }


    @DataProvider(name = "Logins")
    public Object[][] createData() {
        return new Object[][] {
            { "webinar5", "wrongPassword", "Sorry, your username and password are incorrect - please try again." },
            { "wrongUserName", "webinar5", "Sorry, your username and password are incorrect - please try again." },
        };
    }

    @Test(dataProvider = "Logins")
    public void unsuccessfulLoginTest(String name, String password, String expectedResult) throws InterruptedException {
        loginPage.navigateTo();
        loginPage.enterUsername(name);
        loginPage.enterPass(password);
        loginPage.loginClick();

        assertTrue(loginPage.errorMessageIsPresent(expectedResult));
    }

    @Test
    public void successfulLoginTest() {
        loginPage.navigateTo();
        loginPage.enterUsername("webinar5");
        loginPage.enterPass("webinar5");
        loginPage.loginClick();
        assertTrue(homePage.userIconIsPresent());
    }


    @AfterMethod
    public void tearDown() {
        WebDriverFactory.getDriver().quit();
    }
}

