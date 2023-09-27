package com.example.tests;

import com.example.pages.CardPage;
import com.example.pages.DashboardPage;
import com.example.pages.LoginPage;
import com.example.pages.ProductsPage;
import com.example.utilities.BrowserUtils;
import com.example.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TC20_SearchProductsAndVerifyCartAfterLogin extends TestBase {
    ProductsPage productsPage;
    DashboardPage dashboardPage;
    LoginPage loginPage;
    CardPage cardPage;

    @Test
    public void test20() {
        dashboardPage = new DashboardPage();
        productsPage = new ProductsPage();
        cardPage = new CardPage();
        loginPage = new LoginPage();
        extentLogger = report.createTest("Test Case 20: Search Products and Verify Cart After Login");
        extentLogger.info("navigate to" + ConfigurationReader.get("url"));

        extentLogger.info("Click on 'Products' button");
        productsPage.getProductButton().click();
        BrowserUtils.waitFor(3);
        extentLogger.info("Verify user is navigated to ALL PRODUCTS page successfully");
        Assert.assertEquals(productsPage.getTitleTextCenter().getText(), "ALL PRODUCTS");
        extentLogger.info("Enter product name in search input and click search button");
        productsPage.searchProduct("Top");
        extentLogger.info("Verify 'SEARCHED PRODUCTS' is visible");
        Assert.assertEquals(productsPage.getTitleTextCenter().getText(), "SEARCHED PRODUCTS");
        extentLogger.info("Verify all the products related to search are visible");
        List<WebElement> products = productsPage.getSearchResultsNames();
        for (int i = 0; i < products.size(); i++) {
            Assert.assertTrue(products.get(i).isDisplayed());
        }
        extentLogger.info("Add those products to cart");
        productsPage.addAllProducts();

        extentLogger.info("Click 'Cart' button and verify that products are visible in cart");
        productsPage.getCartButton().click();
        cardPage.verifyAllProductsVisibleInCart();

        extentLogger.info("Click 'Signup / Login' button and submit login details");
        loginPage.clickLogin();
        loginPage.login();

        extentLogger.info("Again, go to Cart page");
        dashboardPage.getCartButton().click();


        extentLogger.info("Verify that those products are visible in cart after login as well");
        cardPage.verifyAllProductsVisibleInCart();

    }


}

