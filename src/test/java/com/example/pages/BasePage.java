package com.example.pages;

import com.example.utilities.ConfigurationReader;
import com.example.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public abstract class BasePage {

    public BasePage() {
        PageFactory.initElements(Driver.get(), this);
    }



    @FindBy(xpath = "//a[@href='/login']")
    private WebElement loginLabel;


    @FindBy(xpath = "//ul[@class='nav navbar-nav']//li[10]") //.nav.navbar-nav>li:nth-of-type(10)
    private WebElement loginAsUsername;

    @FindBy(xpath = "//a[text()=' Delete Account']")
    private WebElement deleteAccountLabel;



    @FindBy(xpath = "//ul[@class='nav navbar-nav']//li[4]")
    private WebElement logoutButton;



    @FindBy(xpath = "//ul[@class='nav navbar-nav']//li[8]")
    private WebElement contactUsButton;



    @FindBy(xpath = "//ul[@class='nav navbar-nav']/li[5]")
    private WebElement testCases;


    @FindBy(xpath = "//ul[@class='nav navbar-nav']/li[2]")
    private WebElement productButton;


    @FindBy(xpath = "//ul[@class='nav navbar-nav']/li[3]")
    private WebElement cartButton;

    public WebElement getCartButton() {
        return cartButton;
    }
    public WebElement getProductButton() {
        return productButton;
    }

    public WebElement getTestCases() {
        return testCases;
    }
    public WebElement getContactUsButton() {
        return contactUsButton;
    }

public void clickLogin(){
    loginLabel.click();
    }


public WebElement getLoginAsUsername(){
    return loginAsUsername;
}

public void deleteAccount(){
    deleteAccountLabel.click();
}

public void verifyPageTitle (){
    String expectedTitle = "Automation Exercise";
    String actualTitle = Driver.get().getTitle();
    Assert.assertEquals(actualTitle,expectedTitle);

}

public void verifyLoginUsername (){
    String actualLoginUsernameText = loginAsUsername.getText();
    String expectedLoginUsernameText = "Logged in as "+ ConfigurationReader.get("name");
    Assert.assertEquals(actualLoginUsernameText, expectedLoginUsernameText);
}

    public void verifyLoginUsername2 (){
        String actualLoginUsernameText = loginAsUsername.getText();
        String expectedLoginUsernameText = "Logged in as "+ ConfigurationReader.get("loginname");
        Assert.assertEquals(actualLoginUsernameText,expectedLoginUsernameText);
    }

    public WebElement getLogoutButton() {
        return logoutButton;
    }

}
