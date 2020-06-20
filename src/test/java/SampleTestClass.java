import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SampleTestClass {

  WebDriver driver = null;

  @BeforeTest()
  public void setUp() {
    // Open the browser
    WebDriverFactory.createInstance("Chrome");
  }

  @Test
  public void sampleTestMethod() {
    driver.get("https://www.google.com/");
    driver.findElement(By.cssSelector("input[name='q']")).sendKeys("Artur");
    assert 1 == 1;
  }

  @AfterTest()
  public void tearDown() {
    // Close the browser
    WebDriverFactory.getDriver().quit();
  }

}
