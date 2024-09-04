package com.automation.steps;

import com.automation.pages.ProductPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductSteps {

    ProductPage productPage = new ProductPage();

    @Then("verify user is on products page")
    public void verifyUserIsOnProductsPage() {
        Assert.assertTrue(productPage.verifyProductsAreDisplayed().contains("Tea"));
    }

    @When("user clicks on first product")
    public void userClicksOnFirstProduct() {
        productPage.clickOnFirstProduct();
    }


}
