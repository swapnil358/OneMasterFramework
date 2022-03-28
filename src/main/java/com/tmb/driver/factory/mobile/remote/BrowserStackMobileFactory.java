package com.tmb.driver.factory.mobile.remote;

import com.tmb.driver.manager.web.mobile.remote.BrowserStackAndroidManager;
import com.tmb.driver.manager.web.mobile.remote.BrowserStackIosManager;
import com.tmb.driver.manager.web.remote.browserstack.BrowserStackChromeManager;
import com.tmb.driver.manager.web.remote.browserstack.BrowserStackFirefoxManager;
import com.tmb.enums.BrowserType;
import com.tmb.enums.MobilePlatformType;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Supplier;

public class BrowserStackMobileFactory {

    private static final Map<MobilePlatformType, Supplier<WebDriver>> MAP = new EnumMap<>(MobilePlatformType.class);
    private static final Supplier<WebDriver> CHROME = () -> BrowserStackAndroidManager.getDriver();
    private static final Supplier<WebDriver> FIREFOX = () -> BrowserStackIosManager.getDriver();

    static {
        MAP.put(MobilePlatformType.ANDROID, CHROME);
        MAP.put(MobilePlatformType.IOS, FIREFOX);
    }

    //More simplified method using functional programming
    public static WebDriver getDriver(MobilePlatformType platformType) {
        return MAP.get(platformType).get();
    }


    public static WebDriver getDriver1(BrowserType browserType) {
        return browserType == BrowserType.CHROME
                ? BrowserStackChromeManager.getDriver()
                : BrowserStackFirefoxManager.getDriver();
    }
}
