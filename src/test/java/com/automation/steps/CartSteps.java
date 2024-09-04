package com.automation.steps;

import com.automation.pages.CartPage;
import io.cucumber.java.en.Then;

public class CartSteps {

    CartPage cartPage = new CartPage();

    @Then("verify product is added into cart successfully")
    public void verifyProductIsAddedIntoCartSuccessfully() {
        cartPage.verifyProductIsAddedInToCart();
    }
}
