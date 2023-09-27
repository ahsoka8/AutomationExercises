package com.example.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FooterPage extends BasePage{

    @FindBy(xpath = "//h2[text()='Subscription']")
    private WebElement footer;

    @FindBy(id="susbscribe_email")
    private WebElement subscribeEmailInput;
    @FindBy(id="subscribe")
    private WebElement subscribeButton;


    @FindBy(css=".alert-success.alert")
    private WebElement subscribeMessage;

    public void subscribeEmail(String email){
        subscribeEmailInput.sendKeys(email);
        subscribeButton.click();

    }

    public String getSubscribeMessageText() {
        return subscribeMessage.getText();
    }




    public WebElement getFooter() {
        return footer;
    }


}
