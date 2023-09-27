package com.example.tests;

import com.example.pages.CardPage;
import com.example.pages.FooterPage;
import com.example.pages.LoginPage;
import com.example.utilities.BrowserUtils;
import com.example.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TC12_AddProductsInCart extends TestBase {

    LoginPage loginPage;
    CardPage cardPage;


    @Test
    public void test12() {
        loginPage = new LoginPage();
        cardPage = new CardPage();

        extentLogger = report.createTest("Test Case 12: Add Products in Cart");
        extentLogger.info("navigate to" + ConfigurationReader.get("url"));
        extentLogger.info("Verify that home page is visible successfully");
        loginPage.verifyPageTitle();

        extentLogger.info("Click on 'Products' button");
        loginPage.getProductButton().click();
        BrowserUtils.waitFor(3);
        BrowserUtils.scrollToElement(cardPage.getAddToCartForFirstProduct());

        extentLogger.info(" Hover over first product and click 'Add to cart'");
        actions.moveToElement(cardPage.getAddToCartForFirstProduct()).perform();
        cardPage.getAddToCartForFirstProduct().click();

        extentLogger.info("Click 'Continue Shopping' button");
        cardPage.getContinueShoppingButton().click();

        extentLogger.info("Hover over second product and click 'Add to cart'");
        actions.moveToElement(cardPage.getAddToCartForSecondProduct()).perform();
        cardPage.getAddToCartForSecondProduct().click();

        extentLogger.info(" Click 'View Cart' button");
        cardPage.getViewCardLink().click();

        extentLogger.info("Verify both products are added to Cart");
        Assert.assertEquals(cardPage.getProductsNames().size(), 2, "Verify both products are added to Cart");

        extentLogger.info("Verify their prices, quantity and total price");
        List<String> prices = cardPage.getPrices();
        List<String> quantity = cardPage.getQuanties();
        List<String> totalPrices = cardPage.getTotalPrice();

        for (int i = 0; i < 2; i++) {
            Assert.assertEquals(totalPrices.get(i), prices.get(i), "Verify their prices and total price");
            Assert.assertEquals(quantity.get(i), "1", "Verify their quantity");
            System.out.println(i + ". Prices = Total Prices | " + prices.get(i) + " = " + totalPrices.get(i));
            System.out.println(i + ". Quantity = 1 | " + quantity.get(i).equals("1"));
        }


    }
}
