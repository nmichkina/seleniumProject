package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver = null;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String name) {
        driver.findElement(By.id("login-form-username")).sendKeys(name);
    }

    public void enterPass(String pass) {
        driver.findElement(By.id("login-form-password")).sendKeys(pass);
    }

    public void loginClick() {
        driver.findElement(By.id("login")).click();
    }

    public void navigateTo() {
        driver.get("https://jira.hillel.it/secure/Dashboard.jspa");
    }
}
