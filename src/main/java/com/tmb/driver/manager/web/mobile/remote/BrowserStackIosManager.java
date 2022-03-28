package com.tmb.driver.manager.web.mobile.remote;

import com.tmb.config.converters.factory.BrowserStackConfigFactory;
import com.tmb.driver.manager.web.remote.browserstack.BrowserStackChromeManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public final class BrowserStackIosManager {

    private BrowserStackIosManager() {

    }

    public static WebDriver getDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("app", "bs://c987w84thglfsjkgu9w45409u");
        capabilities.setCapability("device", "iphone 12");
        capabilities.setCapability("os_version", "9.0");
        capabilities.setCapability("project", "First Java Project");
        capabilities.setCapability("build", "browserstack-build-1");
        capabilities.setCapability("name", "first_test");

        return new RemoteWebDriver(BrowserStackConfigFactory.getConfig().browserStackURL(), capabilities);
    }
}
