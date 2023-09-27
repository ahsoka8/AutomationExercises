package com.example.tests;

import com.example.pages.LoginPage;
import com.example.utilities.BrowserUtils;
import com.example.utilities.ConfigurationReader;
import com.example.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC07_VerifyTestCasesPage extends TestBase {

    LoginPage loginPage;

    @Test
    public void test07() {
        loginPage = new LoginPage();

        extentLogger = report.createTest("Test Case 7: Verify Test Cases Page");
        extentLogger.info("navigate to" + ConfigurationReader.get("url"));
        extentLogger.info("Verify that home page is visible successfully");
        loginPage.verifyPageTitle();

        extentLogger.info("Click on 'Test Cases' button");
        loginPage.getTestCases().click();
        BrowserUtils.waitFor(3);
        extentLogger.info("Verify user is navigated to test cases page successfully");
        String expectedUrl = "https://automationexercise.com/test_cases";
        String currentUrl = Driver.get().getCurrentUrl();
        Assert.assertEquals(expectedUrl, currentUrl);
    }
}
