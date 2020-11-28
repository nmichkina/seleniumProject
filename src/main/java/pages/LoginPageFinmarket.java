package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPageFinmarket {


    private WebDriver driver = null;//не передавать какой именно
    // драйвер открывать, это делается в before методе

    private By loginButton = By.xpath("//button[contains(text(),'Login')]");
    private By userNameInput = By.id("forex-login");
    private By passwordInput = By.id("forex-password");
    private By loginSubmitButton = By.cssSelector("body.home.page-template-default.page.page-id-7.color-custom.style-default.layout-full-width.no-content-padding.header-transparent.header-fw.minimalist-header.sticky-tb-color.ab-hide.subheader-both-center.menu-link-color.menuo-arrows.menuo-no-borders.mobile-tb-center.mobile-side-slide.mobile-mini-mr-ll.nice-scroll.ribbon_loaded.body-no-scroll-pandats:nth-child(2) div.container div.column.one div.top_bar_left.clearfix div.right_menu li.login_header_btn:nth-child(4) div.mainpandats.roboto-pandats.ng-star-inserted login-popup.ng-star-inserted div.roboto-pandats div.popup-wrapper-pandats div.full-width.col-left-pandats div.content-pandats form.ng-star-inserted.ng-dirty.ng-touched.ng-valid:nth-child(4) div.buttons-pandats.layout-column:nth-child(4) div.layout-row > button.forex-button-pandats.login-button-pandats.font-15-pandats");


    public LoginPageFinmarket(WebDriver driver) {
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
    public boolean depositButtonIsPresent(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10).getSeconds());
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.className("forex-button-pandats simple-button-pandats ng-star-inserted"))).isDisplayed();
        //return driver.findElement(By.xpath("//p[contains(text(),'"+message+"')]")).isDisplayed();
    }

}
