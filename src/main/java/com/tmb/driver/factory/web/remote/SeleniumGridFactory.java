package com.tmb.driver.factory.web.remote;

import com.tmb.driver.manager.web.remote.selenium.SeleniumGridChromeManager;
import com.tmb.driver.manager.web.remote.selenium.SeleniumGridFirefoxManager;
import com.tmb.enums.BrowserType;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class SeleniumGridFactory {

    public final static Map<BrowserType, Supplier<WebDriver>> MAP = new EnumMap<>(BrowserType.class);
    public final static Supplier<WebDriver> CHROME = () -> SeleniumGridChromeManager.getDriver();
    public final static Supplier<WebDriver> FIREFOX = () -> SeleniumGridChromeManager.getDriver();

    static {
        MAP.put(BrowserType.CHROME, CHROME);
        MAP.put(BrowserType.FIREFOX, FIREFOX);
    }

    private SeleniumGridFactory() {

    }

    //More Simplified method using functional programming
    public static WebDriver getDriver(BrowserType browserType) {
        return MAP.get(browserType).get();
    }


    public static WebDriver getDriver1(BrowserType browserType) {
        return browserType == BrowserType.CHROME
                ? SeleniumGridChromeManager.getDriver()
                : SeleniumGridFirefoxManager.getDriver();
    }

}
