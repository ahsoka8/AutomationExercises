package com.example.tests;

import com.example.pages.DashboardPage;
import com.example.pages.LoginPage;
import com.example.utilities.ConfigurationReader;
import com.example.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC02_LoginUserWithCorrectInfo extends TestBase {
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test
    public void test02() {

        loginPage = new LoginPage();
        dashboardPage = new DashboardPage();

        extentLogger = report.createTest("TC02-Login User with correct email and password");
        extentLogger.info(" Navigate to url" + ConfigurationReader.get("url"));
        extentLogger.info("Verify that home page is visible successfully");
        String exceptedTtile = "Automation Exercise";
        Assert.assertEquals(exceptedTtile, Driver.get().getTitle());

        extentLogger.info("Click on 'Signup / Login' button");
        loginPage.clickLogin();

        extentLogger.info("Verify 'Login to your account' is visible");
        String expectedText = "Login to your account";
        Assert.assertEquals(expectedText,  loginPage.getLoginText());

        extentLogger.info("Enter correct email address/password and Click 'login' button");
        loginPage.login();

        extentLogger.info("Verify that 'Logged in as username' is visible");
        Assert.assertTrue(loginPage.getLoginAsUsername().isDisplayed());

        extentLogger.info("Click 'Delete Account' button");
        loginPage.deleteAccount();

        extentLogger.info("Click 'Delete Account' button");

        dashboardPage.verifyAndDeleteAccount();

    }
}
