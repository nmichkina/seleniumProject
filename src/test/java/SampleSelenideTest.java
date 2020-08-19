import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;


public class SampleSelenideTest {
    @BeforeMethod
    public void setUp(){
        Configuration.browser = "firefox";
    }

    @Test
    public void logInTest(){
        open("https://jira.hillel.it/secure/Dashboard.jspa");
        $(By.id("login-form-username")).setValue("NataliiaMichkina");
        $(By.id("login-form-password")).setValue("NataliiaMichkina");
        $("#login").click();
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        $(By.id("header-details-user-fullname")).shouldBe(Condition.visible);
        /*Configuration.assertionMode = Configuration.AssertionMode.SOFT;
        Configuration.assertionMode = Configuration.AssertionMode.STRICT;*/

    }

}
