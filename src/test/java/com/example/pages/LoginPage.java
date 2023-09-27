package com.example.pages;

import com.example.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//h2[text()='New User Signup!']")
    private WebElement newUserSignUpMessage;

    @FindBy(css = "input[name='name']")
    private WebElement signUpNameInput;

    @FindBy(css = "input[data-qa='signup-email']")
    private WebElement signUpEmailInput;

    @FindBy(xpath = "//button[text()='Signup']")
    private WebElement signUpButton;


    @FindBy(xpath = "//h2[contains(text(),'Login')]")
    private WebElement loginToYourAccountLabel;

    @FindBy(css = "[data-qa='login-email']")
    public WebElement loginEmail;

    @FindBy(css = "[data-qa='login-password']")
    private WebElement loginPassword;

    @FindBy(css = " [data-qa='login-button']")
    private WebElement loginButton;


    @FindBy(xpath = "//p[contains(text(), 'Your')]")
    private WebElement errorMessageLabel;

    @FindBy(xpath = "//p[contains(text(),'Email')]")
    private WebElement existAlreadyEmailMessage;


    public String getNewUserSignUpText() {
        return newUserSignUpMessage.getText();
    }

    public String getLoginText() {
        return loginToYourAccountLabel.getText();
    }

    public void signUp() {
        signUpNameInput.sendKeys(ConfigurationReader.get("sign_up_name"));
        signUpEmailInput.sendKeys(ConfigurationReader.get("sign_up_email"));
        signUpButton.click();
    }


    public void login() {
        loginEmail.sendKeys(ConfigurationReader.get("email"));
        loginPassword.sendKeys(ConfigurationReader.get("password"));
        loginButton.click();
    }

    public void loginWithIncorrect(String email, String password) {
        loginEmail.sendKeys(email);
        loginPassword.sendKeys(password);
        loginButton.click();
    }
    public void verifyAccountLabel (){
        String actualText = loginToYourAccountLabel.getText();
        Assert.assertEquals("Login to your account", actualText);
    }

    public void verifyErrorMessage (){
        String actualErrorText = errorMessageLabel.getText();
        String expectedErrorText = "Your email or password is incorrect!";
        Assert.assertEquals(expectedErrorText, actualErrorText);
    }


    public void verifyExistEmailMessage (){
        String actualMessage = existAlreadyEmailMessage.getText();
        String expectedMessage = "Email Address already exist!";
        Assert.assertEquals(expectedMessage, actualMessage);
    }

}
