package com.example.pages;

import com.example.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class CheckoutPage extends BasePage{

    @FindBy(xpath = "//h2[contains(text(),'Address')]")
    private WebElement addressDetailsLabel;

    @FindBy(xpath = " //h2[contains(text(),'Review')]")
    private WebElement reviewYourOrderLabel;

    @FindBy(xpath = "//ul[contains(@id, 'address_delivery')]//li")
    private List<WebElement> addressDelivery;

    @FindBy(xpath = "//ul[contains(@id, 'address_invoice')]//li")
    private List<WebElement> addressInvoice;

    public List<String> getAddressDelivery(){
        return addressDelivery
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<String> getAddressInvoice(){
        return addressInvoice
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }


    public  void verifyAddressDetails1()  {


        Assert.assertEquals(getAddressDelivery().get(0), "YOUR DELIVERY ADDRESS", "Verify Address Details");
        Assert.assertEquals(getAddressInvoice().get(0), "YOUR BILLING ADDRESS", "Verify Address Details");

        for (int i = 1; i < 8; i++) {
            Assert.assertEquals(getAddressDelivery().get(i), getAddressInvoice().get(i), "Verify Address Details");
        }

        String no1 = "Mrs. " + ConfigurationReader.get("firstname") + " " + ConfigurationReader.get("lastname");
        String no2 = ConfigurationReader.get("company");
        String no3 =  ConfigurationReader.get("adress1");
        String no4 =  ConfigurationReader.get("adress2");
        String no5 = ConfigurationReader.get("city") + " " + ConfigurationReader.get("state") + " " + ConfigurationReader.get("zipcode");
        String no6 = ConfigurationReader.get("country");
        String no7 = ConfigurationReader.get("mobilenummer");

        Assert.assertEquals(getAddressDelivery().get(1), no1, "Verify Address Details");
        Assert.assertEquals(getAddressDelivery().get(2), no2, "Verify Address Details");
        Assert.assertEquals(getAddressDelivery().get(3), no3, "Verify Address Details");
        Assert.assertEquals(getAddressDelivery().get(4), no4, "Verify Address Details");
        Assert.assertEquals(getAddressDelivery().get(5), no5, "Verify Address Details");
        Assert.assertEquals(getAddressDelivery().get(6), no6, "Verify Address Details");
        Assert.assertEquals(getAddressDelivery().get(7), no7, "Verify Address Details");
    }

    public void verifyAddressDetails(){
        Assert.assertTrue(addressDetailsLabel.isDisplayed());
    }
    public void verifyReviewYourOrder(){
        Assert.assertTrue(reviewYourOrderLabel.isDisplayed());
    }
}
