package com.tmb.config.converters;

import com.tmb.enums.BrowserType;
import org.aeonbits.owner.Converter;

import java.lang.reflect.Method;
import java.util.Map;

public class StringToBrowserTypeConverter implements Converter<BrowserType> {

//This is method will return feed only Chrome as value in config.properties, In case somebody passes FireFox then it will
//throw exception IllegalArgumentException

 /*
    @Override
    public BrowserType convert(Method method, String browserName) {
        return BrowserType.valueOf(browserName.toUpperCase());
    }

*/


   //Below method will map key value pair, if not somebody passes opera(which is not handled) it will not fail but
    //will take default method as CHROME

    public BrowserType convert(Method method, String browserName) {
        Map<String, BrowserType> stringBrowserTypeMap = Map.of("CHROME", BrowserType.CHROME,
                "FIREFOX", BrowserType.FIREFOX);
        return stringBrowserTypeMap.getOrDefault(browserName.toUpperCase(), BrowserType.CHROME);
    }



}
