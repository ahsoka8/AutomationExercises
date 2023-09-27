package com.example.pages;

import com.example.tests.TestBase;
import com.example.utilities.BrowserUtils;
import com.example.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ProductDetailPage extends BasePage {

    @FindBy(id = "quantity")
    private WebElement quantityInput;


    @FindBy(css = ".btn.btn-default.cart")
    private WebElement addToCartButton;


    @FindBy(xpath = "//u")
    private WebElement viewCartLink;


    @FindBy(css = "a[href='#reviews']")
    private WebElement writeYourReview;

    @FindBy(id = "name")
    private WebElement yourNameInput;

    @FindBy(id = "email")
    private WebElement emailAddress;

    @FindBy(id = "review")
    private WebElement addReviewHere;

    @FindBy(id = "button-review")
    private WebElement submitButton;

@FindBy(xpath = "//div[@class='alert-success alert']/span")
private WebElement succesMessage;
    public void fillReviewForm() {
        yourNameInput.sendKeys(ConfigurationReader.get("reviewName"));
        emailAddress.sendKeys(ConfigurationReader.get("reviewEmail"));
        addReviewHere.sendKeys(ConfigurationReader.get("addReviewHere"));
        submitButton.click();

    }

    public WebElement getWriteYourReview() {
        return writeYourReview;
    }

    public WebElement getViewCartLink() {
        return viewCartLink;
    }

    public void increaseQuantitiy(String quantity) {
        BrowserUtils.clearAndSendKeys(quantityInput, quantity);
    }

    public WebElement getAddToCartButton() {
        return addToCartButton;
    }

    public void verifySuccesMessage(){
        String actualMessage = succesMessage.getText();
        Assert.assertEquals(actualMessage,"Thank you for your review.");
    }

}
