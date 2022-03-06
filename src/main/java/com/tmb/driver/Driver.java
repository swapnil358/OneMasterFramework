package com.tmb.driver;

import org.openqa.selenium.WebDriver;

public class Driver {



    public static void initDriver(){

        WebDriver driver = LocalDriverFactory.getDriver();
        driver.get("https://google.co.in");

    }


    public static void quitDriver() {

    }
}