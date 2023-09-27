package com.example.pages;

import com.example.utilities.BrowserUtils;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class CardPage extends BasePage {

    @FindBy(css = "a[data-product-id='1']")
    private WebElement addToCartForFirstProduct;

    @FindBy(xpath = "//button[text()='Continue Shopping']")
    private WebElement continueShoppingButton;

    @FindBy(css = "a[data-product-id='2']")
    private WebElement addToCartForSecondProduct;


    @FindBy(xpath = "//u")
    private WebElement viewCardLink;



    @FindBy(xpath = "//td[contains(@class, 'cart_description')]//a")
    private List<WebElement> productName;

    @FindBy(xpath = "//td[contains(@class, 'cart_price')]/p")
    private List<WebElement> price;

    @FindBy(xpath = "//td[contains(@class, 'cart_quantity')]/button")
    private List<WebElement> quantity;

    @FindBy(xpath = "//p[contains(@class, 'cart_total_price')]")
    private List<WebElement> totalPrice;


    @FindBy(css = "a[href='/product_details/1']")
    private WebElement viewProductLabel;


    @FindBy(css = "li[class='active']")
    private WebElement shoppingCart;

    @FindBy(css = "a[class='btn btn-default check_out']")
    private WebElement proceedToCheckoutButton;

    @FindBy(xpath = "//u[contains(text(),'Login')]")
    private WebElement registerButton;

    @FindBy(css = "[name='message']")
    private WebElement textArea;

    @FindBy(xpath = "//a[contains(@class,'btn')]")
    private WebElement placeOrder;

    @FindBy(css = "a[data-product-id='1']")
    private WebElement xButton1;

    @FindBy(css = "a[data-product-id='2']")
    private WebElement xButton2;

   /* @FindBy(xpath = "//span[@id='empty_cart']//b")
    private WebElement emptyCartSpan;*/
    @FindBy(id = "empty_cart")
    private WebElement emptyCartSpan;

    @FindBy(css = "a[class='cart_quantity_delete']")
    private List<WebElement> xButtons;


    public WebElement getRegisterButton() {
        return registerButton;
    }

    public void textAreaFillUp() {
        BrowserUtils.scrollToElement(textArea);
        textArea.sendKeys("Order is done");
        BrowserUtils.scrollToElement(placeOrder);
        placeOrder.click();
    }

    public WebElement getProceedToCheckoutButton() {
        return proceedToCheckoutButton;
    }

    public WebElement getShoppingCart() {
        return shoppingCart;
    }

    public WebElement getViewProductLabel() {
        return viewProductLabel;
    }

    public WebElement getViewCardLink() {
        return viewCardLink;
    }

    public WebElement getAddToCartForFirstProduct() {
        return addToCartForFirstProduct;
    }

    public WebElement getContinueShoppingButton() {
        return continueShoppingButton;
    }

    public WebElement getAddToCartForSecondProduct() {
        return addToCartForSecondProduct;
    }

    public List<String> getProductsNames() {
        return productName
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<String> getPrices() {
        return price
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }


    public List<String> getQuanties() {
        return quantity
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<String> getTotalPrice() {
        return totalPrice
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }


    public void addProductsToCart() {
        BrowserUtils.scrollToElement(addToCartForFirstProduct);
        addToCartForFirstProduct.click();
        continueShoppingButton.click();
        addToCartForSecondProduct.click();
        viewCardLink.click();

    }

    public void xButtonClick() {
        xButton1.click();
        xButton2.click();
    }

    public String getEmptyCardSpanText() {
        BrowserUtils.waitForVisibility(emptyCartSpan,3);
        System.out.println("emptyCartSpan.getText() = " + emptyCartSpan.getText());
        return emptyCartSpan.getText();
    }

    public List<WebElement> getProductName() {
        return productName;
    }
  /*  private void clickCartButtonAndVerifyThatProductsAreVisibleInCart(@NotNull List<String> productsNames) {
        List<String> productsNamesAdded = new HomePage(getDriver())
                .cartButtonClick()
                .getProductsNames();
        for (int i = 0; i < productsNames.size(); i++) {
            Assert.assertEquals(productsNames.get(i), productsNamesAdded.get(i), "Verify that products are visible in cart");
            System.out.println("Search: " + productsNames.get(i) + " = Added: " + productsNamesAdded.get(i));
        }
    }*/


    public void verifyAllProductsVisibleInCart (){

        for (int i = 0; i < productName.size(); i++) {
            Assert.assertTrue(productName.get(i).isDisplayed());
            System.out.println("productsNames.get(i).getText() = " + productName.get(i).getText());
        }
    }
}
