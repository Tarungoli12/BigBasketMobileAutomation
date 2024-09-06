package com.automation.pages;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_button']")
    WebElement allowBtn;

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.bigbasket.mobileapp:id/btn_login_signup']")
    WebElement loginOrSignUpBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Login/Signup']")
    WebElement loginText;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='com.bigbasket.mobileapp:id/textInputEmail']")
    WebElement mobileNumberField;

    @FindBy(xpath = "//android.widget.TextView[@text='CONTINUE']")
    WebElement continueBtn;

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.bigbasket.mobileapp:id/btn_select_location']")
    WebElement startShoppingBtn;

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.android.permissioncontroller:id/permission_allow_foreground_only_button']")
    WebElement whileUsingAppBtn;

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.bigbasket.mobileapp:id/btnUseThisLocation']")
    WebElement useThisLocationBtn;

    public void openApp() {
    }

    public boolean verifyLoginPageIsDisplayed() {
        return loginText.isDisplayed();
    }

    public void clickOnLoginButton() {
        loginOrSignUpBtn.click();
    }

    public boolean verifyAppIsOpened() {
        waitForElementToBeVisible(loginOrSignUpBtn);
        return loginOrSignUpBtn.isDisplayed();
    }

    public void enterMobileNumber() {
        mobileNumberField.sendKeys(ConfigReader.getConfigValue("user.mobileNumber"));
    }

    public void clickOnContinueButton() {
        continueBtn.click();
    }

    public void userClicksStartShoppingBtnAndSetsLocation() {
        startShoppingBtn.click();
        whileUsingAppBtn.click();
        DriverManager.explicitWaitUntilClickable(useThisLocationBtn);
        useThisLocationBtn.click();
    }
}
