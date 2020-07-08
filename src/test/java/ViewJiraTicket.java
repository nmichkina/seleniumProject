import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.WebDriverFactory;

import java.util.List;
import java.util.Random;

import static org.testng.Assert.assertTrue;

public class ViewJiraTicket {

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
    public void viewAssignedTicket() {
        List<WebElement> elements = driver.findElements(By.cssSelector(".issuekey a"));
//        List<WebElement> elements = driver.findElements(By.cssSelector("[data-issuekey]"));/* создаем List элементов, которые содержат
//        класс issueKey - это общее поле для всех тикетов*/
        int randomIndex = new Random().nextInt(elements.size());  //создаем рандомизатор для List элементов - наших тикетов
        String selectedTicket = elements.get(randomIndex).getAttribute("data-issue-key");
        elements.get(randomIndex).click(); //кликаем на рандомный тикет и открываем его


        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        driver.findElements(By.xpath("//*[contains(text(), 'WEBINAR')]")); //найти все элементы текст которых содержит webinar
//        assertTrue(driver.findElements(By.xpath("//*[contains(text(), 'WEBINAR')]")).get(3).isDisplayed()); /* мы из массива элементов
//        выбрали элемент с индексом 3 - индекс узнали в консоли тулзов */
//
//        List <WebElement> webinarTextDisplayed = driver.findElements(By.xpath("//*[contains(text(), 'WEBINAR')]"));
//        assertTrue(webinarTextDisplayed.get(3).isDisplayed()); - такая же запись! только через переменную!

        assertTrue(driver.getCurrentUrl().contains(selectedTicket));
        assertTrue(driver.findElement(By.id("type-val")).isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        WebDriverFactory.getDriver().quit();
    }


}
