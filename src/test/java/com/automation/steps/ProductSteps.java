package com.automation.steps;

import com.automation.pages.ProductPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductSteps {

    ProductPage productPage = new ProductPage();


    @When("user clicks on first product")
    public void userClicksOnFirstProduct() {
        productPage.clickOnFirstProduct();
    }


    @Then("verify user is on products {string} page")
    public void verifyUserIsOnProductsPage(String productName) {
        Assert.assertTrue(productPage.verifyProductsAreDisplayed().contains(ConfigReader.getConfigValue(productName)));
    }

    @When("user clicks on filter button")
    public void userClicksOnFilterButton() {
        productPage.userClicksOnFilterBtn();
    }

    @And("selects the price range {string} {string}")
    public void selectsThePriceRange(String lowestPrice, String highestPrice) {
        productPage.userSelectsThePriceRange(lowestPrice, highestPrice);
    }

    @Then("verify products displayed are in specified price range {string} {string}")
    public void verifyProductsDisplayedAreInSpecifiedPriceRange(String lowestPrice, String highestPrice) {
        Assert.assertTrue(productPage.productsAreDisplayedInSpecifiedPriceRange(lowestPrice,highestPrice));
    }


    @And("selects the sorting type {string}")
    public void selectsTheSortingType(String sortingType) {
        productPage.userSelectsTheSortingType(sortingType);
    }

    @Then("verify products are sorted as specified {string}")
    public void verifyProductsAreSortedAsSpecified(String sortingType) {
        Assert.assertTrue(productPage.verifyProductsAreSortedAsSpecified(sortingType));
    }

    @Then("verify products are sorted from high discount to low discount")
    public void verifyProductsAreSortedFromHighDiscountToLowDiscount() {
        Assert.assertTrue(productPage.verifyProductsAreSortedFromHighDiscountToLowDiscount());
    }
}
