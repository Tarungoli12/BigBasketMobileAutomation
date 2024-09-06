package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDescriptionPage extends BasePage{

    @FindBy(xpath = "//android.widget.Button[@content-desc='AddButtonProduct']")
    WebElement addToBasketButton;

    public boolean verifyProductDescriptionPageIsDisplayed() {
        return addToBasketButton.isDisplayed();
    }

    public void clickOnAddToCartButton() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        addToBasketButton.click();
    }
}
