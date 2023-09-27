package com.example.tests;

import com.example.pages.LoginPage;
import com.example.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class TC03_LoginUserWithIncorrectInfo extends TestBase {
    LoginPage loginPage;

    @Test
    public void test03() {
        loginPage = new LoginPage();
        extentLogger = report.createTest("TC003-Login User with incorrect email and password");
        extentLogger.info(" Navigate to " + ConfigurationReader.get("url"));
        extentLogger.info("Verify that home page is visible successfully");
        loginPage.verifyPageTitle();

        extentLogger.info("Click on 'Signup / Login' button");
        loginPage.clickLogin();

        extentLogger.info(" Verify 'Login to your account' is visible");
        loginPage.verifyAccountLabel();

        extentLogger.info("Enter incorrect email address and password, Click 'login' button");
        loginPage.loginWithIncorrect("majestc@gmail.com", "12345");

        extentLogger.info("Verify error 'Your email or password is incorrect!' is visible");
        loginPage.verifyErrorMessage();
    }
}
