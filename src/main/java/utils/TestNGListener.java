package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.format.DateTimeFormatter;

import static utils.WebDriverFactory.getDriver;


public class TestNGListener implements ITestListener {

    public void onTestStart(ITestResult iTestResult) {

    }

    public void onTestSuccess(ITestResult iTestResult) {

    }

    public void onTestFailure(ITestResult iTestResult) {
        File screenshotFolder = new File(System.getProperty("user.dir") + "/screenshots");

        if (!screenshotFolder.exists()) {
            screenshotFolder.mkdir();
        }

        File screenshot = ((ChromeDriver) WebDriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);

        try {
            String screenshotName = screenshotFolder + "/screenshot" + java.time.LocalTime.now().toString().replace(":", ".") + ".jpg";
            FileUtils.copyFile(screenshot, new File(screenshotName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("End of test failure");
    }

    public void onTestSkipped(ITestResult iTestResult) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    public void onStart(ITestContext iTestContext) {

    }

    public void onFinish(ITestContext iTestContext) {

    }
}
