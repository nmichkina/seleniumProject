package utils;

import com.google.common.collect.ImmutableMap;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.Command;
import org.openqa.selenium.remote.CommandExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class WebDriverFactory {

  private static WebDriver webDriver;

  public static WebDriver getDriver() {
    return webDriver;
  }

  public static void createInstance(String browserName) {

    WebDriver driver = null;

    if (browserName.toLowerCase().contains("firefox")) {
      WebDriverManager.firefoxdriver().setup(); // Аналог - System.setProperty("webdriver.chrome.driver","D:\List_of_Jar\chromedriver.exe"); и руками не кладем фафлик в папку
      driver = new FirefoxDriver();
    } else if (browserName.toLowerCase().contains("internet")) {
      WebDriverManager.iedriver().setup();
      driver = new InternetExplorerDriver();
    } else if (browserName.toLowerCase().contains("chrome")) {
      // WebDriverManager.chromedriver().version("84.0.4147.30").setup();
      WebDriverManager.chromedriver().setup();
      driver = new ChromeDriver();
    } else {
      driver = new ChromeDriver();
    }

    driver.manage().window().maximize();
    webDriver = driver;
  }

}
