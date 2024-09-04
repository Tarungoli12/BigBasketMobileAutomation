package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

    @FindBy(xpath = "//android.view.View[@content-desc='searchBox']")
    WebElement searchBar;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='com.bigbasket.mobileapp:id/searchView']")
    WebElement searchProducts;

    public boolean verifyHomePageIsDisplayed() {
        waitForElementToBeVisible(searchBar);
        return searchBar.isDisplayed();
    }

    public void searchForInSearchBar(String product) {
        searchBar.click();
        searchProducts.sendKeys(product);
        driver.findElement(By.xpath(String.format("//android.widget.TextView[@text='%s']",product))).click();
    }
}