package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class HomePageFinmarket {


    WebDriver driver = null;//не передавать какой именно

    // драйвер открывать, это делается в before методе

    public HomePageFinmarket(WebDriver driver) {

        this.driver = driver;
    }

//    public boolean userIconIsPresent(){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10).getSeconds());
//        return wait.until(ExpectedConditions.presenceOfElementLocated(By.id("header-details-user-fullname"))).isDisplayed();


    //}
        public void navigateTo(){

        driver.get("https://www.forexbestmarket.com/");
          WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10).getSeconds());
          boolean elementIsPresent = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'Sign Up')]"))).isDisplayed();
          assertEquals(elementIsPresent, true);
    }
//    public void jiraTicketPath(){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5).getSeconds());
//        boolean elementIsPresent = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("header-details-user-fullname"))).isDisplayed();
//        assertEquals(elementIsPresent, true);
//        driver.get("https://jira.hillel.it/browse/WEBINAR-9060");
   // }



}
