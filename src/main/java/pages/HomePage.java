package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class HomePage {

    WebDriver driver = null;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean userIconIsPresent() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5).getSeconds());
        return wait.until(presenceOfElementLocated(By.id("header-details-user-fullname"))).isDisplayed();
    }

    public void navigateTo() {
        driver.get("https://jira.hillel.it/secure/Dashboard.jspa");
    }
}
