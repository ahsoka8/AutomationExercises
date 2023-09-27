package com.example.tests;

import com.example.pages.*;
import com.example.utilities.BrowserUtils;
import com.example.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC18_ViewCategoryProducts extends TestBase {

    ProductsPage productsPage;
    DashboardPage dashboardPage;

    @Test
    public void test18() {
        dashboardPage = new DashboardPage();
        productsPage = new ProductsPage();



        extentLogger = report.createTest("Test Case 18: View Category Products");
        extentLogger.info("navigate to" + ConfigurationReader.get("url"));
        extentLogger.info("Verify that categories are visible on left side bar");

        Assert.assertTrue(dashboardPage.getCategories().isDisplayed(), "Verify that categories are visible on left side bar");

        extentLogger.info("Click on 'Women' category");
        dashboardPage.womenCategoryClick();

        extentLogger.info("Click on any category link under 'Women' category, for example: Dress");
        dashboardPage.dressCategoryClick();

        extentLogger.info("Verify that category page is displayed and confirm text 'WOMEN - TOPS PRODUCTS");
        BrowserUtils.waitFor(3);
        Assert.assertEquals(productsPage.getTitleTextCenter().getText(), "WOMEN - DRESS PRODUCTS", "Verify that category page is displayed and confirm text 'WOMEN - DRESS PRODUCTS'");


        extentLogger.info("On left side bar, click on any sub-category link of 'Men' category");
        productsPage.getMenCategory().click();
        productsPage.gettShirtsCategory().click();

        extentLogger.info("Verify that user is navigated to that category page");
        Assert.assertEquals(productsPage.getTitleTextCenter().getText(), "MEN - TSHIRTS PRODUCTS", "Verify that user is navigated to that category page");


    }
}