package com.tmb.driver.factory.mobile.remote;

import com.tmb.driver.factory.web.remote.BrowserStackFactory;
import com.tmb.driver.factory.web.remote.SeleniumGridFactory;
import com.tmb.driver.factory.web.remote.SelenoidFactory;
import com.tmb.enums.BrowserRemoteModeType;
import com.tmb.enums.BrowserType;
import com.tmb.enums.MobilePlatformType;
import com.tmb.enums.MobileRemoteModeType;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;

public final class RemoteMobileDriverFactory {

    private RemoteMobileDriverFactory() {
    }

    private static final Map<MobileRemoteModeType, Function<MobilePlatformType, WebDriver>> MAP = new EnumMap<>(MobileRemoteModeType.class);
    private static final Function<MobilePlatformType, WebDriver> SELENIUM = browserType -> SeleniumGridFactory.getDriver(browserType);
    private static final Function<MobilePlatformType, WebDriver> BROWSER_STACK = browserType -> BrowserStackMobileFactory.getDriver(browserType);

    static{
        MAP.put(MobileRemoteModeType.SAUCE_LABS, SELENIUM);
        MAP.put(MobileRemoteModeType.BROWSER_STACK, BROWSER_STACK);

    }

    //More simplified using functional Programming
    public static WebDriver getDriver(MobileRemoteModeType browserRemoteModeType, MobilePlatformType platformType) {
        return MAP.get(browserRemoteModeType).apply(platformType);
    }

}
