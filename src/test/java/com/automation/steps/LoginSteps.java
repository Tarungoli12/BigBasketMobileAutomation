package com.automation.steps;

import com.automation.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps {

    LoginPage loginPage = new LoginPage();

    @Given("user opens the app")
    public void user_opens_the_app() {
        loginPage.openApp();
    }

    @When("user clicks on login button")
    public void userClicksOnLoginButton() {
        loginPage.clickOnLoginButton();
    }

    @Then("verify user successfully opens the app")
    public void verifyUserSuccessfullyOpensTheApp() {
        Assert.assertTrue(loginPage.verifyAppIsOpened());
    }

    @And("click on continue button")
    public void clickOnContinueButton() {
        loginPage.clickOnContinueButton();
    }


    @When("user clicks start shopping button and sets location")
    public void userClicksStartShoppingButtonAndSetsLocation() {
        loginPage.userClicksStartShoppingBtnAndSetsLocation();
    }
}
