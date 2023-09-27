package com.example.pages;

import com.example.utilities.BrowserUtils;
import com.example.utilities.ConfigurationReader;
import com.example.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class DashboardPage extends BasePage {

    @FindBy(xpath = "//b[1]")
    private WebElement accountInfoLabel;


    @FindBy(id = "id_gender2")
    private WebElement titleCheckBox;

    @FindBy(id = "password")
    private WebElement passwordBox;

    @FindBy(id = "days")
    private WebElement dayOfBirth;

    @FindBy(id = "months")
    private WebElement monthOfBirth;

    @FindBy(id = "years")
    private WebElement yearOfBirth;

    @FindBy(id = "newsletter")
    private WebElement newsletterCheckbox;

    @FindBy(id = "optin")
    private WebElement specialOffersCheckbox;

    @FindBy(id = "first_name")
    private WebElement firstNameInput;

    @FindBy(id = "last_name")
    private WebElement lastNameInput;

    @FindBy(id = "company")
    private WebElement companyInput;

    @FindBy(id = "address1")
    private WebElement address1Input;

    @FindBy(id = "address2")
    private WebElement address2Input;

    @FindBy(id = "country")
    private WebElement countrySelect;

    @FindBy(id = "state")
    private WebElement stateInput;

    @FindBy(id = "city")
    private WebElement cityInput;

    @FindBy(id = "zipcode")
    private WebElement zipcodeInput;

    @FindBy(id = "mobile_number")
    private WebElement mobileNumberInput;

    @FindBy(css = "button[data-qa='create-account']")
    private WebElement createAccountButton;


    @FindBy(xpath = "//b")
    private WebElement createdAccount;

    @FindBy(xpath = "//a[text()='Continue']")
    private WebElement continueButton;

    @FindBy(css = "[data-qa='continue-button']")
    private WebElement continueDeleteButton;

    @FindBy(xpath = "//b")
    private WebElement deleteAccountLabel;


    @FindBy(id = "accordian")
    private WebElement categories;

/* @FindBy(xpath = "(//div[@id='accordian']//h4)[1]")
    private WebElement womenCategory;*/

    @FindBy(xpath = "//*[@id='accordian']/div[1]/div[1]/h4/a/span/i")
    private WebElement womenCategory;
    /* @FindBy(xpath = "(//div[@id='Women']//li)[1]")
     private WebElement dressCategory;*/
    @FindBy(css = "a[href='/category_products/1']")
    private WebElement dressCategory;


    @FindBy(css = ".brands-name")
    private WebElement brandsNameLabel;


    @FindBy(css = "div[class='recommended_items'] h2") //xpath ->//div[@class='recommended_items']/h2
    private WebElement recommendedItems;

    @FindBy(id = "address_delivery")
    private WebElement deliveryAddress;

    @FindBy(id = "address_invoice")
    private WebElement billingAddress;

    @FindBy(css="a[class='btn btn-default check_out']")
    private WebElement downloadInvoiceButton;



    @FindBy(css="a[class='btn btn-primary']")
    private WebElement continueOrderInvoiceButton;

    @FindBy(id = "scrollUp")
    private WebElement scrollUpButton;

    @FindBy(xpath = "//h2[contains(text(),'Full-Fledged')]")  // -> //section[1]/div/div/div/div/div/div[1]/div[1]/h2
    private WebElement fullFledgedPracticeWebsiteForAutomationEngineers;
// ->  (//h2[contains(text(),'Full-Fledged')])[1]

    public WebElement getFullFledgedPracticeWebsiteForAutomationEngineers() {
       BrowserUtils.waitForVisibility(fullFledgedPracticeWebsiteForAutomationEngineers,3);
        return fullFledgedPracticeWebsiteForAutomationEngineers;
    }

    public void clickScrollUpButton(){
        BrowserUtils.clickWithJS(scrollUpButton);
       // scrollUpButton.click();
    }
    public WebElement getContinueOrderInvoiceButton() {
        return continueOrderInvoiceButton;
    }
public String getDeliveryAddress(){
    return deliveryAddress.getText();
}

public String getBillingAddress(){
    return billingAddress.getText();
}
    WebDriverWait wait = new WebDriverWait(Driver.get(), 2);

    public WebElement getRecommendedItems() {
        return recommendedItems;
    }

    public WebElement getBrandsNameLabel() {
        return brandsNameLabel;
    }

    public WebElement getCategories() {
        return categories;
    }


    public WebElement getAccountInfoLabel() {
        return accountInfoLabel;
    }

    public void fillUpForm() {

        titleCheckBox.click();
        BrowserUtils.scrollToElement(passwordBox);
        String password = "pass" + BrowserUtils.generateCurrentDateAndTime();
        System.out.println("password = " + password);
        passwordBox.sendKeys(password);

        Select days = new Select(dayOfBirth);
        days.selectByIndex(11);

        Select months = new Select(monthOfBirth);
        months.selectByIndex(10);

        Select years = new Select(yearOfBirth);
        years.selectByValue("1983");

        newsletterCheckbox.click();
        //Receive special offers from our partners! - checkbox
        specialOffersCheckbox.click();
        BrowserUtils.scrollToElement(specialOffersCheckbox);
        //Address Information
        firstNameInput.sendKeys(ConfigurationReader.get("firstname"));
        lastNameInput.sendKeys(ConfigurationReader.get("lastname"));
        companyInput.sendKeys(ConfigurationReader.get("company"));
        address1Input.sendKeys(ConfigurationReader.get("adress1"));
        address2Input.sendKeys(ConfigurationReader.get("adress2"));

        Select country = new Select(countrySelect);
        country.selectByValue("United States");

        stateInput.sendKeys(ConfigurationReader.get("state"));
        cityInput.sendKeys(ConfigurationReader.get("city"));
        zipcodeInput.sendKeys(ConfigurationReader.get("zipcode"));
        mobileNumberInput.sendKeys(ConfigurationReader.get("mobilenummer"));

        BrowserUtils.scrollToElement(createAccountButton);
        createAccountButton.click();
    }

    public WebElement getCreatedAccount() {
        return createdAccount;
    }

    public WebElement getContinueButton() {
        return continueButton;
    }


    public void verifyAndDeleteAccount() {
        Assert.assertEquals(deleteAccountLabel.getText(), "ACCOUNT DELETED!");
        continueDeleteButton.click();
    }

    public void verifyCreatedAccount() {
        Assert.assertEquals(createdAccount.getText(), "ACCOUNT CREATED!");
        continueButton.click();
    }


    public void womenCategoryClick() {
        BrowserUtils.scrollToElement(womenCategory);
        wait.until(ExpectedConditions.elementToBeClickable(womenCategory));
        womenCategory.click();

    }

    public void dressCategoryClick() {
        wait.until(ExpectedConditions.elementToBeClickable(dressCategory));
        dressCategory.click();
    }





}
