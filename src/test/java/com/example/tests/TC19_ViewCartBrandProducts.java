package com.example.tests;

import com.example.pages.DashboardPage;
import com.example.pages.ProductsPage;
import com.example.utilities.BrowserUtils;
import com.example.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class TC19_ViewCartBrandProducts extends TestBase {

    ProductsPage productsPage;
    DashboardPage dashboardPage;

    @Test
    public void test19() {
        dashboardPage = new DashboardPage();
        productsPage = new ProductsPage();


        extentLogger = report.createTest("Test Case 19: View & Cart Brand Products");
        extentLogger.info("navigate to" + ConfigurationReader.get("url"));
        extentLogger.info("Click on 'Products' button");
        productsPage.getProductButton().click();

        extentLogger.info("Verify that Brands are visible on left side bar");
        Assert.assertTrue(dashboardPage.getBrandsNameLabel().isDisplayed(), "Verify that Brands are visible on left side bar");
        BrowserUtils.waitFor(3);
        extentLogger.info("Click on any brand name");
        productsPage.poloBrandClick();

        extentLogger.info(" Verify that user is navigated to brand page and brand products are displayed");
        Assert.assertEquals(productsPage.getTitleTextCenter().getText(), "BRAND - POLO PRODUCTS");
        for (int i = 0; i < productsPage.getSearchResultsNames().size(); i++) {
            Assert.assertTrue(productsPage.getSearchResultsNames().get(i).isDisplayed());
        }

        extentLogger.info("On left side bar, click on any other brand link");
        BrowserUtils.scrollToElement(productsPage.getMadameBrand());
        productsPage.getMadameBrand().click();

        extentLogger.info("Verify that user is navigated to that brand page and can see products");
        Assert.assertEquals(productsPage.getTitleTextCenter().getText(), "BRAND - MADAME PRODUCTS");
        for (int i = 0; i < productsPage.getSearchResultsNames().size(); i++) {
            Assert.assertTrue(productsPage.getSearchResultsNames().get(i).isDisplayed());
        }


    }

}
