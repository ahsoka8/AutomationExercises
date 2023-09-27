package com.example.pages;

import com.example.utilities.BrowserUtils;
import com.example.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ContactUsPage extends BasePage {
    @FindBy(xpath = "//div[@class='contact-form']//h2")  //css -> h2.title:nth-child(2)
    private WebElement getInTouchLabel;

    @FindBy(name = "name")
    private WebElement nameInput;

    @FindBy(name = "email")
    private WebElement emailInput;

    @FindBy(name = "subject")
    private WebElement subjectInput;

    @FindBy(id = "message")
    private WebElement messageInput;

    @FindBy(name = "upload_file")
    private WebElement uploadFileInput;

    @FindBy(name = "submit")
    private WebElement submitButton;


    @FindBy(css = ".status.alert.alert-success") //  css ->  div[class^='status']
    private WebElement alertSuccess;



    @FindBy(xpath = "//a[@class='btn btn-success']")
    private WebElement homePageButton;

    public WebElement getHomePageButton() {
        return homePageButton;
    }

    public WebElement getAlertSuccess() {
        return alertSuccess;
    }

    public void verifyGetInTouch() {
        String expectedMessage = "GET IN TOUCH";
        String actualMessage = getInTouchLabel.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
    }


    public void fillForm() {
        nameInput.sendKeys("leia");
        emailInput.sendKeys("leia@gmail.com");
        subjectInput.sendKeys("subject");
        messageInput.sendKeys("Leia was here");

        String projectPath = System.getProperty("user.dir");
        String filePath = "src/test/resources/hello";
        String fullPath = projectPath + "/" + filePath;
        uploadFileInput.sendKeys(fullPath);
        BrowserUtils.scrollToElement(submitButton);
        submitButton.click();

    }

    public void okButtonClick() {
        Alert alert = Driver.get().switchTo().alert();
        alert.accept();
    }


}
