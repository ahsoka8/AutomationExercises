package com.example.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.example.utilities.BrowserUtils;
import com.example.utilities.ConfigurationReader;
import com.example.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestBase {
    protected WebDriver driver;
    protected Actions actions;
    protected WebDriverWait wait;

    static protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest extentLogger;

    @BeforeTest
    public void setUpTest() {

        report = new ExtentReports();

        String projectPath = System.getProperty("user.dir");
        String reportPath = projectPath + "/test-output/report.html";

        htmlReporter = new ExtentHtmlReporter(reportPath);
        report.attachReporter(htmlReporter);

        htmlReporter.config().setReportName("Smoke Test");

        report.setSystemInfo("Environment", "QA");
        report.setSystemInfo("Browser", ConfigurationReader.get("browser"));
        report.setSystemInfo("OS", System.getProperty("os.name"));
        report.setSystemInfo("Test Engineer", "Leia Organa");
        report.setSystemInfo("PO", "HanSolo");

    }

    @AfterTest
    public void tearDownTest() {
        report.flush();
    }

    @BeforeMethod
    public void setUp() {
        driver = Driver.get();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfigurationReader.get("url"));
        actions = new Actions(driver);
        wait = new WebDriverWait(driver, 10);
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        //if the test fails
        if (result.getStatus() == ITestResult.FAILURE) {
            //record the failed test name
            extentLogger.fail(result.getName());

            //take screenshot and return the location of screenshot
            String screenShotPath = BrowserUtils.getScreenshot(result.getName());

            //add the screenshot to the report
            extentLogger.addScreenCaptureFromPath(screenShotPath);

            //capture exception logs and add to the report
            extentLogger.fail(result.getThrowable());
        }

        Driver.closeDriver();
    }


}
