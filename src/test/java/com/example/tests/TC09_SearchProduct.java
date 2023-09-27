package com.example.tests;

import com.example.pages.LoginPage;
import com.example.pages.ProductsPage;
import com.example.utilities.BrowserUtils;
import com.example.utilities.ConfigurationReader;
import com.example.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TC09_SearchProduct extends TestBase {

    LoginPage loginPage;
    ProductsPage productsPage;

    @Test
    public void test09() {
        loginPage = new LoginPage();
        productsPage= new ProductsPage();

        extentLogger = report.createTest("Test Case 9: Search Product");
        extentLogger.info("navigate to" + ConfigurationReader.get("url"));
        extentLogger.info("Verify that home page is visible successfully");
        loginPage.verifyPageTitle();

        extentLogger.info("Click on 'Products' button");
        loginPage.getProductButton().click();
        BrowserUtils.waitFor(3);

        extentLogger.info("Verify user is navigated to ALL PRODUCTS page successfully");
        String expectedUrl = "https://automationexercise.com/products";
        String currentUrl = Driver.get().getCurrentUrl();
        Assert.assertEquals(expectedUrl, currentUrl);

        extentLogger.info("Enter product name in search input and click search button");
        String search= "T-Shirt";
        productsPage.searchProduct(search);

        extentLogger.info("Verify 'SEARCHED PRODUCTS' is visible");
        Assert.assertEquals("SEARCHED PRODUCTS", productsPage.getSearchedProductsText());

        extentLogger.info(" Verify all the products related to search are visible");
        List<String> productsNames = productsPage.getProductsSearchNames() ;
        for (int i = 0; i < productsNames.size(); i++) {
            Assert.assertTrue(productsNames.get(i).toLowerCase().contains(search.toLowerCase()));
            System.out.println(i + ". " + productsNames.get(i) + " - contains: " + search);
        }




    }




}