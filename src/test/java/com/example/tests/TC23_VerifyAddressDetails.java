package com.example.tests;

import com.example.pages.*;
import com.example.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC23_VerifyAddressDetails extends TestBase {

    LoginPage loginPage;
    CardPage cardPage;
    ProductDetailPage productDetailPage;
    DashboardPage dashboardPage;
    PaymentPage paymentPage;

    @Test
    public void test23() {
        loginPage = new LoginPage();
        cardPage = new CardPage();
        productDetailPage = new ProductDetailPage();
        dashboardPage = new DashboardPage();
        paymentPage = new PaymentPage();

        extentLogger = report.createTest("Test Case 23: Verify address details in checkout page");
        extentLogger.info("navigate to" + ConfigurationReader.get("url"));
        extentLogger.info("Verify that home page is visible successfully");
        loginPage.verifyPageTitle();

        extentLogger.info(" Click 'Signup / Login' button");
        dashboardPage.clickLogin();

        extentLogger.info("Fill all details in Signup and create account");
        loginPage.signUp();
        dashboardPage.fillUpForm();
        extentLogger.info("Verify 'ACCOUNT CREATED!' and click 'Continue' button");
        Assert.assertEquals(dashboardPage.getCreatedAccount().getText(), "ACCOUNT CREATED!");
        dashboardPage.getContinueButton().click();

        extentLogger.info("Verify ' Logged in as username' at top");
        dashboardPage.verifyLoginUsername();

        extentLogger.info("Add products to cart");
        cardPage.addProductsToCart();
        extentLogger.info("Click 'Cart' button");
        cardPage.getCartButton().click();

        extentLogger.info("Verify that cart page is displayed");
        Assert.assertEquals(cardPage.getShoppingCart().getText(), "Shopping Cart");

        extentLogger.info("Click 'Proceed To Checkout' button");
        cardPage.getProceedToCheckoutButton().click();

        extentLogger.info(" Verify that the delivery address is same address filled at the time registration of account");
        Assert.assertTrue(dashboardPage.getDeliveryAddress().contains(ConfigurationReader.get("adress1")));

        extentLogger.info("Verify that the billing address is same address filled at the time registration of account");
        Assert.assertTrue(dashboardPage.getDeliveryAddress().contains(ConfigurationReader.get("adress2")));
        extentLogger.info("Click 'Delete Account' button");
        paymentPage.deleteAccount();
        extentLogger.info("Verify 'ACCOUNT DELETED!' and click 'Continue' button");
        dashboardPage.verifyAndDeleteAccount();

    }
}
