package com.tmb.driver.factory.web.remote;

import com.tmb.driver.manager.web.remote.browserstack.BrowserStackChromeManager;
import com.tmb.driver.manager.web.remote.browserstack.BrowserStackFirefoxManager;
import com.tmb.enums.BrowserType;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class SauceLabFactory {

    private static final Map<BrowserType, Supplier<WebDriver>> MAP = new EnumMap<>(BrowserType.class);
    private static final Supplier<WebDriver> CHROME = () -> BrowserStackChromeManager.getDriver();
    private static final Supplier<WebDriver> FIREFOX = () -> BrowserStackChromeManager.getDriver();

    static {
        MAP.put(BrowserType.CHROME, CHROME);
        MAP.put(BrowserType.FIREFOX, FIREFOX);
    }

    //More simplified method using functional programming
    public static WebDriver getDriver(BrowserType browserType) {
        return MAP.get(browserType).get();
    }


    public static WebDriver getDriver1(BrowserType browserType) {
        return browserType == BrowserType.CHROME
                ? BrowserStackChromeManager.getDriver()
                : BrowserStackFirefoxManager.getDriver();
    }
}
