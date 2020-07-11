import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.CreateIssueWindow;
import pages.HomePage;
import pages.JiraTicketPage;
import pages.LoginPage;
import utils.WebDriverFactory;

import static org.testng.Assert.assertTrue;

public class TestClass {

    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private JiraTicketPage jiraTicketPage;
    private CreateIssueWindow createIssueWindow;

    @BeforeTest()
    public void setUp() {
        WebDriverFactory.createInstance("Chrome");
        driver = WebDriverFactory.getDriver();
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        jiraTicketPage = new JiraTicketPage(driver);
        createIssueWindow = new CreateIssueWindow(driver);
    }

    @Test
    public void successfulLoginTest() {
        homePage.navigateToHomePage();
        loginPage.enterUserName("VyacheslavArtyomenko");
        loginPage.enterPassword("VyacheslavArtyomenko");
        loginPage.clickLoginButton();

        assertTrue(homePage.isUserIconDisplayed());
    }

    @Test
    public void viewJiraTicket() {
        jiraTicketPage.navigateToJiraTicketPage();
        loginPage.enterUserName("VyacheslavArtyomenko");
        loginPage.enterPassword("VyacheslavArtyomenko");
        loginPage.clickLoginButton();

        Assert.assertTrue(jiraTicketPage.isIssueTypePresent());
        Assert.assertTrue(jiraTicketPage.isTitleContains("WEBINAR-9060"));
    }

    @Test
    public void createIssue() {
        homePage.navigateToHomePage();
        loginPage.enterUserName("VyacheslavArtyomenko");
        loginPage.enterPassword("VyacheslavArtyomenko");
        loginPage.clickLoginButton();

        homePage.isCreateIssueButtonPresent();   // TODO
        homePage.clickCreateIssue();

        createIssueWindow.isProjectFieldDisplayed();
        createIssueWindow.clearProjectField();
        createIssueWindow.enterProjectField("Webinar");
        createIssueWindow.pressTabAfterProjectField();

        createIssueWindow.isIssueTypeFieldDisplayed();
        createIssueWindow.clearIssueTypeField();
        createIssueWindow.enterIssueTypeField("Task");
        createIssueWindow.pressTabAfterIssueTypeField();

        createIssueWindow.isSummaryFieldDisplayed();
        createIssueWindow.enterSummary("One more test summary");
        createIssueWindow.clearReporterField();
        createIssueWindow.enterReporterField("VyacheslavArtyomenko");

        createIssueWindow.pressCreateIssueButton();
        Assert.assertTrue(homePage.isIssueCreated());
    }

    @Test
    public void addComment() {
        jiraTicketPage.navigateToJiraTicketPage();
        loginPage.enterUserName("VyacheslavArtyomenko");
        loginPage.enterPassword("VyacheslavArtyomenko");
        loginPage.clickLoginButton();

        jiraTicketPage.isCommentButtonDisplayed();
        jiraTicketPage.clickCommentButton();
        jiraTicketPage.sendTextToCommentField("Test comment");
        jiraTicketPage.clickAddCommentButton();

        Assert.assertTrue(jiraTicketPage.isTicketCreated());

        jiraTicketPage.clickOnDeleteLastComment();
        jiraTicketPage.isDeleteDialogButtonDisplayed();
        jiraTicketPage.clickDeleteDialogButton();

        jiraTicketPage.isCommentSectionDisplayed(); // TODO
        Assert.assertTrue(jiraTicketPage.isLastCommentDeleted());

        System.out.println("Done");
    }

    @Test
    public void failOnPurpose() {
        driver.get("https://www.google.com.ua/?hl=ru");
        Assert.assertTrue(false);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
