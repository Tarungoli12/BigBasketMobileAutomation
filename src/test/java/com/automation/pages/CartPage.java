package com.automation.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends BasePage{

    @FindBy(xpath = "//android.view.View[@content-desc='basketButtonToolBar']")
    WebElement cartIcon;

    public void verifyProductIsAddedInToCart() {
        cartIcon.click();
        String expectedProductPrice = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.bigbasket.mobileapp:id/txtProductDesc']")).getText();
        System.out.println(expectedProductPrice);
        Assert.assertTrue(expectedProductPrice.contains(ProductPage.actualProductName));
    }


}
