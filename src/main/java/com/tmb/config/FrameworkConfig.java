package com.tmb.config;

import com.tmb.config.converters.StringToBrowserTypeConverter;
import com.tmb.config.converters.StringToRemoteModeBrowserConverter;
import com.tmb.config.converters.StringToRunModeBrowserTypeConverter;
import com.tmb.config.converters.StringToURLConverter;
import com.tmb.enums.BrowserRemoteModeType;
import com.tmb.enums.BrowserType;
import com.tmb.enums.RunModeBrowserType;
import org.aeonbits.owner.Config;

import java.net.URL;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        //It will check in system properties, if not found
        "system:properties",
        //will check in system environment, if not found
        "system:env",
        //will check in below path
        "file:${user.dir}/src/test/resources/config.properties"
})
public interface FrameworkConfig extends Config {

    //If browser value does not found it will pick from default value
    @DefaultValue("Chrome")
    //Converter class is used to map string value to BrowserType
    @ConverterClass(StringToBrowserTypeConverter.class)
    BrowserType browser();


    @Key("runModeBrowser")
    @ConverterClass(StringToRunModeBrowserTypeConverter.class)
    RunModeBrowserType browserRunMode();


    @Key("browserRemoteMode")
    @ConverterClass(StringToRemoteModeBrowserConverter.class)
    BrowserRemoteModeType browserRemoteMode();


    @Key("runModeMobile")
    @ConverterClass(StringToRunModeBrowserTypeConverter.class)
    RunModeBrowserType mobileRemote();


    @Key("mobileRemoteMode")
    @ConverterClass("")
    BrowserRemoteModeType mobileRemoteMode();


    //Instead of returning as String, returning as URL so that we don't need to bother to catch the exception on caller method
    // String seleniumGridURL();
    @ConverterClass(StringToURLConverter.class)
    URL seleniumGridURL();

    @ConverterClass(StringToURLConverter.class)
    URL selenoidURL();

    @ConverterClass((StringToURLConverter.class))
    @DefaultValue("http://127.0.0.1:4723/wd/hub")
    URL localAppiumServerURL();
}
