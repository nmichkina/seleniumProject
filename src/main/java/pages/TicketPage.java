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


public class TicketPage {


    private WebDriver driver = null;//не передавать какой именно
    // драйвер открывать, это делается в before методе
    public TicketPage(WebDriver driver) {

        this.driver = driver;
    }

    private By commentFooterButton = By.id("footer-comment-button");
    private By commentField = By.id("comment");
    private By commentSubmitButton = By.id("issue-comment-add-submit");
    private By deleteCommentButton = By.xpath("//span[@class='icon-default aui-icon aui-icon-small aui-iconfont-delete']");

    public void navigateTo(){
        driver.get("https://jira.hillel.it/browse/WEBINAR-12148");
    }
    public void clickFooterCommentButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5).getSeconds());
        wait.until(ExpectedConditions.presenceOfElementLocated(commentFooterButton)).isDisplayed();
        driver.findElement(commentFooterButton).click();
    }
    public void enterComment(String comment){
        driver.findElement(commentField).sendKeys(comment);
    }
    public void clickCommentSubmit(){
        driver.findElement(commentSubmitButton).click();
    }
    public boolean newCommentPresent() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5).getSeconds());
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(), 'New comment')]"))).isDisplayed();
    }
    public void clickDeleteCommentButton(){
        driver.findElement(deleteCommentButton).click();
    }
    public void deleteCommentSubmitClick(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5).getSeconds());
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("comment-delete-submit"))).isDisplayed();
        driver.findElement(By.id("comment-delete-submit")).click();
    }
    public boolean successMessageDeleteCommentPresent(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5).getSeconds());
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='aui-message closeable aui-message-success aui-will-close']"))).isDisplayed();
    }

}
