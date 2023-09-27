package com.example.tests;

import com.example.pages.DashboardPage;
import com.example.pages.FooterPage;
import com.example.pages.LoginPage;
import com.example.utilities.BrowserUtils;
import com.example.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC25_VerifyScrollUp extends TestBase{
    LoginPage loginPage;
    FooterPage footerPage;
    DashboardPage dashboardPage;

    @Test
    public void test25() {
        loginPage = new LoginPage();
        footerPage = new FooterPage();
        dashboardPage=new DashboardPage();

        extentLogger = report.createTest("Test Case 25: Verify Scroll Up using 'Arrow' button and Scroll Down functionality");
        extentLogger.info("navigate to" + ConfigurationReader.get("url"));
        extentLogger.info("Verify that home page is visible successfully");
        loginPage.verifyPageTitle();

        extentLogger.info("Scroll down page to bottom");
        BrowserUtils.scrollToElement(footerPage.getFooter());
        extentLogger.info("Verify text 'SUBSCRIPTION'");
        Assert.assertEquals(footerPage.getFooter().getText(), "SUBSCRIPTION", "Verify text 'SUBSCRIPTION'");

        extentLogger.info("Click on arrow at bottom right side to move upward");
        dashboardPage.clickScrollUpButton();
extentLogger.info("Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen");
        Assert.assertTrue(dashboardPage.getFullFledgedPracticeWebsiteForAutomationEngineers().isDisplayed(), "Verify that 'Full-Fledged practice website for Automation Engineers' text is visible on screen");
    }
}
