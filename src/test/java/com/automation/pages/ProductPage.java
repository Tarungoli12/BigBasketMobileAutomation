package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends BasePage{

    @FindBy(xpath = "(//android.view.View[@content-desc='skuName'])[1]//android.view.View")
    WebElement firstProductName;

    @FindBy(xpath = "(//android.view.View[@content-desc='skuImage'])[1]")
    WebElement firstProduct;

    static String actualProductName;

    public String verifyProductsAreDisplayed() {
        actualProductName = firstProductName.getAttribute("content-desc");
        System.out.println(actualProductName);
        return firstProductName.getAttribute("content-desc");
    }


    public void clickOnFirstProduct() {
        firstProduct.click();
    }
}
