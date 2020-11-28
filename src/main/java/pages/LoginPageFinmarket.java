package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPageFinmarket {


    private WebDriver driver = null;//не передавать какой именно
    // драйвер открывать, это делается в before методе

    private By userNameInput = By.id("login-form-username");
    private By passwordInput = By.id("login-form-password");
    private By loginButton = By.id("login");

    public LoginPageFinmarket(WebDriver driver) {
        this.driver = driver;
    }
    public void enterUserName(String name){
        driver.findElement(userNameInput).sendKeys(name);
    }
    public void enterPassword(String password){
        driver.findElement(passwordInput).sendKeys(password);
    }
    public void clickLogin(){
        driver.findElement(loginButton).click();
    }
    public boolean errorMessageIsPresent(String message){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10).getSeconds());
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//p[contains(text(),'"+message+"')]"))).isDisplayed();
        //return driver.findElement(By.xpath("//p[contains(text(),'"+message+"')]")).isDisplayed();
    }

}
