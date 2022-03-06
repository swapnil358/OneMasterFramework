package com.tmb.driver;

import com.tmb.config.ConfigFactory;
import com.tmb.driver.manager.ChromeManager;
import com.tmb.driver.manager.FirefoxManager;
import com.tmb.enums.BrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.event.FocusAdapter;

public class LocalDriverFactory {


    private LocalDriverFactory() {
    }

    public static WebDriver getDriver() {
        WebDriver driver = null;
        if (ConfigFactory.getConfig().browser() == BrowserType.CHROME) {
            driver = ChromeManager.getDriver();
        } else {
            driver = FirefoxManager.getDriver();
        }
        return driver;
    }

}
