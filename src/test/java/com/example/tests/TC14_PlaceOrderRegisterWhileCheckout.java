package com.example.tests;

import com.example.pages.*;
import com.example.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC14_PlaceOrderRegisterWhileCheckout extends TestBase {

    LoginPage loginPage;
    CardPage cardPage;
    ProductDetailPage productDetailPage;
    DashboardPage dashboardPage;
    PaymentPage paymentPage;
    CheckoutPage checkoutPage;

    @Test
    public void test14() {
        loginPage = new LoginPage();
        cardPage = new CardPage();
        productDetailPage = new ProductDetailPage();
        dashboardPage = new DashboardPage();
        paymentPage = new PaymentPage();
        checkoutPage = new CheckoutPage();

        extentLogger = report.createTest("Test Case 14: Place Order: Register while Checkout");
        extentLogger.info("navigate to" + ConfigurationReader.get("url"));
        extentLogger.info("Verify that home page is visible successfully");
        loginPage.verifyPageTitle();

        extentLogger.info("Add products to cart / Click card");
        cardPage.addProductsToCart();

        extentLogger.info("Verify that cart page is displayed");
        Assert.assertEquals(cardPage.getShoppingCart().getText(), "Shopping Cart");

        extentLogger.info(" Click Proceed To Checkout");
        cardPage.getProceedToCheckoutButton().click();

        extentLogger.info(" Click 'Register / Login' button");
        cardPage.getRegisterButton().click();

        extentLogger.info("Fill all details in Signup and create account");

        loginPage.signUp();
        dashboardPage.fillUpForm();
        extentLogger.info("Verify 'ACCOUNT CREATED!' and click 'Continue' button");
        Assert.assertEquals(dashboardPage.getCreatedAccount().getText(), "ACCOUNT CREATED!");
        dashboardPage.getContinueButton().click();

        extentLogger.info("Verify ' Logged in as username' at top");
        dashboardPage.verifyLoginUsername();

        extentLogger.info("Click 'Cart' button");
        dashboardPage.getCartButton().click();

        extentLogger.info("Click 'Proceed To Checkout' button");
        cardPage.getProceedToCheckoutButton().click();

        extentLogger.info("Verify Address Details and Review Your Order");
        checkoutPage.verifyAddressDetails1();

        extentLogger.info("Enter description in comment text area and click 'Place Order'");
        cardPage.textAreaFillUp();

        extentLogger.info("Enter payment details: Name on Card, Card Number, CVC, Expiration date");
        paymentPage.fillPaymentDetails();

        extentLogger.info("Verify success message 'Your order has been placed successfully!'");
       // Assert.assertEquals(paymentPage.getSuccessMessage().getText(), "Your order has been placed successfully!");

        paymentPage.deleteAccount();
        dashboardPage.verifyAndDeleteAccount();

    }


}
