package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import utils.WebDriverFactory;
import java.time.Duration;

public class HomePage {


    WebDriver driver = null;//не передавать какой именно

    // драйвер открывать, это делается в before методе

    public HomePage(WebDriver driver) {

        this.driver = driver;
    }

    public boolean createButtonPresent(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5).getSeconds());
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.id("create_link"))).isDisplayed();
        //return driver.findElement(By.id("create_link")).isDisplayed();
    }
    public boolean createButtonEnabled() {
        return driver.findElement(By.id("create_link")).isEnabled();
    }
    public void navigateTo(){
        driver.get("https://jira.hillel.it/secure/Dashboard.jspa");
    }
    public void jiraTicketPath(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5).getSeconds());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("create_link"))).isDisplayed();
        driver.get("https://jira.hillel.it/browse/WEBINAR-9060");
    }



}
