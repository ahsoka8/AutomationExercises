package com.example.tests;

import com.example.pages.FooterPage;
import com.example.pages.LoginPage;
import com.example.pages.ProductsPage;
import com.example.utilities.BrowserUtils;
import com.example.utilities.ConfigurationReader;
import com.example.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC10_VerifySubscriptionInHomePage extends TestBase {

    LoginPage loginPage;
    FooterPage footerPage;

    @Test
    public void test10() {
        loginPage = new LoginPage();
        footerPage = new FooterPage();

        extentLogger = report.createTest("Test Case 10: Verify Subscription in home page");
        extentLogger.info("navigate to" + ConfigurationReader.get("url"));
        extentLogger.info("Verify that home page is visible successfully");
        loginPage.verifyPageTitle();

        extentLogger.info("Scroll down to footer");
        BrowserUtils.scrollToElement(footerPage.getFooter());
        extentLogger.info("Verify text 'SUBSCRIPTION'");
        Assert.assertEquals(footerPage.getFooter().getText(), "SUBSCRIPTION", "Verify text 'SUBSCRIPTION'");

        extentLogger.info("Enter email address in input and click arrow button");
        footerPage.subscribeEmail("leia@gmail.com");

        extentLogger.info("Verify success message 'You have been successfully subscribed!' is visible");
        Assert.assertEquals(footerPage.getSubscribeMessageText(), "You have been successfully subscribed!");

    }
}
