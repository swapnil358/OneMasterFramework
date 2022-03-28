package com.tmb.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class CommonMethods {

    WebDriver driver;

    @FindBy(xpath = "//[class='abcd']")
    private WebElement eula;

    public void verifyDisplayed(String elementName) {
        WebElement elementToVerify = null;
        switch (elementName.toLowerCase()) {
            case "eula":
                elementToVerify = eula;
                break;
            default:
                Assert.fail(elementName + " is an invalid object name in log in screen");
                break;
        }
        Assert.assertTrue(elementToVerify.isDisplayed(), elementName + " is displayed");
    }


}
