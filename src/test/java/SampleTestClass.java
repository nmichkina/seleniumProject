import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.WebDriverFactory;

public class SampleTestClass {

    WebDriver driver = null;

    @BeforeTest()
    public void setUp() {
        // Open the browser
        WebDriverFactory.createInstance("Chrome");
        driver = WebDriverFactory.getDriver();
    }

  @Test
  public void sampleTestMethod() {
    driver.get("https://www.google.com/");
    driver.findElement(By.cssSelector("input[name='q']")).sendKeys("Artur");
    driver.findElement(By.cssSelector("input[name='q']")).sendKeys(Keys.ENTER);

    assert driver.findElement(By.xpath("//*[contains(text(), 'Artur')]")).isDisplayed();
    // TODO - возвращает пустую строку -
      //driver.findElements(By.xpath("//*[contains(text(), 'Артур')]")).get(1).getText();
      //assert driver.findElement(By.cssSelector("input[name='q']")).getAttribute();
  }

    @AfterTest()
    public void tearDown() {
        // Close the browser
        WebDriverFactory.getDriver().quit();
    }

}
