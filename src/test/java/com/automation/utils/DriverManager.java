package com.automation.utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DriverManager {
    static WebDriver driver;
    static WebDriverWait wait;

    public static void createDriver(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName",ConfigReader.getConfigValue("platform.name"));
        capabilities.setCapability("deviceName",ConfigReader.getConfigValue("device.name"));
        capabilities.setCapability("automationName",ConfigReader.getConfigValue("automation.name"));
        capabilities.setCapability("app",ConfigReader.getConfigValue("app.path"));
        capabilities.setCapability("appActivity",ConfigReader.getConfigValue("app.activity"));
        capabilities.setCapability("appPackage",ConfigReader.getConfigValue("app.package"));
        driver = new AndroidDriver(capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        wait = new WebDriverWait(driver,Duration.ofSeconds(60));
    }
    public static void explicitWaitUntilClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public static WebDriver getDriver(){
        return driver;
    }
}
