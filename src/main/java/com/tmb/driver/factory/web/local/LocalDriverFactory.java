package com.tmb.driver.factory.web.local;

import com.tmb.config.converters.factory.ConfigFactory;
import com.tmb.driver.manager.web.local.ChromeManager;
import com.tmb.driver.manager.web.local.FirefoxManager;
import com.tmb.enums.BrowserType;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public final class LocalDriverFactory {



    private LocalDriverFactory() {
    }

    private static final Map<BrowserType, Supplier<WebDriver>> MAP = new EnumMap<>(BrowserType.class);
    private static final Supplier<WebDriver> CHROME = () -> ChromeManager.getDriver();
    private static final Supplier<WebDriver> FIREFOX = () -> FirefoxManager.getDriver();

    static {
        MAP.put(BrowserType.CHROME, CHROME);
        MAP.put(BrowserType.FIREFOX, FIREFOX);
    }

    //Method using functional programming
    public static WebDriver getDriver(BrowserType browserType) {
        return MAP.get(browserType).get();
    }



    //More simplified method
    public static WebDriver getDriver1(BrowserType browserType) {
     return isBrowserChrome(browserType)
             ? ChromeManager.getDriver()
             : FirefoxManager.getDriver();

    }

    private static boolean isBrowserChrome(BrowserType browserType) {
        return browserType == BrowserType.CHROME;
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
