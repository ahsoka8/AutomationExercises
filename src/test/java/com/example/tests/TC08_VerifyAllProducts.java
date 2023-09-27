package com.example.tests;

import com.example.pages.LoginPage;
import com.example.utilities.BrowserUtils;
import com.example.utilities.ConfigurationReader;
import com.example.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC08_VerifyAllProducts extends TestBase{
    LoginPage loginPage;

    @Test
    public void test08() {
        loginPage = new LoginPage();

        extentLogger = report.createTest("Test Case 8: Verify All Products and product detail page");
        extentLogger.info("navigate to" + ConfigurationReader.get("url"));
        extentLogger.info("Verify that home page is visible successfully");
        loginPage.verifyPageTitle();

        extentLogger.info("Click on 'Products' button");
        loginPage.getProductButton().click();
        BrowserUtils.waitFor(3);

        extentLogger.info("Verify user is navigated to ALL PRODUCTS page successfully");
        String expectedUrl = "https://automationexercise.com/products";
        String currentUrl= Driver.get().getCurrentUrl();
        Assert.assertEquals(expectedUrl,currentUrl);




    }

}
