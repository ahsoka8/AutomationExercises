package com.example.tests;

import com.example.pages.*;
import com.example.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC17_RemoveProductsFromCart extends TestBase{
    LoginPage loginPage;
    CardPage cardPage;
    ProductDetailPage productDetailPage;
    DashboardPage dashboardPage;
    PaymentPage paymentPage;
    CheckoutPage checkoutPage;

    @Test
    public void test17() {
        loginPage = new LoginPage();
        cardPage = new CardPage();
        productDetailPage = new ProductDetailPage();
        dashboardPage = new DashboardPage();
        paymentPage = new PaymentPage();
        checkoutPage = new CheckoutPage();

        extentLogger = report.createTest("Test Case 17: Remove Products From Cart");
        extentLogger.info("navigate to" + ConfigurationReader.get("url"));
        extentLogger.info("Verify that home page is visible successfully");
        loginPage.verifyPageTitle();

        extentLogger.info("Add products to cart / Click card");
        cardPage.addProductsToCart();

        extentLogger.info("Verify that cart page is displayed");
        Assert.assertEquals(cardPage.getShoppingCart().getText(), "Shopping Cart");

        extentLogger.info("Click 'X' button corresponding to particular product");
        cardPage.xButtonClick();

        extentLogger.info(" Verify that product is removed from the cart");
        Assert.assertEquals(cardPage.getEmptyCardSpanText(), "Cart is empty! Click here to buy products.", "Verify that product is removed from the cart");

    }
}
