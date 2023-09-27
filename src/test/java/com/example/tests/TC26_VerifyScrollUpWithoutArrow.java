package com.example.tests;

import com.example.pages.DashboardPage;
import com.example.pages.FooterPage;
import com.example.pages.LoginPage;
import com.example.utilities.BrowserUtils;
import com.example.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC26_VerifyScrollUpWithoutArrow extends TestBase{
    LoginPage loginPage;
    FooterPage footerPage;
    DashboardPage dashboardPage;

    @Test
    public void test26() {
        loginPage = new LoginPage();
        footerPage = new FooterPage();
        dashboardPage = new DashboardPage();

        extentLogger = report.createTest("Test Case 26: Verify Scroll Up without 'Arrow' button and Scroll Down functionality");
        extentLogger.info("navigate to" + ConfigurationReader.get("url"));
        extentLogger.info("Verify that home page is visible successfully");
        loginPage.verifyPageTitle();

        extentLogger.info("Scroll down page to bottom");
        BrowserUtils.scrollToElement(footerPage.getFooter());
        extentLogger.info("Verify text 'SUBSCRIPTION'");
        Assert.assertEquals(footerPage.getFooter().getText(), "SUBSCRIPTION", "Verify text 'SUBSCRIPTION'");

        extentLogger.info("Scroll up page to top");
        BrowserUtils.waitFor(3);
        BrowserUtils.scrollToElement(dashboardPage.getFullFledgedPracticeWebsiteForAutomationEngineers());

        extentLogger.info("Verify that page is scrolled up and 'Full-Fledged practice website for Automation Engineers' text is visible on screen");
        Assert.assertTrue(dashboardPage.getFullFledgedPracticeWebsiteForAutomationEngineers().isDisplayed(), "Verify that 'Full-Fledged practice website for Automation Engineers' text is visible on screen");
        System.out.println("dashboardPage.getFullFledgedPracticeWebsiteForAutomationEngineers().getText() = " + dashboardPage.getFullFledgedPracticeWebsiteForAutomationEngineers().getText());

    }
}
