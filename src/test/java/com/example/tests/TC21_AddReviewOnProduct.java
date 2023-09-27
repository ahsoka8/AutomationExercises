package com.example.tests;

import com.example.pages.*;
import com.example.utilities.BrowserUtils;
import com.example.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC21_AddReviewOnProduct extends TestBase {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    CardPage cardPage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;

    @Test
    public void test21() {
        loginPage = new LoginPage();
        cardPage = new CardPage();
        dashboardPage = new DashboardPage();
        productsPage = new ProductsPage();
        productDetailPage = new ProductDetailPage();

        extentLogger = report.createTest("Test Case 12: Add Products in Cart");
        extentLogger.info("navigate to" + ConfigurationReader.get("url"));
        extentLogger.info("Verify that home page is visible successfully");
        loginPage.verifyPageTitle();

        extentLogger.info("Click on 'Products' button");
        dashboardPage.getProductButton().click();
        BrowserUtils.waitFor(3);

        extentLogger.info("Verify user is navigated to ALL PRODUCTS page successfully");
        Assert.assertEquals(productsPage.getTitleTextCenter().getText(), "ALL PRODUCTS");


        extentLogger.info("Click on 'View Product' button");
        BrowserUtils.scrollToElement(productsPage.getViewProductOfFirstProductButton());
        productsPage.getViewProductOfFirstProductButton().click();

        extentLogger.info("Verify 'Write Your Review' is visible");
        Assert.assertEquals(productDetailPage.getWriteYourReview().getText(), "WRITE YOUR REVIEW", "Verify 'Write Your Review' is visible");

        extentLogger.info("Enter name, email and review");
        productDetailPage.fillReviewForm();

        extentLogger.info("Verify success message 'Thank you for your review.");
        productDetailPage.verifySuccesMessage();
    }

}
