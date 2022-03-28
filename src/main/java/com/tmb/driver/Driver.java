package com.tmb.driver;

import com.tmb.driver.factory.web.local.LocalDriverFactory;
import org.openqa.selenium.WebDriver;

public class Driver {



    public static void initDriver(){

        WebDriver driver = LocalDriverFactory.getDriver();
        driver.get("https://google.co.in");

    }


    public static void quitDriver() {

    }
}