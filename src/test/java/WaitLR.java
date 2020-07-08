import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.WebDriverFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class WaitLR {

    WebDriver driver = null;

    @BeforeMethod
    public void setUp() {
        WebDriverFactory.createInstance("Chrome");
        driver = WebDriverFactory.getDriver();
    }

    @Test
    public void successfulLogin() throws InterruptedException {
        driver.get("https://jira.hillel.it/secure/Dashboard.jspa");
        driver.findElement(By.id("login-form-username")).sendKeys("webinar5");
        driver.findElement(By.id("login-form-password")).sendKeys("webinar5");
        driver.findElement(By.id("login")).click();

        // метод ожидания с try/catch - мы ждем 3 секунды и потом ищем элемент
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        assertTrue(driver.findElement(By.id("header-details-user-fullname")).isDisplayed());

        //Explicit Wait for element to appear - мы четко сказали до какого элемента надо ждать и как долго
        // эта конструкция нужна в принципе когда сам элемент очень медленный
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5).getSeconds()); //создаем обьект ожидания и говорим сколько ждать
        boolean loginElementPresent = wait.until(presenceOfElementLocated(By.id("header-details-user-fullname"))).isDisplayed(); //presenceOfElementLocated - статический метод
        //wait.until + условие + локатор. isDisplayed для того что бы получить true/false для boolean
        assertEquals(loginElementPresent, true);

        // implicit wait - нужен нам когда мы имеем дело в медленной машиной. Будет ждать опеределенное время ДЛЯ КАЖДОГО элемента
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        WebDriverFactory.getDriver().quit();
    }
}

