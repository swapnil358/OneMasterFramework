package com.tmb.config;

import com.tmb.config.converters.StringToBrowserTypeConverter;
import com.tmb.enums.BrowserRemoteModeType;
import com.tmb.enums.BrowserType;
import com.tmb.enums.RunModeBrowserType;
import org.aeonbits.owner.Config;

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
    RunModeBrowserType browserRunMode();


    @Key("browserRemoteMode")
    BrowserRemoteModeType browserRemoteMode();
}
