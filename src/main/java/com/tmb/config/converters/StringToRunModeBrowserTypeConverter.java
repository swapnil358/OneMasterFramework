package com.tmb.config.converters;

import com.tmb.enums.BrowserType;
import com.tmb.enums.RunModeBrowserType;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;
import java.util.Map;

public class StringToRunModeBrowserTypeConverter implements Converter<RunModeBrowserType> {


    @Override
    public RunModeBrowserType convert(Method method, String runMode) {
        return RunModeBrowserType.valueOf(runMode.toUpperCase());
    }

}
