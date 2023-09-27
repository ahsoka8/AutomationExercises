package com.example.tests;

import com.example.pages.*;
import com.example.utilities.BrowserUtils;
import com.example.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC22_AddToCartFromRecommendedItems extends TestBase {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    CardPage cardPage;
    ProductsPage productsPage;
    ProductDetailPage productDetailPage;

    @Test
    public void test22() {
        loginPage = new LoginPage();
        cardPage = new CardPage();
        dashboardPage = new DashboardPage();
        productsPage = new ProductsPage();
        productDetailPage = new ProductDetailPage();

        extentLogger = report.createTest("Test Case 22: Add to cart from Recommended items");
        extentLogger.info("navigate to" + ConfigurationReader.get("url"));
        extentLogger.info("Verify 'RECOMMENDED ITEMS' are visible");
        BrowserUtils.scrollToElement(dashboardPage.getRecommendedItems());
        Assert.assertEquals(dashboardPage.getRecommendedItems().getText(), "RECOMMENDED ITEMS");

        extentLogger.info("Click on 'Add To Cart' on Recommended product");



    }

}
