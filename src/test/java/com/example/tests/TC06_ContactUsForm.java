package com.example.tests;

import com.example.pages.ContactUsPage;
import com.example.pages.DashboardPage;
import com.example.pages.LoginPage;
import com.example.utilities.BrowserUtils;
import com.example.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC06_ContactUsForm extends TestBase {

    LoginPage loginPage;
    ContactUsPage contactUsPage;

    @Test
    public void test06() {
        loginPage = new LoginPage();
        contactUsPage = new ContactUsPage();

        extentLogger = report.createTest("TC001 Register User");
        extentLogger.info("navigate to" + ConfigurationReader.get("url"));
        extentLogger.info("Verify that home page is visible successfully");
        loginPage.verifyPageTitle();

        extentLogger.info("Click on 'Contact Us' button");
        loginPage.getContactUsButton().click();

        extentLogger.info("Verify 'GET IN TOUCH' is visible");
        contactUsPage.verifyGetInTouch();

        extentLogger.info("Enter name, email, subject and message");
        contactUsPage.fillForm();

        extentLogger.info("Click OK button");
        contactUsPage.okButtonClick();

        extentLogger.info("Verify success message 'Success! Your details have been submitted successfully.' is visible");
        String expectedMessage = "Success! Your details have been submitted successfully.";
        String actualMessage = contactUsPage.getAlertSuccess().getText();
        Assert.assertEquals(expectedMessage, actualMessage);

        extentLogger.info("Click 'Home' button and verify that landed to home page successfully");
       // BrowserUtils.waitFor(3);
        contactUsPage.getHomePageButton().click();
        contactUsPage.verifyPageTitle();


    }
}
