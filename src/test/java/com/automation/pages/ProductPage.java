package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductPage extends BasePage{

    @FindBy(xpath = "(//android.view.View[@content-desc='skuName'])[1]//android.view.View")
    WebElement firstProductName;

    @FindBy(xpath = "(//android.view.View[@content-desc='skuImage'])[1]")
    WebElement firstProduct;

    @FindBy(xpath = "//android.view.View[@content-desc='filterButton']")
    WebElement filterBtn;

    @FindBy(xpath = "//android.view.View[@content-desc='Price']")
    WebElement priceFilterDropDown;

    @FindBy(xpath = "//android.view.View[@content-desc='DONE']")
    WebElement doneBtn;

    @FindBy(xpath = "//android.view.View[@content-desc='productSellingPrice']/android.view.View")
    List<WebElement> productPrices;

    @FindBy(xpath = "//android.view.View[@content-desc='Sort By']")
    WebElement sortByDropDown;

    @FindBy(xpath = "//android.view.View[@content-desc='offerTag']//android.view.View")
    List<WebElement> productDiscounts;

    static String actualProductName;

    public String verifyProductsAreDisplayed() {
        actualProductName = firstProductName.getAttribute("content-desc");
        return firstProductName.getAttribute("content-desc");
    }


    public void clickOnFirstProduct() {
        firstProduct.click();
    }

    public void userClicksOnFilterBtn() {
        filterBtn.click();
    }

    public void userSelectsThePriceRange(String lowestPrice, String highestPrice) {
        priceFilterDropDown.click();
        driver.findElement(By.xpath("//android.view.View[@content-desc='Rs " + lowestPrice + " to Rs " + highestPrice + "']/android.widget.CheckBox")).click();
        doneBtn.click();
    }

    public boolean productsAreDisplayedInSpecifiedPriceRange(String lowestPrice, String highestPrice) {
        int count = 0;
        for(WebElement element : productPrices){
            String priceText = element.getAttribute("content-desc");
            System.out.println(priceText);
            double price = Double.parseDouble(priceText.substring(1));
            System.out.println(price);
            if(price >= Integer.parseInt(lowestPrice) && price <= Integer.parseInt(highestPrice)){
                count++;
            }
        }
        if(count==productPrices.size()){
            return true;
        }
        return false;
    }

    public void userSelectsTheSortingType(String sortingType) {
        sortByDropDown.click();
        driver.findElement(By.xpath("//android.view.View[@content-desc='" + sortingType + "']")).click();
        doneBtn.click();
    }

    public boolean verifyProductsAreSortedAsSpecified(String sortingType) {
        List<Double> nonFilterPrices = new ArrayList<>();
        List<Double> filterPrices;
        for(int i = 0; i<=1; i++) {
            for (WebElement element : productPrices) {
                String priceText = element.getAttribute("content-desc");
                System.out.println(priceText);
                double price = Double.parseDouble(priceText.substring(1));
                nonFilterPrices.add(price);
            }
            scrollOrSwipe();
        }


        filterPrices = new ArrayList<>(nonFilterPrices);
        Collections.sort(filterPrices);

        if(sortingType.equals("Price - High to Low")) Collections.reverse(nonFilterPrices);
        System.out.println(nonFilterPrices);
        System.out.println(filterPrices);
        if(filterPrices.equals(nonFilterPrices)){
            return true;
        }

        return false;
    }

    public boolean verifyProductsAreSortedFromHighDiscountToLowDiscount() {
        List<Double> nonFilterPrices = new ArrayList<>();
        List<Double> filterPrices;
        for(int i = 0; i<=1; i++) {
            for (WebElement element : productDiscounts) {
                String discountText = element.getAttribute("content-desc");
                System.out.println(discountText);
                double discount = Double.parseDouble(discountText.substring(0,2));
                nonFilterPrices.add(discount);
            }
            scrollOrSwipe();
        }


        filterPrices = new ArrayList<>(nonFilterPrices);
        Collections.sort(filterPrices,Collections.reverseOrder());

        System.out.println(nonFilterPrices);
        System.out.println(filterPrices);
        if(filterPrices.equals(nonFilterPrices)){
            return true;
        }

        return false;
    }

}
