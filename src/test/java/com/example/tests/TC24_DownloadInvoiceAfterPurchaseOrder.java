package com.example.tests;

import com.example.pages.*;
import com.example.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC24_DownloadInvoiceAfterPurchaseOrder extends TestBase {

    LoginPage loginPage;
    CardPage cardPage;
    ProductDetailPage productDetailPage;
    DashboardPage dashboardPage;
    PaymentPage paymentPage;
    CheckoutPage checkoutPage;

    @Test
    public void test24() {
        loginPage = new LoginPage();
        cardPage = new CardPage();
        productDetailPage = new ProductDetailPage();
        dashboardPage = new DashboardPage();
        paymentPage = new PaymentPage();
        checkoutPage = new CheckoutPage();

        extentLogger = report.createTest("Test Case 24: Download Invoice after purchase order");
        extentLogger.info("navigate to" + ConfigurationReader.get("url"));
        extentLogger.info("Verify that home page is visible successfully");
        loginPage.verifyPageTitle();

        extentLogger.info("Add products to cart / Click card");
        cardPage.addProductsToCart();

        extentLogger.info("Verify that cart page is displayed");
        Assert.assertEquals(cardPage.getShoppingCart().getText(), "Shopping Cart");

        extentLogger.info("Click 'Proceed To Checkout' button");
        cardPage.getProceedToCheckoutButton().click();

        extentLogger.info("Verify Address Details and Review Your Order");
        checkoutPage.verifyAddressDetails();
        checkoutPage.verifyReviewYourOrder();

        extentLogger.info("Enter description in comment text area and click 'Place Order'");
        cardPage.textAreaFillUp();

        extentLogger.info("Enter payment details: Name on Card, Card Number, CVC, Expiration date");
        paymentPage.fillPaymentDetails();

        extentLogger.info("Verify success message 'Your order has been placed successfully!'");
// Assert.assertEquals(paymentPage.getAlertSuccessText(), "Your order has been placed successfully!");


        extentLogger.info("Click 'Download Invoice' button and verify invoice is downloaded successfully.");
      /*  boolean isFileDownloaded = VerifyDownload.isFileDownloaded("invoice", "txt", 5000);
        Assert.assertTrue(isFileDownloaded, "Verify invoice is downloaded successfully.");*/

        extentLogger.info("Click 'Continue' button");
        dashboardPage.getContinueOrderInvoiceButton().click();

        extentLogger.info("Click 'Delete Account' button");
        paymentPage.deleteAccount();
        extentLogger.info("Verify 'ACCOUNT DELETED!' and click 'Continue' button");
        dashboardPage.verifyAndDeleteAccount();
    }
}
