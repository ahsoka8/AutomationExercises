package com.example.tests;

import com.example.pages.CardPage;
import com.example.pages.LoginPage;
import com.example.pages.ProductDetailPage;
import com.example.utilities.BrowserUtils;
import com.example.utilities.ConfigurationReader;
import com.example.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TC13_VerifyProductQuantity extends TestBase {
    LoginPage loginPage;
    CardPage cardPage;
    ProductDetailPage productDetailPage;

    @Test
    public void test13() {
        loginPage = new LoginPage();
        cardPage = new CardPage();
        productDetailPage = new ProductDetailPage();

        extentLogger = report.createTest("Test Case 13: Verify Product quantity in Cart");
        extentLogger.info("navigate to" + ConfigurationReader.get("url"));
        extentLogger.info("Verify that home page is visible successfully");
        loginPage.verifyPageTitle();


        extentLogger.info(" Click 'View Product' for any product on home page");
        BrowserUtils.scrollToElement(cardPage.getViewProductLabel());
        cardPage.getViewProductLabel().click();

        extentLogger.info("Verify product detail is opened");
        BrowserUtils.waitFor(3);
        Assert.assertEquals(Driver.get().getTitle(), "Automation Exercise - Product Details", "Verify product detail is opened");

        extentLogger.info("Increase quantity to 4");
        productDetailPage.increaseQuantitiy("4");

        extentLogger.info("Click 'Add to cart' button");
        productDetailPage.getAddToCartButton().click();

        extentLogger.info("Click 'View Cart' button");
        productDetailPage.getViewCartLink().click();

        extentLogger.info("Verify that product is displayed in cart page with exact quantity");
        List<String> quantity =cardPage.getQuanties();
        Assert.assertEquals(quantity.get(0), "4", "Verify that product is displayed in cart page with exact quantity");


    }
}
