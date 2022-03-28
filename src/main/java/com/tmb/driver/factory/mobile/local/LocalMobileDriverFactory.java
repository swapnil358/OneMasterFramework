package com.tmb.driver.factory.mobile.local;

import com.tmb.config.converters.factory.ConfigFactory;
import com.tmb.driver.manager.web.local.ChromeManager;
import com.tmb.driver.manager.web.local.FirefoxManager;
import com.tmb.driver.manager.web.mobile.local.AndroidManager;
import com.tmb.driver.manager.web.mobile.local.IosManager;
import com.tmb.enums.BrowserType;
import com.tmb.enums.MobilePlatformType;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public final class LocalMobileDriverFactory {



    private LocalMobileDriverFactory() {
    }

    private static final Map<MobilePlatformType, Supplier<WebDriver>> MAP = new EnumMap<>(MobilePlatformType.class);
    private static final Supplier<WebDriver> CHROME = () -> AndroidManager.getDriver();
    private static final Supplier<WebDriver> FIREFOX = () -> IosManager.getDriver();

    static {
        MAP.put(MobilePlatformType.ANDROID, CHROME);
        MAP.put(MobilePlatformType.IOS, FIREFOX);
    }

    //Method using functional programming
    public static WebDriver getDriver(MobilePlatformType platformType) {
        return MAP.get(platformType).get();
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
