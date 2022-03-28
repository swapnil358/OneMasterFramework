package com.tmb.driver.manager.web.remote.selenoid;

import com.tmb.config.converters.factory.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public final class SelenoidFirefoxManager {

    public static WebDriver getDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "firefox");
        capabilities.setCapability("browserVersion", "97.0");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);

        return new RemoteWebDriver(ConfigFactory.getConfig().selenoidURL(), capabilities);
    }
}