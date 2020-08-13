package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
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

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.testng.Assert.assertEquals;


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
    private By createButton = By.id("create_link");
    private By projectField = By.id("project-field");
    private By issueTypeField = By.id("issuetype-field");
    private By summaryField = By.id("summary");
    private By reporterField = By.id("reporter-field");
    private By createTicketSubmitButton = By.id("create-issue-submit");
    private By createTicketSuccessPopup = By.className("aui-message-success");
    private By createTicketSuccessPopupTitle = By.xpath("//*[contains(text(), 'WEBINAR')]");



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
    public void createButtonClick(){
    clickOnElementWithRetry(createButton, projectField, 3, 3);


       /* if() {
            return;
        } else{
            try {
                Thread.sleep(2000);
                }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            driver.findElement(createButton).click();
        }*/

    }
    private void clickOnElementWithRetry(By elementToBeClicked, By successCriteriaElement, int attempts, int timeOutInSeconds){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds).getSeconds());

        for (int i = 0; i<attempts; i++){
            //driver.findElement(elementToBeClicked).click();
            try {
                wait.until(ExpectedConditions.presenceOfElementLocated(successCriteriaElement));
                break;

            } catch(TimeoutException e){
                wait.until(ExpectedConditions.elementToBeClickable(elementToBeClicked));
                driver.findElement(elementToBeClicked).click();
            }

        }
    }

    public void enterProjectName(String project){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5).getSeconds());
        wait.until(ExpectedConditions.elementToBeClickable(projectField));
        driver.findElement(projectField).clear();
        driver.findElement(projectField).sendKeys(project);
        driver.findElement(projectField).sendKeys(Keys.TAB);
    }
    public void enterIssueType(String issuetype){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5).getSeconds());
        wait.until(ExpectedConditions.elementToBeClickable(issueTypeField));
        driver.findElement(issueTypeField).clear();
        driver.findElement(issueTypeField).sendKeys(issuetype);
        driver.findElement(issueTypeField).sendKeys(Keys.TAB);
    }
    public void enterSummary(String summary){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5).getSeconds());
        wait.until(ExpectedConditions.elementToBeClickable(summaryField));
        driver.findElement(summaryField).sendKeys(summary);
    }
    public void enterReporter(String reporter){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5).getSeconds());
        wait.until(ExpectedConditions.elementToBeClickable(reporterField));
        driver.findElement(reporterField).clear();
        driver.findElement(reporterField).sendKeys(reporter);
        driver.findElement(reporterField).sendKeys(Keys.TAB);
    }
    public void clickCreateIssueSubmitButton(){
        driver.findElement(createTicketSubmitButton).click();
    }
    public boolean createIsueSuccessMessagePresent(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5).getSeconds());
        return wait.until(presenceOfElementLocated(createTicketSuccessPopup)).isDisplayed();

    }
    public boolean popupTitleIsPresent(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5).getSeconds());
        return wait.until(presenceOfElementLocated(createTicketSuccessPopupTitle)).isDisplayed();
    }

}
