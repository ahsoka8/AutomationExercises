package com.example.pages;

import com.example.utilities.BrowserUtils;
import com.example.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class ProductsPage extends BasePage {

    @FindBy(id = "search_product")
    private WebElement searchProductInput;

    @FindBy(id = "submit_search")
    private WebElement submitSearchButton;

    @FindBy(css = "h2.title")
    private WebElement searchedProductsLabel;


    @FindBy(xpath = "//div[contains(@class, 'productinfo text-center')]//p")
    private List<WebElement> searchResultsNames;

    @FindBy(css = ".title.text-center")
    private WebElement titleTextCenter;


    @FindBy(css = "a[href='#Men']") //xpath -> (//div[@id='accordian']//h4)[2]
    private WebElement menCategory;

    @FindBy(css = "a[href='/category_products/3']")
    private WebElement tShirtsCategory;


    @FindBy(css = "a[href='/brand_products/Polo']")
    private WebElement poloBrand;


    @FindBy(css = "a[href='/brand_products/Madame']")
    private WebElement madameBrand;

    @FindBy(css = "a[class='btn btn-default add-to-cart']")
    List<WebElement> addButtons;

    @FindBy(css = "button[data-dismiss='modal']")
    private WebElement continueShoppingButton;



    @FindBy(css = "a[href='/product_details/1']")
    private WebElement viewProductOfFirstProductButton;

    public WebElement getViewProductOfFirstProductButton() {
        return viewProductOfFirstProductButton;
    }
    public WebElement getMadameBrand() {
        return madameBrand;
    }

    public WebElement getPoloBrand() {
        return poloBrand;
    }

    public WebElement gettShirtsCategory() {
        return tShirtsCategory;
    }

    public WebElement getMenCategory() {
        return menCategory;
    }

    public String getSearchedProductsText() {
        return searchedProductsLabel.getText();
    }

    public void searchProduct(String product) {

        searchProductInput.sendKeys(product);
        submitSearchButton.click();
    }

    public List<String> getProductsSearchNames() {
        return searchResultsNames
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public WebElement getTitleTextCenter() {
        return titleTextCenter;
    }

    public void poloBrandClick() {
        BrowserUtils.scrollToElement(poloBrand);
        poloBrand.click();
    }

    public List<WebElement> getSearchResultsNames() {
        return searchResultsNames;
    }

    public void addAllProducts() {
        WebDriverWait wait = new WebDriverWait(Driver.get(), 3);
        Actions actions=new Actions(Driver.get());

        for (int i = 0; i < addButtons.size(); i=i+2) {

            BrowserUtils.scrollToElement(addButtons.get(i));
            actions.moveToElement(addButtons.get(i)).perform();
        // wait.until(ExpectedConditions.elementToBeClickable(addButtons.get(i)));
            addButtons.get(i).click();
            wait.until(ExpectedConditions.elementToBeClickable(continueShoppingButton));
            continueShoppingButton.click();
        }
    }


}
