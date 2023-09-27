package com.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class PaymentPage extends BasePage{

    @FindBy(css = "input[data-qa='name-on-card']")
    private WebElement nameOnCardInput;

    @FindBy(css = "input[data-qa='card-number']")
    private WebElement cardNumberInput;

    @FindBy(css = "input[data-qa='cvc']")
    private WebElement cvcInput;

    @FindBy(css = "input[data-qa='expiry-month']")
    private WebElement expirationMonthInput;

    @FindBy(css = "input[data-qa='expiry-year']")
    private WebElement expirationYearInput;

    @FindBy(css = "button[data-qa='pay-button']")
    private WebElement payAndConfirmOrderButton;

    @FindBy(css = "div[class='col-sm-9 col-sm-offset-1'] p")
    private WebElement successMessage;




    @FindBy(xpath = "//div[contains(@id, 'success_message')]/div") //correct xpath but unable to locate an element
    private WebElement alertSuccess;

    public WebElement getSuccessMessage() {
        return successMessage;
    }
    public void fillPaymentDetails() {
        nameOnCardInput.sendKeys("dhgf");
        cardNumberInput.sendKeys("123456");
        cvcInput.sendKeys("123");
        expirationMonthInput.sendKeys("12");
        expirationYearInput.sendKeys("2025");
        payAndConfirmOrderButton.click();

    }


    public String getAlertSuccessText() {
        return alertSuccess.getText();
    }

    public WebElement getAlertSuccess() {
        return alertSuccess;
    }
}
