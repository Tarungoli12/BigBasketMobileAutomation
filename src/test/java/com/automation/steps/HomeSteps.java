package com.automation.steps;

import com.automation.pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeSteps {

    HomePage homePage = new HomePage();

    @Then("verify user is on home page")
    public void verifyUserIsOnHomePage() {
        Assert.assertTrue(homePage.verifyHomePageIsDisplayed());
    }


    @When("user search for {string}")
    public void userSearchFor(String product) {
        homePage.searchForInSearchBar(product);
    }


}
