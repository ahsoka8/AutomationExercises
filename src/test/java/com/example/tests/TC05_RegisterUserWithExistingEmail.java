package com.example.tests;

import com.example.pages.LoginPage;
import com.example.utilities.ConfigurationReader;
import com.example.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC05_RegisterUserWithExistingEmail extends TestBase{
    LoginPage loginPage;

    @Test
    public void test05(){
        loginPage = new LoginPage();

        extentLogger = report.createTest("Test Case 5: Register User with existing email");
        extentLogger.info("navigate to" + ConfigurationReader.get("url"));
        extentLogger.info("Verify that home page is visible successfully");
        loginPage.verifyPageTitle();

        extentLogger.info("Click on 'Signup / Login' button");
        loginPage.clickLogin();

        extentLogger.info("Verify 'New User Signup!' is visible");
        String expectedSignUpText="New User Signup!";
        Assert.assertEquals(expectedSignUpText, loginPage.getNewUserSignUpText());

        extentLogger.info("Enter name&email address and Click 'Signup' button");
        loginPage.signUp();

        extentLogger.info("Verify error 'Email Address already exist!' is visible");
        loginPage.verifyExistEmailMessage();


    }
}
