import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.WebDriverFactory;

import static org.testng.Assert.assertTrue;

public class AssigneeJira {

    WebDriver driver = null;

    @BeforeMethod
    public void setUp() {
        WebDriverFactory.createInstance("Chrome");
        driver = WebDriverFactory.getDriver();
        driver.get("https://jira.hillel.it/secure/Dashboard.jspa");
        driver.findElement(By.id("login-form-username")).sendKeys("webinar5");
        driver.findElement(By.id("login-form-password")).sendKeys("webinar5");
        driver.findElement(By.id("login")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findAssignee() {
    driver.get("https://jira.hillel.it/browse/WEBINAR-9060");
    assertTrue(driver.findElement(By.xpath("//*[@class='people-details']//child::*[@id='assignee-val']")).isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        WebDriverFactory.getDriver().quit();
    }
}




