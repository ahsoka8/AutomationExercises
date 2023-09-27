package com.example.tests;

import com.example.pages.DashboardPage;
import com.example.pages.LoginPage;
import com.example.utilities.ConfigurationReader;
import com.example.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC01_RegisterUser extends TestBase {

    LoginPage loginPage;
    DashboardPage dashboardPage;

    @Test
    public void test01() {
        extentLogger = report.createTest("TC001 Register User");
        extentLogger.info("navigate to" + ConfigurationReader.get("url"));
        extentLogger.info("Verify that home page is visible successfully");
        String expectedUrl = "https://automationexercise.com/";
        String actualUrl = Driver.get().getCurrentUrl();
        Assert.assertEquals(expectedUrl, actualUrl);
        // 2th way
        extentLogger.info("Verify that home page is visible successfully");
        String expectedTitle = "Automation Exercise";
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);

        extentLogger.info("Click on 'Signup / Login' button");
        loginPage = new LoginPage();
        loginPage.clickLogin();

        extentLogger.info("Verify 'New User Signup!' is visible");
        String expectedSignUpText="New User Signup!";
        Assert.assertEquals(expectedSignUpText, loginPage.getNewUserSignUpText());

        extentLogger.info("Enter name&email address and Click 'Signup' button");
        loginPage.signUp();

        extentLogger.info("Verify that 'ENTER ACCOUNT INFORMATION' is visible");
        dashboardPage = new DashboardPage();
        String actualAccountInfoText = dashboardPage.getAccountInfoLabel().getText();
        String expectedAccountInfoText = "ENTER ACCOUNT INFORMATION";
        Assert.assertEquals(expectedAccountInfoText, actualAccountInfoText);
        //2th way
        Assert.assertTrue(dashboardPage.getAccountInfoLabel().isDisplayed());

        extentLogger.info("Fill details: Title, Name, Email, Password, Date of birth");
        dashboardPage.fillUpForm();

        extentLogger.info("Verify that 'ACCOUNT CREATED!' is visible");
        String expectedMessage = "ACCOUNT CREATED!";
        String actualAccountMessage = dashboardPage.getCreatedAccount().getText();
        Assert.assertEquals(expectedMessage, actualAccountMessage);


        extentLogger.info("Click 'Continue' button");
        dashboardPage.getContinueButton().click();

        extentLogger.info("Verify that 'Logged in as username' is visible");
        Assert.assertTrue(dashboardPage.getLoginAsUsername().isDisplayed());

        extentLogger.info("Click 'Delete Account' button");
        dashboardPage.deleteAccount();

        extentLogger.info("Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button");
        dashboardPage.verifyAndDeleteAccount();

    }
}

