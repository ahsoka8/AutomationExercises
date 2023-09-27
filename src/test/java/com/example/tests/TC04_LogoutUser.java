package com.example.tests;

import com.example.pages.LoginPage;
import com.example.utilities.ConfigurationReader;
import com.example.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC04_LogoutUser extends TestBase {
    LoginPage loginPage;

    @Test
    public void test04() {
        loginPage = new LoginPage();
        extentLogger = report.createTest("TC004-Logout User");
        extentLogger.info(" Navigate to " + ConfigurationReader.get("url"));
        extentLogger.info("Verify that home page is visible successfully");
        loginPage.verifyPageTitle();

        extentLogger.info("Click on 'Signup / Login' button");
        loginPage.clickLogin();

        extentLogger.info(" Verify 'Login to your account' is visible");
        loginPage.verifyAccountLabel();

        extentLogger.info("Enter correct email address and password, Click 'login' button");
        loginPage.login();

        extentLogger.info(" Verify that 'Logged in as username' is visible");
        loginPage.verifyLoginUsername();

        extentLogger.info("Click 'Logout' button");
        loginPage.getLogoutButton().click();

        extentLogger.info("Verify that user is navigated to login page");
        String expectedPage= "https://automationexercise.com/login";
        String actualPage= Driver.get().getCurrentUrl();
        Assert.assertEquals(actualPage, expectedPage);
    }
}
