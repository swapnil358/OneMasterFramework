package com.tmb.driver.factory.web.remote;

import com.tmb.config.converters.factory.ConfigFactory;
import com.tmb.enums.BrowserRemoteModeType;
import com.tmb.enums.BrowserType;
import org.openqa.selenium.WebDriver;

import java.util.EnumMap;
import java.util.Map;
import java.util.function.Function;

public class RemoteDriverFactory {

    private RemoteDriverFactory() {
    }

    private static final Map<BrowserRemoteModeType, Function<BrowserType,WebDriver>> MAP = new EnumMap<>(BrowserRemoteModeType.class);
    private static final Function<BrowserType, WebDriver> SELENIUM = browserType -> SeleniumGridFactory.getDriver(browserType);
    private static final Function<BrowserType, WebDriver> SELENOID = browserType -> SelenoidFactory.getDriver(browserType);
    private static final Function<BrowserType, WebDriver> BROWSER_STACK = browserType -> BrowserStackFactory.getDriver(browserType);

    static{
        MAP.put(BrowserRemoteModeType.SELENIUM, SELENIUM);
        MAP.put(BrowserRemoteModeType.SELENOID, SELENOID);
        MAP.put(BrowserRemoteModeType.BROWSER_STACK, BROWSER_STACK);
    }

    //More simplified using functional Programming
    public static WebDriver getDriver(BrowserRemoteModeType browserRemoteModeType, BrowserType browserType) {
        return MAP.get(browserRemoteModeType).apply(browserType);
    }





    //More simplified
    public static WebDriver getDriver2(BrowserRemoteModeType browserRemoteModeType, BrowserType browserType) {

        if (browserRemoteModeType == BrowserRemoteModeType.SELENIUM) {
            return SeleniumGridFactory.getDriver(browserType);
        } else if (browserRemoteModeType == BrowserRemoteModeType.SELENOID) {
            return SelenoidFactory.getDriver(browserType);
        } else if (browserRemoteModeType == BrowserRemoteModeType.BROWSER_STACK) {
            return BrowserStackFactory.getDriver(browserType);
        }

        return null;
    }


    public static WebDriver getDriver1() {
        BrowserRemoteModeType browserRemoteModeType = ConfigFactory.getConfig().browserRemoteMode();
        if (browserRemoteModeType == BrowserRemoteModeType.SELENIUM) {

        } else if (browserRemoteModeType == BrowserRemoteModeType.SELENOID) {

        } else {

        }

        return null;
    }

}
