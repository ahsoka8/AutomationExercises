package com.example.tests;

import com.example.pages.*;
import com.example.utilities.BrowserUtils;
import com.example.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC16_PlaceOrderLoginBeforeCheckout extends TestBase{
    LoginPage loginPage;
    CardPage cardPage;
    ProductDetailPage productDetailPage;
    DashboardPage dashboardPage;
    PaymentPage paymentPage;
    CheckoutPage checkoutPage;

    @Test
    public void test16() {
        loginPage = new LoginPage();
        cardPage = new CardPage();
        productDetailPage = new ProductDetailPage();
        dashboardPage = new DashboardPage();
        paymentPage = new PaymentPage();
        checkoutPage = new CheckoutPage();

        extentLogger = report.createTest("Test Case 16: Place Order: Login before Checkout");
        extentLogger.info("navigate to" + ConfigurationReader.get("url"));
        extentLogger.info("Verify that home page is visible successfully");
        loginPage.verifyPageTitle();

        extentLogger.info("Click 'Signup / Login' button");
        dashboardPage.clickLogin();
        extentLogger.info("Fill email, password and click 'Login' button");
        loginPage.login();

        extentLogger.info("Verify ' Logged in as username' at top");
        dashboardPage.verifyLoginUsername2();

        extentLogger.info("Add products to cart / Click card");
        cardPage.addProductsToCart();

        extentLogger.info("Verify that cart page is displayed");
        Assert.assertEquals(cardPage.getShoppingCart().getText(), "Shopping Cart");

        extentLogger.info(" Click Proceed To Checkout");
        cardPage.getProceedToCheckoutButton().click();
        extentLogger.info("Verify Address Details and Review Your Order");
        checkoutPage.verifyAddressDetails();
        checkoutPage.verifyReviewYourOrder();

        extentLogger.info("Enter description in comment text area and click 'Place Order'");
        cardPage.textAreaFillUp();

        extentLogger.info("Enter payment details: Name on Card, Card Number, CVC, Expiration date");
        paymentPage.fillPaymentDetails();

        extentLogger.info("Verify success message 'Your order has been placed successfully!'");
      //  BrowserUtils.waitForVisibility(paymentPage.getAlertSuccess(),3);
        Assert.assertEquals(paymentPage.getAlertSuccessText(), "Your order has been placed successfully!");
        extentLogger.info(" Click 'Delete Account' button");
        paymentPage.deleteAccount();
        extentLogger.info("Verify 'ACCOUNT DELETED!' and click 'Continue' button");
        dashboardPage.verifyAndDeleteAccount();

    }


}
