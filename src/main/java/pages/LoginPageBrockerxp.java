package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPageBrockerxp {


    private WebDriver driver = null;//не передавать какой именно
    // драйвер открывать, это делается в before методе

    private By loginButton = By.xpath("//span[contains(text(),'Login')]");
    private By userNameInput = By.id("dnn_ctr517_Login_Login_DNN_txtUsername");
    private By passwordInput = By.id("dnn_ctr517_Login_Login_DNN_txtPassword");
    private By loginSubmitButton = By.id("dnn_ctr517_Login_Login_DNN_cmdLogin");


    public LoginPageBrockerxp(WebDriver driver) {
        this.driver = driver;
    }
    public void LoginButtonClick(){
        driver.findElement(loginButton).click();
    }
    public void enterUserName(String name){
        driver.findElement(userNameInput).sendKeys(name);
    }
    public void enterPassword(String password){
        driver.findElement(passwordInput).sendKeys(password);
    }
    public void clickSubmitLogin(){
        driver.findElement(loginSubmitButton).click();
    }
    public boolean CurrentDateIsPresent(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10).getSeconds());
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.id("dnn_dnnCurrentDay_lblDate"))).isDisplayed();
        //return driver.findElement(By.xpath("//p[contains(text(),'"+message+"')]")).isDisplayed();
    }

}
